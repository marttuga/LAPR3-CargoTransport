SET SERVEROUTPUT ON;

DROP FUNCTION fnc_get_Container;



create or replace function fnc_get_Container(container_idd in integer) return VARCHAR
is 

v_container_type VARCHAR(100);
    v_result VARCHAR(100);
    v_container_counter INTEGER;
    v_ship_name VARCHAR(100);
    v_location VARCHAR(100);
    
    CURSOR cr1 IS
    SELECT name FROM Ship 
    WHERE mmsi = (SELECT mmsi FROM cargo_manifest cm
                    WHERE cm.cargo_manifest_id = (SELECT cargo_manifest_id FROM container_cargo_manifest 
                     WHERE container_id = (SELECT container_id FROM container
                      WHERE container_id = container_idd)) AND cm.type = 'offloaded');
          
    CURSOR cr2 IS
    SELECT stops_name from stops
    WHERE stops_name = (SELECT stops_name from cargo_manifest cm
                             WHERE cm.cargo_manifest_id = (SELECT cargo_manifest_id FROM container_cargo_manifest 
                                WHERE container_id = (SELECT container_id FROM container
                                    WHERE container_id = container_idd)) AND cm.type = 'loaded');
    

BEGIN

    SELECT COUNT(*) into v_container_counter
        FROM Container
    WHERE container_id = container_idd;
    IF v_container_counter = 0 THEN
        return NULL;
    end if;
    
     SELECT type into v_container_type
        From container
        WHERE container_id = container_idd;
    
    open cr1;
    fetch cr1 into v_ship_name;
    close cr1;
    
    if v_ship_name is not null then
         v_result := v_container_type || 'SHIP,' || v_ship_name; 
        return v_result;
    end if;
    
    open cr2;
    fetch cr2 into v_location;
    close cr2;
    
    if v_location is not null then
        v_result := v_container_type || 'PORT,' || v_location; 
        return v_result;
    end if;
    
    
    return null;    

   exception
   
   when others then
   
   return null;
   
end;
              
BEGIN 
DBMS_OUTPUT.PUT_LINE(fnc_get_Container(209833));
END;
--