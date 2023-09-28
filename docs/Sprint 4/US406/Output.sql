Declare
    v_TRIP_ID INTEGER; 
    v_DEPARTURE CHAR(25);
    v_ARRIVAL CHAR(25);
    v_DEPARTURE_DATE DATE;
    v_ARRIVAL_DATE DATE;
    c_trips sys_refcursor;
    
BEGIN
    dbms_output.put_line('Ship voyages: ' || 212351000);
    
    c_trips := func_get_Trips(212351000);
    
    loop
        fetch c_trips INTO v_TRIP_ID, v_DEPARTURE, v_ARRIVAL, v_DEPARTURE_DATE, v_ARRIVAL_DATE;
        Exit when c_trips%NOTFOUND;
        dbms_output.put_line('Trip ID: ' || v_TRIP_ID || '|'
                            || 'Departure: ' || v_DEPARTURE || '|'
                            || 'Arrival: ' || v_ARRIVAL || '|'
                            || 'Departure date: ' || v_DEPARTURE_DATE || '|'
                            || 'Arrival date: ' || v_ARRIVAL_DATE);
        
    END loop;
    close c_trips;
end;