--US210
SET SERVEROUTPUT ON;

DROP FUNCTION func_ships_available;

CREATE OR REPLACE FUNCTION func_ships_available (data_esc date) 
return sys_refcursor

AS
v_monday date;
available_ships sys_refcursor;

BEGIN

SELECT MAX(NEXT_DAY(TRUNC(v_monday), 2)) INTO v_monday
FROM SHIP ;

OPEN available_ships FOR

SELECT a.mmsi, (select position.latitude from position
                        WHERE position_id = (select position_id from POSITIONAL_MESSAGES p
                        WHERE baseDateTime = (SELECT Max(baseDateTime) FROM POSITIONAL_MESSAGES p
                                        WHERE p.mmsi = a.mmsi ))) as latitude
                        
                      , (select position.longitude from POSITION
                        WHERE position_id = (select position_id from POSITIONAL_MESSAGES p
                        WHERE baseDateTime = (SELECT Max(baseDateTime) FROM POSITIONAL_MESSAGES p
                                        WHERE p.mmsi = a.mmsi ))) as longitude

FROM SHIP a
where a.mmsi NOT IN (SELECT p.mmsi from POSITIONAL_MESSAGES p
                    WHERE position_id = (select position_id from POSITIONAL_MESSAGES p
                    WHERE position_id = (select position_id from LOCATION l
                    WHERE trip_id = (select trip_id from LOCATION l
                    WHERE trip_id = (select trip_id from TRIP t
                    WHERE arrival_date = (select arrival_date from TRIP t
                    WHERE t.arrival_date > v_monday))))));

return(available_ships);
END;





--BEGIN
--DBMS_OUTPUT.PUT_LINE(func_ships_available(sysdate));
--END;