package lapr.project.model.Vehicle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void getVehicleID() {
        Vehicle v = new Vehicle("1");
        assertEquals("1",v.getVehicleID());
    }

    @Test
    void setVehicleID() {
        Vehicle v = new Vehicle("1");
        v.setVehicleID("2");
        assertEquals("2",v.getVehicleID());
    }

    @Test
    void testEquals() {
        Vehicle v = new Vehicle("1");
        Vehicle s = new Vehicle("1");
        assertEquals(s,v);
    }

    @Test
    void testNotEquals() {
        Vehicle v = new Vehicle("1");
        Vehicle s = new Vehicle("5");
        assertNotEquals(s,v);
    }

    @Test
    void testHashCode() {
        Vehicle v = new Vehicle("1");
        assertEquals(80,v.hashCode());
    }

    @Test
    void testToString() {
        Vehicle v = new Vehicle("1");
        assertEquals("Vehicle{vehicleID='1'}",v.toString());
    }
}