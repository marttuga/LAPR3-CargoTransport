package lapr.project.model.intermediateClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffShipTest {

    @Test
    void getmMSI() {
        StaffShip s =new StaffShip(1,1);
        assertEquals(1,s.getmMSI());
    }

    @Test
    void getmMSI2() {
        StaffShip s =new StaffShip(1,1);
        assertNotEquals(3,s.getmMSI());
    }

    @Test
    void setmMSI() {
        StaffShip s =new StaffShip(1,1);
        s.setmMSI(3);
        assertEquals(3,s.getmMSI());
    }

    @Test
    void getStaffID() {
        StaffShip s =new StaffShip(1,1);
        assertEquals(1,s.getStaffID());
    }

    @Test
    void getStaffID2() {
        StaffShip s =new StaffShip(1,1);
        assertNotEquals(2,s.getStaffID());
    }

    @Test
    void setStaffID() {
        StaffShip s =new StaffShip(1,1);
        s.setStaffID(3);
        assertEquals(3,s.getStaffID());
    }

    @Test
    void testEquals() {
        StaffShip s =new StaffShip(1,1);
        StaffShip s1 =new StaffShip(1,1);
        assertEquals(s,s1);
    }

    @Test
    void testEquals2() {
        StaffShip s =new StaffShip(1,1);
        StaffShip s1 =null;
        assertNotEquals(s,s1);
    }

    @Test
    void testEquals3() {
        StaffShip s =null;
        StaffShip s1 =null;
        assertEquals(s,s1);
    }

    @Test
    void testHashCode() {
        StaffShip s =new StaffShip(1,1);
        assertEquals(993, s.hashCode());
    }

    @Test
    void testHashCodeNull() {
        StaffShip s =new StaffShip(1,1);
        assertNotEquals(0, s.hashCode());
    }

    @Test
    void testToString() {
        StaffShip s =new StaffShip(1,1);
        assertEquals("StaffShip:mMSI=1, staffID=1",s.toString());
    }
}