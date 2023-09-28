package lapr.project.model.port;

import lapr.project.tree2D.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getContinent() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals("Europe", p.getContinent());
    }

    @Test
    void getCountry() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals("Cyprus", p.getCountry());
    }

    @Test
    void getCode() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals(10136, p.getCode());
    }

    @Test
    void getPortCity() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals("Larnaca", p.getPortCity());
    }

    @Test
    void getLat() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals(34.91666667, p.getLat());
    }

    @Test
    void getLon() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals(33.65, p.getLon());
    }

    @Test
    void testEquals() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        Port p1 = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        Port p2 = new Port("America", "Brasil", 10136, "S.Paulo", 34.91666667, 33.65);
        boolean a = p.equals(p1);
        assertTrue(a);
        boolean b=p.equals(p2);
        assertFalse(b);
    }

    @Test
    void testHashCode() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals(1966884092,p.hashCode());
    }

    @Test
    void testToString() {
        Port p = new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals("Port{continent='Europe', country='Cyprus', code=10136, portCity='Larnaca', lat=34.91666667, lon=33.65}",p.toString());
    }
}