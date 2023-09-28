package lapr.project.model.intermediateClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipLocationTest {

    @Test
    void getLocationID() {
        ShipLocation s =new ShipLocation(1,"l");
        assertEquals("l",s.getLocationID());
    }

    @Test
    void getLocationID2() {
        ShipLocation s =new ShipLocation(1,"l");
        assertNotEquals("r",s.getLocationID());
    }

    @Test
    void setLocationID() {
        ShipLocation s =new ShipLocation(1,"l");
        s.setLocationID("t");
        assertEquals("t",s.getLocationID());
    }

    @Test
    void getmMSI() {
        ShipLocation s =new ShipLocation(1,"l");
        assertEquals(1,s.getmMSI());
    }

    @Test
    void getmMSI2() {
        ShipLocation s =new ShipLocation(1,"l");
        assertNotEquals(4,s.getmMSI());
    }

    @Test
    void setmMSI() {
        ShipLocation s =new ShipLocation(1,"l");
        s.setmMSI(5);
        assertEquals(5,s.getmMSI());
    }

    @Test
    void testEquals() {
        ShipLocation s =new ShipLocation(1,"l");
        ShipLocation s1 =new ShipLocation(1,"l");
        assertEquals(s,s1);
    }

    @Test
    void testEquals2() {
        ShipLocation s =null;
        ShipLocation s1 =null;
        assertEquals(s,s1);
    }

    @Test
    void testEquals3() {
        ShipLocation s =new ShipLocation(1,"l");
        ShipLocation s1 =null;
        assertNotEquals(s,s1);
    }

    @Test
    void testHashCode() {
        ShipLocation s =new ShipLocation(1,"l");
        assertEquals(1100,s.hashCode());
    }

    @Test
    void testHashCodeNull() {
        ShipLocation s =new ShipLocation(1,"l");
        assertNotEquals(0,s.hashCode());
    }

    @Test
    void testToString() {
        ShipLocation s =new ShipLocation(1,"l");
        assertEquals("ShipLocation:mMSI= 1, locationID= 'l'",s.toString());
    }
}