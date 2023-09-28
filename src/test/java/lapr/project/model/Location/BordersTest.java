package lapr.project.model.Location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BordersTest {

    @Test
    void getCountryOrigin() {
        Borders border = new Borders("b1" ,"b2");
        assertEquals("b1", border.getCountryOrigin());
    }

    @Test
    void getCountryOrigin2() {
        Borders border = new Borders("b1" ,"b2");
        assertNotEquals("a", border.getCountryOrigin());
    }

    @Test
    void setCountryOrigin() {
        Borders border=new Borders("b1","b2");
        border.setCountryOrigin("e");
        assertEquals("e", border.getCountryOrigin());
    }

    @Test
    void getCountryDestiny() {
        Borders border = new Borders("b1" ,"b2");
        assertEquals("b2", border.getCountryDestiny());
    }

    @Test
    void getCountryDestiny2() {
        Borders border = new Borders("b1" ,"b2");
        assertNotEquals("a", border.getCountryDestiny());
    }

    @Test
    void setCountryDestiny() {
        Borders border=new Borders("b1","b2");
        border.setCountryDestiny("e");
        assertEquals("e", border.getCountryDestiny());
    }

    @Test
    void testEquals() {
        Borders b1 = new Borders("b1","b2");
        Borders b2 = null;
        assertNotEquals(b1,b2);
    }

    @Test
    void testEquals2() {
        Borders b1 = new Borders("b1","b2");
        Borders b2 = new Borders("b1","b2");
        assertEquals(b1,b2);
    }

    @Test
    void testEquals3() {
        Borders b1 = null;
        Borders b2 = null;
        assertEquals(b1,b2);
    }

    @Test
    void testHashCode() {
        Borders b1 = new Borders("b1","b2");
        assertEquals(99746, b1.hashCode());
    }
    @Test
    void testHashCodeNull() {
        Borders b1 = new Borders("b1","b2");
        assertNotEquals(0, b1.hashCode());
    }

    @Test
    void testToString() {
        Borders b1 = new Borders("b1","b2");
        assertEquals("Borders{countryOrigin='b1', countryDestiny='b2', weight=0.0}",b1.toString());
    }
}