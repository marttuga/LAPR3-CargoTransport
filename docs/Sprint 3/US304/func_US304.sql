SET SERVEROUTPUT ON;

drop function func_auditrail;

CREATE OR REPLACE FUNCTION func_auditrail
(p_container_id container.container_id%type, p_cargo_manifest_id cargo_manifest.cargo_manifest_id%type)
return sys_refcursor

AS
auditrail sys_refcursor;

BEGIN
OPEN auditrail FOR

SELECT CONTAINER_ID, CARGO_MANIFEST_ID, USERNAME, TYPE_OPERATION, DATE_TIME_OPERATION
FROM AUDIT_TRAIL
ORDER BY EXTRACT(HOUR FROM DATE_TIME_OPERATION);

return(auditrail);
END;


--FUNCAO
CREATE OR REPLACE FUNCTION func_cursor
return sys_refcursor

AS
containerId container.container_id%type;
cargoManifestId cargo_manifest.cargo_manifest_id%type;
username userr.username%type;
typeOperation audit_trail.type_operation%type;
dateTimeOperation audit_trail.date_time_operation%type;
c_cursorat sys_refcursor;

BEGIN

c_cursorat := func_auditrail(647585,765433);
LOOP
    FETCH c_cursorat INTO containerId,cargoManifestId,username,typeOperation,dateTimeOperation;
    EXIT WHEN c_cursorat%notfound;
        dbms_output.put_line(containerId||cargoManifestId||username||typeOperation||dateTimeOperation);
    END LOOP;
CLOSE c_cursorat;
END;


--INSERTS NEEDED

INSERT INTO TRIP(TRIP_ID, DEPARTURE, ARRIVAL, DEPARTURE_DATE, ARRIVAL_DATE)
VALUES('51', 'Barcelona', 'Lisboa', '2022-01-02', '2022-01-10');

INSERT INTO LOCATION(LOCATION_ID, NAME, POSITION_ID, COUNTRY, TYPE, TRIP_ID, CAPACITY)
VALUES('834527', 'Lisbon','445419', 'Portugal', 'port', '50', '20');

INSERT INTO STOPS(STOPS_NAME, TRIP_ID)
VALUES ('Lisboa','51');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('123457', '397', '299', '325', 'leased', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('654322', '423', '457', '632', 'bought', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('012346', '253', '472', '563', 'leased', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('647585', '642', '485', '721', 'leased', '22G1');

INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE, STOPS_NAME, VEHICLE_ID )
VALUES('987655', '457','2022-01-10', 'offloaded','Lisboa', '65487');

INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE, STOPS_NAME, VEHICLE_ID )
VALUES('765433', '653','2022-01-21', 'loaded','Lisboa', '20323');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('123457', '987655', '1', '2', '3', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('654322', '987655', '5', '3', '4', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('012346', '987655', '9', '4', '5', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('647585', '765433', '4', '2', '3', 'Lisboa');

DELETE FROM CONTAINER_CARGO_MANIFEST ccm
WHERE ccm.CONTAINER_ID = '647585'
