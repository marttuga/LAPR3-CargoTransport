package lapr.project.model.Location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void getLocationID() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals("l",l.getLocationID());
    }

    @Test
    void getLocationID2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals("o",l.getLocationID());
    }

    @Test
    void setLocationID() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setLocationID("s");
        assertEquals("s",l.getLocationID());
    }

    @Test
    void getType() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals("j",l.getType());
    }

    @Test
    void getType2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals("i",l.getType());
    }

    @Test
    void setType() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setType("h");
        assertEquals("h",l.getType());
    }

    @Test
    void getName() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals("h",l.getName());
    }

    @Test
    void getName2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals("u",l.getName());
    }

    @Test
    void setName() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setName("g");
        assertEquals("g",l.getName());
    }

    @Test
    void getPositionID() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals(1,l.getPositionID());
    }

    @Test
    void getPositionID2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals(12,l.getPositionID());
    }

    @Test
    void setPositionID() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setPositionID(2);
        assertEquals(2,l.getPositionID());
    }

    @Test
    void getCountry() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals("f",l.getCountry());
    }

    @Test
    void getCountry2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals("y",l.getCountry());
    }

    @Test
    void setCountry() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setCountry("l");
        assertEquals("l",l.getCountry());
    }

    @Test
    void getTripID() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals(1,l.getTripID());
    }

    @Test
    void getTripID2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals(13,l.getTripID());
    }

    @Test
    void setTripID() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setTripID(2);
        assertEquals(2,l.getTripID());
    }

    @Test
    void getCapacity() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals(1,l.getCapacity());
    }

    @Test
    void getCapacity2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals(13,l.getCapacity());
    }

    @Test
    void setCapacity() {
        Location l=new Location("l","j","h",1,"f",1,1);
        l.setCapacity(2);
        assertEquals(2,l.getCapacity());
    }

    @Test
    void testEquals() {
        Location l=new Location("l","j","h",1,"f",1,1);
        Location n=null;
        assertNotEquals(l,n);
    }

    @Test
    void testEquals2() {
        Location l=new Location("l","j","h",1,"f",1,1);
        Location n=new Location("l", "j", "h", 1,"f",1,1);
        assertEquals(l,n);
    }

    @Test
    void testEquals3() {
        Location l=null;
        Location n=null;
        assertEquals(l,n);
    }

    @Test
    void testHashCode() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals(1939824110,l.hashCode());
    }

    @Test
    void testHashCodeNull() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertNotEquals(0,l.hashCode());
    }

    @Test
    void testToString() {
        Location l=new Location("l","j","h",1,"f",1,1);
        assertEquals("\nLocation{locationID='l', type='j', name='h', positionID=1, country='f', tripID=1, capacity=1}\n",l.toString());
    }
}