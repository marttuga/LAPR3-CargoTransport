SET SERVEROUTPUT ON;

DROP TRIGGER trgMaxCapacity;

create or replace trigger trgMaxCapacity
before insert on container_cargo_manifest
for each row
declare

    vWarehouseID VARCHAR(25);
    vNumContainersManifest INTEGER;
    vCapacity INTEGER;
    exMaxCapacityReached exception;

begin 
    
    
    select location_id, capacity into vWarehouseID, vCapacity from location where trip_id = (select trip_id 
    from trip t
    where t.trip_id = (select trip_id from stops s
    where s.stops_name = ( select stops_name from cargo_manifest cm
    where cm.cargo_manifest_id = :new.cargo_manifest_id)));

    select count(CONTAINER_ID) into vNumContainersManifest
    from CONTAINER_CARGO_MANIFEST ccm
    where ccm.CARGO_MANIFEST_ID = (select CARGO_MANIFEST_ID from CARGO_MANIFEST cm
                                                         where cm.STOPS_NAME = (select STOPS_NAME from STOPS s
                                                    where s.TRIP_ID = (select TRIP_ID
                                                                    from TRIP t
                                                                    where t.TRIP_ID = (select TRIP_ID
                                                                                    from LOCATION l
                                                                                    where l.LOCATION_ID = vWarehouseID))));
                                                                                    
      if (vNumContainersManifest >= vCapacity) then
            raise exMaxCapacityReached;
      end if;
      
exception
    
    when exMaxCapacityReached then
        raise_application_error(-20000, 'Max Warehouse capacity reached');
        
end;

    
                                                                                
--Inserts needed
INSERT INTO TRIP(TRIP_ID, DEPARTURE, ARRIVAL, DEPARTURE_DATE, ARRIVAL_DATE)
VALUES('50', 'Barcelona', 'Lisboa', '2022-01-02', '2022-01-10');

INSERT INTO LOCATION(LOCATION_ID, NAME, POSITION_ID, COUNTRY, TYPE, TRIP_ID, CAPACITY)
VALUES('098765', 'Lisbon','445419', 'Portugal', 'warehouse', '50', '2');

INSERT INTO STOPS(STOPS_NAME, TRIP_ID)
VALUES ('Lisboa','50');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('123456', '397', '299', '325', 'leased', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('654321', '423', '457', '632', 'bought', '22G1');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('012345', '253', '472', '563', 'leased', '22G1');

INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE, STOPS_NAME, VEHICLE_ID )
VALUES('987654', '457','2022-01-10', 'offloaded','Lisboa', '65487');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('123456', '987654', '1', '2', '3', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('654321', '987654', '5', '3', '4', 'Lisboa');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('012345', '987654', '9', '4', '5', 'Lisboa');


