SET SERVEROUTPUT ON;

drop function occupancyRateManifest;

create or replace function occupancyRateManifest(ship_mmsi integer, startDate DATE, endDate DATE)
return VARCHAR
is
vContainersManifestOffload integer; 
vContainersManifestLoad integer; 
vShipCapacity integer;
vContainerShip integer;
result integer;

begin

    select capacity into vShipCapacity
    from SHIP s
    where s.MMSI = ship_mmsi;
      
    select count(CONTAINER_ID) into vContainersManifestLoad
    from CONTAINER_CARGO_MANIFEST ccm
    INNER JOIN  CARGO_MANIFEST cm ON cm.CARGO_MANIFEST_ID = ccm.CARGO_MANIFEST_ID
    INNER JOIN  VEHICLE v ON v.VEHICLE_ID = cm.VEHICLE_ID
    INNER JOIN  SHIP s ON s.VEHICLE_ID = v.VEHICLE_ID WHERE cm.type='loaded' AND s.MMSI = ship_mmsi AND cm.MANIFEST_DATE BETWEEN startDate AND endDate;
    
    
    select count(CONTAINER_ID) into vContainersManifestOffload
    from CONTAINER_CARGO_MANIFEST ccm
    INNER JOIN  CARGO_MANIFEST cm ON cm.CARGO_MANIFEST_ID = ccm.CARGO_MANIFEST_ID
    INNER JOIN  VEHICLE v ON v.VEHICLE_ID = cm.VEHICLE_ID
    INNER JOIN  SHIP s ON s.VEHICLE_ID = v.VEHICLE_ID WHERE cm.type='offloaded' AND s.MMSI = ship_mmsi AND cm.MANIFEST_DATE BETWEEN startDate AND endDate;
    
    select count(container_id) into vContainerShip
    from ship_container 
    where MMSI = ship_mmsi;

result := (((vContainerShip - vContainersManifestLoad + vContainersManifestOffload )/vShipCapacity)*100);
return result;

end;

BEGIN 
DBMS_OUTPUT.PUT_LINE(occupancyRateManifest(212351000,'2020-12-17','2020-12-19'));
END;

