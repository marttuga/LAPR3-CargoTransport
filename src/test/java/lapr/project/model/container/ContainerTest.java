package lapr.project.model.container;

import lapr.project.model.ship.Ship;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void getContainerID() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals(123456, container.getContainerID());
    }

    @Test
    void getContainerID2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(0, container.getContainerID());
    }

    @Test
    void setContainerID() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setContainerID(111111);
        assertEquals(111111, container.getContainerID());

    }

    @Test
    void getPayload() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals(4.29, container.getPayload());
    }

    @Test
    void getPayload2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(3.31, container.getPayload());
    }

    @Test
    void setPayload() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setPayload(1.11);
        assertEquals(1.11, container.getPayload());
    }

    @Test
    void getTare() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals(3.41, container.getTare());
    }

    @Test
    void getTare2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(2.76, container.getTare());
    }

    @Test
    void setTare() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setTare(1.11);
        assertEquals(1.11, container.getTare());
    }

    @Test
    void getGross() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals(1.90, container.getGross());

    }

    @Test
    void getGross2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(1.23, container.getGross());

    }

    @Test
    void setGross() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setGross(1.11);
        assertEquals(1.11, container.getGross());
    }

    @Test
    void getType() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals("REFRIGERATED", container.getType());
    }

    @Test
    void getType2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals("NON_REFRIGERATED", container.getType());
    }

    @Test
    void setType() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setType("NON_REFRIGERATED");
        assertEquals("NON_REFRIGERATED", container.getType());
    }

    @Test
    void getTemperature() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals(5, container.getTemperature());
    }

    @Test
    void getTemperature2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(9, container.getTemperature());
    }

    @Test
    void setTemperature() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setTemperature(8);
        assertEquals(8, container.getTemperature());
    }

    @Test
    void getISOCode() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals("22G1",container.getISOCode());
    }

    @Test
    void getISOCode2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals("23G7",container.getISOCode());
    }

    @Test
    void setISOCode() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        container.setISOCode("45T1");
        assertEquals("45T1",container.getISOCode());
    }


    @Test
    void testEquals() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        Container container1 = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertEquals(container,container1);
    }

    @Test
    void testEquals2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(container, new Object());
    }


    @Test
    void testHashCode2() {
        Container container = new Container(123456, 4.29, 3.41, 1.90, "REFRIGERATED", 5, "22G1");
        assertNotEquals(345617437, container.hashCode());
    }
}