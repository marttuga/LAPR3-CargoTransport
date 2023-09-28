SET SERVEROUTPUT ON;

drop function portOccupation;

create or replace function portOccupation(port_id integer, vMonth integer)
return VARCHAR
is
vContainersOffloaded integer; 
vContainersloaded integer;
vCapacity integer;
result VARCHAR(100);

begin

    select capacity into vCapacity from location where location_id=port_id;
    
    select count(CONTAINER_ID) into vContainersOffloaded
    from CONTAINER_CARGO_MANIFEST ccm
    where ccm.CARGO_MANIFEST_ID = (select CARGO_MANIFEST_ID from CARGO_MANIFEST cm
                                                             where cm.STOPS_NAME = (select STOPS_NAME from STOPS s
                                                             where s.TRIP_ID = (select TRIP_ID
                                                                        from TRIP t
                                                                        where t.TRIP_ID = (select TRIP_ID
                                                                                        from LOCATION l
                                                                                        where l.LOCATION_ID = port_id)))and extract (month from cm.manifest_date)= vMonth and cm.type='offloaded');
                                                                                        
     select count(CONTAINER_ID) into vContainersloaded
    from CONTAINER_CARGO_MANIFEST ccm
    where ccm.CARGO_MANIFEST_ID = (select CARGO_MANIFEST_ID from CARGO_MANIFEST cm
                                                             where cm.STOPS_NAME = (select STOPS_NAME from STOPS s
                                                        where s.TRIP_ID = (select TRIP_ID
                                                                        from TRIP t
                                                                        where t.TRIP_ID = (select TRIP_ID
                                                                                        from LOCATION l
                                                                                        where l.LOCATION_ID = port_id)))and extract (month from cm.manifest_date)= vMonth and cm.type='loaded');
    result :=  'Occupancy rate for port "' || port_id || '" in the month of '|| vMonth ||' is '|| ((vcontainersoffloaded - vContainersloaded)/vCapacity)*100 || '%.';
    return result;
    
end; 

BEGIN 
DBMS_OUTPUT.PUT_LINE(portOccupation(834526,1));
END;


INSERT INTO TRIP(TRIP_ID, DEPARTURE, ARRIVAL, DEPARTURE_DATE, ARRIVAL_DATE)
VALUES('50', 'Barcelona', 'Lisboa', '2022-01-02', '2022-01-10');

INSERT INTO LOCATION(LOCATION_ID, NAME, POSITION_ID, COUNTRY, TYPE, TRIP_ID, CAPACITY)
VALUES('834526', 'Lisbon','445419', 'Portugal', 'port', '50', '20');

INSERT INTO STOPS(STOPS_NAME, TRIP_ID)
VALUES ('Lisboa','50');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('123456', '397', '299', '325', 'leased', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('654321', '423', '457', '632', 'bought', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('012345', '253', '472', '563', 'leased', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('647584', '642', '485', '721', 'leased', '22G1');

INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE, STOPS_NAME, VEHICLE_ID )
VALUES('987654', '457','2022-01-10', 'offloaded','Lisboa', '65487');

INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE, STOPS_NAME, VEHICLE_ID )
VALUES('765432', '653','2022-01-21', 'loaded','Lisboa', '20323');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('123456', '987654', '1', '2', '3', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('654321', '987654', '5', '3', '4', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('012345', '987654', '9', '4', '5', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('647584', '765432', '4', '2', '3', 'Lisboa');
