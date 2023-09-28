
--When the provided identifier is not valid or, being valid, is not leased by
--the client, a warning is returned. This warning has two elements, the
--error code and the identifier of the container. The error code will be: 
--10- invalid container id or 11 ? container is not leased by client

SET SERVEROUTPUT ON;

DROP FUNCTION fnc_get_Container_Warning;



create or replace function fnc_get_Container_Warning(container_idd in integer) return VARCHAR
is 

v_container_id integer;
v_container_type VARCHAR(100);
    v_result VARCHAR(100);
    v_container_counter INTEGER;
    v_ship_name VARCHAR(100);
    v_location VARCHAR(100);
     EX_ERRO10 EXCEPTION;
  EX_ERRO11 EXCEPTION;
    
    CURSOR cr1 IS
    SELECT name FROM Ship 
    WHERE vehicle_id = (SELECT vehicle_id FROM cargo_manifest cm
                    WHERE cm.cargo_manifest_id = (SELECT cargo_manifest_id FROM container_cargo_manifest 
                     WHERE container_id = (SELECT container_id FROM container 
                      WHERE container_id = container_idd)) AND cm.type = 'offloaded');
          
    CURSOR cr2 IS
    SELECT stops_name from stops
    WHERE stops_name = (SELECT stops_name from cargo_manifest cm
                             WHERE cm.cargo_manifest_id = (SELECT cargo_manifest_id FROM container_cargo_manifest 
                                WHERE container_id = (SELECT container_id FROM container 
                                    WHERE container_id = container_idd)) AND cm.type = 'loaded'  );
    

BEGIN

    SELECT COUNT(*) into v_container_counter --verifica se o container existe ou nao 
        FROM Container
    WHERE container_id = container_idd;
    IF v_container_counter = 0 THEN
        raise EX_ERRO10 ;
    end if;
    
        SELECT type into v_container_type
        From container
        WHERE container_id = container_idd;
        
        if v_container_type <> 'leased' then
         raise EX_ERRO11;
        end if;
    
    
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
   
   when EX_ERRO10 then
   raise_application_error(-20000,'10-invalid container id');
   

   when EX_ERRO11 then
   raise_application_error(-20001,'11-container is not leased by client');
   
    when others then
   
   return null;
end;
 
--DBMS_OUTPUT.PUT_LINE(fnc_get_Container_Warning(200031));
                
BEGIN 
DBMS_OUTPUT.PUT_LINE(fnc_get_Container_Warning(450032));

END;
--

