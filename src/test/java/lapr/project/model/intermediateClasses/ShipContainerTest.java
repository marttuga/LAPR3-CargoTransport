package lapr.project.model.intermediateClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipContainerTest {

    @Test
    void getContainerID() {
        ShipContainer s=new ShipContainer(1,1);
        assertEquals(1,s.getContainerID());
    }
    @Test
    void getContainerID2() {
        ShipContainer s=new ShipContainer(1,1);
        assertNotEquals(2,s.getContainerID());
    }

    @Test
    void setContainerID() {
        ShipContainer s=new ShipContainer(1,1);
        s.setContainerID(2);
        assertEquals(2,s.getContainerID());
    }

    @Test
    void getmMSI() {
        ShipContainer s=new ShipContainer(1,111111111);
        assertEquals(111111111,s.getmMSI());
    }
    @Test
    void getmMSI2() {
        ShipContainer s=new ShipContainer(1,111111111);
        assertNotEquals(7,s.getmMSI());
    }

    @Test
    void setmMSI() {
        ShipContainer s=new ShipContainer(1,111111111);
        s.setmMSI(2);
        assertEquals(2,s.getmMSI());
    }

    @Test
    void testEquals() {
        ShipContainer s=new ShipContainer(1,111111111);
        ShipContainer d=new ShipContainer(1,111111111);
        assertEquals(s,d);
    }
    @Test
    void testEquals2() {
        ShipContainer s=new ShipContainer(1,111111111);
        ShipContainer d=null;
        assertNotEquals(s,d);
    }

    @Test
    void testHashCode() {
        ShipContainer s=new ShipContainer(1,111111111);
        assertEquals(111112103,s.hashCode());
    }
    @Test
    void testHashCode2() {
        ShipContainer s=new ShipContainer(1,111111111);
        assertNotEquals(12103,s.hashCode());
    }

    @Test
    void testToString() {
        ShipContainer s=new ShipContainer(1,111111111);
        assertEquals("ShipContainer{containerID=1, mMSI=111111111}",s.toString());
    }
}