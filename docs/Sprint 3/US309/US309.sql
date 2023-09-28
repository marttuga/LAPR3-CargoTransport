drop trigger trgg_regist_cargo_manifest;
create or replace trigger trgg_regist_cargo_manifest
 before insert on container_cargo_manifest
 for each row
 declare 

 v_manifest_date date;
 v_arrival_date date;
  v_departure_date date;
 v_ship_mmsi VARCHAR(100);
 EX_ERRO EXCEPTION;
v_vehicle_id_cargo integer;
 BEGIN
-- 

select vehicle_id into v_vehicle_id_cargo from cargo_manifest cm where
  cm.cargo_manifest_id=:new.cargo_manifest_id;

select m.manifest_date into v_manifest_date from cargo_manifest m 
where m.cargo_manifest_id=:new.cargo_manifest_id;

select departure_date,arrival_date into  v_departure_date,v_arrival_date  
from trip t  where t.vehicle_id=v_vehicle_id_cargo;


 if v_manifest_date between v_departure_date and v_arrival_date
 then raise EX_ERRO; 
 delete cargo_manifest where (manifest_date between v_departure_date and v_arrival_date);
 end if;

 SELECT mmsi into v_ship_mmsi
 FROM Ship WHERE vehicle_id=v_vehicle_id_cargo;

 exception
 
   when EX_ERRO then
   raise_application_error(-20000,'Occupied- Ship is already in transit');
  
END;



INSERT INTO VEHICLE (VEHICLE_ID)
VALUES('12346');

INSERT INTO TRIP(TRIP_ID,VEHICLE_ID, DEPARTURE, ARRIVAL, DEPARTURE_DATE, ARRIVAL_DATE )
VALUES('60','12346','Angola', 'Cape Verde', '2020-12-03', '2020-12-06');

INSERT INTO SHIP (MMSI, IMO, CALLSIGN, VESSEL_TYPE, NAME, CAPACITY, DRAFT, WIDTH, LENGTH ,NUM_GENERATORS,VEHICLE_ID)
VALUES ('210950001', 'NKNIUyR', '10146', '1', 'SHIP', '20','1,20', '50', '30', '2','12346');

INSERT INTO STOPS(STOPS_NAME, TRIP_ID)
VALUES ('lk','60');



INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE,VEHICLE_ID, STOPS_NAME )
VALUES('56747', '234','2020-12-04', 'offloaded','12346', 'lk');

INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)
VALUES('345514', '4,29', '3,41', '1,90', 'LEASING', '22G2');

INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)
VALUES('345514', '56747', '1', '2', '3', 'CASCAIS');


