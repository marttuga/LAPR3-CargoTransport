package lapr.project.model.Location;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinentTest {

    @Test
    void getContinent() {
        Continent continent=new Continent("Europe");
        assertEquals("Europe", continent.getContinent());
    }
    @Test
    void getContinent2() {
        Continent continent=new Continent("Europe");
        assertNotEquals("e",continent.getContinent());
    }


    @Test
    void setContinent() {
        Continent continent=new Continent("Europe");
        continent.setContinent("e");
        assertEquals("e", continent.getContinent());
    }

    @Test
    void testEquals() {
        Continent continent=new Continent("Europe");
        Continent c=null;
        assertNotEquals(continent,c);
    }
    @Test
    void testEquals2() {
        Continent continent=new Continent("Europe");
        Continent c=new Continent("Europe");
        assertEquals(continent,c);
    }

    @Test
    void testHashCode() {
        Continent continent=new Continent("Europe");
        assertEquals(2086969825, continent.hashCode());
    }
    @Test
    void testHashCodeNull() {
        Continent continent=new Continent("Europe");
        assertNotEquals(0, continent.hashCode());
    }

    @Test
    void testToString() {
        Continent continent=new Continent("Europe");
        assertEquals("Continent{continent='Europe'}", continent.toString());
    }
}