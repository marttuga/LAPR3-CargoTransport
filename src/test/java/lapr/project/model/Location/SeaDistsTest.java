package lapr.project.model.Location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeaDistsTest {

    @Test
    void getCountryOrigin() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals("s1", s1.getCountryOrigin());
    }

    @Test
    void getContinent2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals("a", s1.getCountryOrigin());
    }

    @Test
    void setCountryOrigin() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setCountryOrigin("e");
        assertEquals("e", s1.getCountryOrigin());
    }

    @Test
    void getPortIDOrigin() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals(1, s1.getPortIDOrigin());
    }

    @Test
    void getPortIDOrigin2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals(5, s1.getPortIDOrigin());
    }

    @Test
    void setPortIDOrigin() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setPortIDOrigin(7);
        assertEquals(7, s1.getPortIDOrigin());
    }

    @Test
    void getPortOrigin() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals("s2", s1.getPortOrigin());
    }

    @Test
    void getPortOrigin2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals("s7", s1.getPortOrigin());
    }

    @Test
    void setPortOrigin() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setPortOrigin("s9");
        assertEquals("s9", s1.getPortOrigin());
    }

    @Test
    void getCountryDestiny() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals("s3", s1.getCountryDestiny());
    }

    @Test
    void getCountryDestiny2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals("s0", s1.getCountryDestiny());
    }

    @Test
    void setCountryDestiny() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setPortOrigin("s9");
        assertEquals("s9", s1.getPortOrigin());
    }

    @Test
    void getPortIDDestiny() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals(2, s1.getPortIDDestiny());
    }

    @Test
    void getPortIDDestiny2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals(6, s1.getPortIDDestiny());
    }

    @Test
    void setPortIDDestiny() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setPortIDDestiny(5);
        assertEquals(5, s1.getPortIDDestiny());
    }

    @Test
    void getPortDestiny() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals("s4", s1.getPortDestiny());
    }

    @Test
    void getPortDestiny2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals("s1", s1.getPortDestiny());
    }

    @Test
    void setPortDestiny() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setPortDestiny("s2");
        assertEquals("s2", s1.getPortDestiny());
    }

    @Test
    void getSeaDists() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals(3, s1.getSeaDists());
    }

    @Test
    void getSeaDists2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals(10, s1.getSeaDists());
    }

    @Test
    void setSeaDists() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        s1.setSeaDists(123);
        assertEquals(123, s1.getSeaDists());
    }

    @Test
    void testEquals() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        SeaDists s2 = null;
        assertNotEquals(s1,s2);
    }
    @Test
    void testEquals2() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        SeaDists s2 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals(s1,s2);
    }
    @Test
    void testEquals3() {
        SeaDists s1 = null;
        SeaDists s2 = null;
        assertEquals(s1,s2);
    }

    @Test
    void testHashCode() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals(20571935, s1.hashCode());
    }
    @Test
    void testHashCodeNull() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertNotEquals(0, s1.hashCode());
    }

    @Test
    void testToString() {
        SeaDists s1 = new SeaDists("s1",1,"s2","s3",2,"s4",3);
        assertEquals("SeaDists{CountryOrigin='s1', portIDOrigin=1, portOrigin='s2', CountryDestiny='s3', portIDDestiny=2, portDestiny='s4', seaDists=3}",s1.toString());
    }
}