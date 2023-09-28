package lapr.project.model.trip;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class StopsTest {

    @Test
    void getDepartureDate() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),s.getDepartureDateStops());
    }

    @Test
    void setDepartureDate() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        s.setDepartureDateStops(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10"));
        assertEquals((new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10")),s.getDepartureDateStops());
    }

    @Test
    void getArrivalDate() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),s.getArrivalDateStops());
    }

    @Test
    void setArrivalDate() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        s.setArrivalDateStops(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10"));
        assertEquals((new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10")),s.getArrivalDateStops());

    }

    @Test
    void getName() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertEquals("e",s.getName());
    }

    @Test
    void getName2() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertNotEquals("a",s.getName());
    }

    @Test
    void setName() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        s.setName("D");
        assertEquals("D",s.getName());
    }

    @Test
    void getTripID() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertEquals(1,s.getTripID());
    }

    @Test
    void getTripID2() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertNotEquals(2,s.getTripID());
    }

    @Test
    void setTripID() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        s.setTripID(2);
        assertEquals(2,s.getTripID());
    }

    @Test
    void testEquals() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        Stops d= null;
        assertNotEquals(s,d);
    }

    @Test
    void testEquals2() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        Stops d= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertEquals(s,d);
    }

    @Test
    void testEquals3() {
        Stops s= null;
        Stops d= null;
        assertEquals(s,d);
    }

    @Test
    void testHashCode() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertEquals(-2067028099,s.hashCode());
    }

    @Test
    void testHashCodeNull() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertNotEquals(0,s.hashCode());
    }

    @Test
    void testToString() throws ParseException {
        Stops s= new Stops("e",1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"));
        assertNotEquals("Stops{', tripID=1, departureDateStops=Tue Dec 01 17:19:00 WET 2020, arrivalDateStops=Thu Dec 31 17:19:00 WET 2020}",s.toString());
    }
}