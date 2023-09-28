package lapr.project.model.trip;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    @Test
    void getDepartureDate() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),t.getDepartureDate());
    }

    @Test
    void setDepartureDate() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        t.setDepartureDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10"));
        assertEquals((new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10")),t.getDepartureDate());
    }

    @Test
    void getShipMmsi() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        assertEquals("1",t.getShipMMSI());
    }

    @Test
    void setShipMmsi() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        t.setShipMMSI("2");
        assertEquals("2",t.getShipMMSI());
    }
    @Test
    void getArrivalDate() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),t.getArrivalDate());
    }

    @Test
    void setArrivalDate() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        t.setArrivalDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10"));
        assertEquals((new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:10")),t.getArrivalDate());

    }
    @Test
    void getTripID() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");
        assertEquals(1,t.getTripID());
    }

    @Test
    void getTripID2() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertNotEquals(2,t.getTripID());
    }

    @Test
    void setTripID() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        t.setTripID(2);
        assertEquals(2,t.getTripID());
    }

    @Test
    void getDeparture() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertEquals("e",t.getDeparture());
    }

    @Test
    void getDeparture2() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertNotEquals("b",t.getDeparture());
    }

    @Test
    void setDeparture() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        t.setDeparture("d");
        assertEquals("d",t.getDeparture());
    }

    @Test
    void getArrival() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertEquals("e",t.getArrival());
    }

    @Test
    void getArrival2() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertNotEquals("c",t.getArrival());
    }

    @Test
    void setArrival() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        t.setArrival("f");
        assertEquals("f",t.getArrival());
    }
    @Test
    void getVehicleID() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertEquals("12345",t.getVehicleID());
    }

    @Test
    void getVehicleID2() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertNotEquals("1234",t.getVehicleID());
    }

    @Test
    void setVehicleID() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        t.setArrival("f");
        assertEquals("12345",t.getVehicleID());
    }

    @Test
    void testEquals() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        Trip g=null;
        assertNotEquals(g,t);
    }

    @Test
    void testEquals2() throws ParseException {
        Trip g=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertEquals(g,t);
    }

    @Test
    void testEquals3() {
        Trip t=null;
        Trip g=null;
        assertEquals(g,t);
    }

    @Test
    void testHashCode() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertEquals(1146625502,t.hashCode());
    }

    @Test
    void testHashCodeNull() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertNotEquals(0,t.hashCode());
    }

    @Test
    void testToString() throws ParseException {
        Trip t=new Trip(1,"e","e", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),"12345","1");

        assertNotEquals(" startTrip",t.toString());
        
    }
}