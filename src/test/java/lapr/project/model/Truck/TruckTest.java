package lapr.project.model.Truck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void getTruckID() {
        Truck t=new Truck(1,1,"y");
        assertEquals(1,t.getTruckID());

    }
    @Test
    void getTruckID2() {
        Truck t=new Truck(1,1,"y");
        assertNotEquals(5,t.getTruckID());

    }
    @Test
    void setTruckID() {
        Truck t=new Truck(1,1,"y");
        t.setTruckID(2);
        assertEquals(2,t.getTruckID());
    }

    @Test
    void getLicensePlate() {
        Truck t=new Truck(1,1,"y");
        assertEquals(1,t.getLicensePlate());
    }
    @Test
    void getLicensePlate2() {
        Truck t=new Truck(1,1,"y");
        assertNotEquals(5,t.getLicensePlate());
    }

    @Test
    void setLicensePlate() {
        Truck t=new Truck(1,1,"y");
        t.setLicensePlate(3);
        assertEquals(3,t.getLicensePlate());
    }

    @Test
    void getName() {
        Truck t=new Truck(1,1,"y");
        assertEquals("y",t.getName());
    }
    @Test
    void getName2() {
        Truck t=new Truck(1,1,"y");
        assertNotEquals("r",t.getName());
    }

    @Test
    void setName() {
        Truck t=new Truck(1,1,"y");
        t.setName("t");
        assertEquals("t",t.getName());
    }

    @Test
    void testEquals() {
        Truck t=new Truck(1,1,"y");
        Truck f=new Truck(1,1,"y");
        assertEquals(f,t);
    }
    @Test
    void testEquals2() {
        Truck t=new Truck(1,1,"y");
        Truck f=null;
        assertNotEquals(t,f);
    }

    @Test
    void testHashCode() {
        Truck t=new Truck(1,1,"y");
        assertEquals(30904,t.hashCode());
    }
    @Test
    void testHashCode2() {
        Truck t=new Truck(1,1,"y");
        assertNotEquals(4,t.hashCode());
    }

    @Test
    void testToString() {
        Truck t=new Truck(1,1,"y");
        assertEquals("Truck{truckID=1, licensePlate=1, name='y'}",t.toString());
    }
}