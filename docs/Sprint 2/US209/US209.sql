-- US209 --

SET SERVEROUTPUT ON;

DROP FUNCTION getOccupancyRateMoment;
CREATE OR REPLACE FUNCTION getOccupancyRateMoment(v_MMSI SHIP.MMSI%TYPE, v_CARGO_MANIFEST_ID CARGO_MANIFEST.CARGO_MANIFEST_ID%TYPE)
RETURN NUMBER IS 
v_occupancyRate INTEGER;

BEGIN

SELECT ((SELECT COUNT(*)
    FROM CONTAINER_CARGO_MANIFEST
    WHERE CARGO_MANIFEST_ID = v_CARGO_MANIFEST_ID) / a.CAPACITY) * 100 AS "OCCUPANCY RATE(%)" INTO v_occupancyRate
FROM SHIP a, CARGO_MANIFEST b
WHERE a.MMSI = v_MMSI
AND a.MMSI = b.MMSI
AND b.MANIFEST_DATE = SYSDATE
AND b.CARGO_MANIFEST_ID = v_CARGO_MANIFEST_ID;

RETURN v_occupancyRate;
END;

BEGIN
DBMS_OUTPUT.PUT_LINE(getOccupancyRateMoment(303221000, 65432));
END;


--65432
--303221000