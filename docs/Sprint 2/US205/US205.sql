

SET SERVEROUTPUT ON;

DROP FUNCTION fncgetcontainersoffloaded

CREATE OR REPLACE FUNCTION fncgetcontainersoffloaded 
RETURN SYS_REFCURSOR
IS
    REFC SYS_REFCURSOR;
    
BEGIN
    OPEN REFC FOR
        SELECT c.CONTAINER_ID, c.TYPE, c.PAYLOAD, ccm.x, ccm.y, ccm.z, ccm.UNLOADING_LOCATION, t.ARRIVAL
        FROM CONTAINER c, CONTAINER_CARGO_MANIFEST ccm
        INNER JOIN CARGO_MANIFEST cm ON cm.CARGO_MANIFEST_ID = ccm.CARGO_MANIFEST_ID
        INNER JOIN STOPS ss ON ss.STOPS_NAME = cm.STOPS_NAME
        INNER JOIN TRIP t ON ss.TRIP_ID = t.TRIP_ID
        WHERE cm.TYPE = 'offloaded'
        AND ccm.CONTAINER_ID = c.CONTAINER_ID
        AND t.ARRIVAL = 'Belgium';
    RETURN REFC;
END;








