package lapr.project.model.Location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void getContinent() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals("c1",c.getContinent());
    }
    @Test
    void getContinent2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals("t",c.getContinent());
    }

    @Test
    void setContinent() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setContinent("r");
        assertEquals("r",c.getContinent());
    }

    @Test
    void getCountry() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals("c4",c.getCountry());
    }
    @Test
    void getCountry2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals("u",c.getCountry());
    }

    @Test
    void setCountry() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setCountry("d");
        assertEquals("d",c.getCountry());
    }

    @Test
    void testEquals() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        Country r=null;
        assertNotEquals(c,r);
    }
    @Test
    void testEquals2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        Country r=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals(c,r);
    }

    @Test
    void testHashCode() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals(1073956149,c.hashCode());
    }
    @Test
    void testHashCode2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals(411,c.hashCode());
    }

    @Test
    void testToString() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals("\nContinent: c1Alpha2 Code: c2Alpha3 Code: c3Country: c4Population: 1.0Capital: c5Latitude: 2.0Longitude: 3.0",c.toString());
    }

    @Test
    void getAlpha2code() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals("c2",c.getAlpha2code());
    }

    @Test
    void getAlpha2code2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals("t",c.getAlpha2code());
    }

    @Test
    void setAlpha2code() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setAlpha2code("r");
        assertEquals("r",c.getAlpha2code());
    }

    @Test
    void getAlpha3code() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals("c3",c.getAlpha3code());
    }

    @Test
    void getAlpha3code2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals("r",c.getAlpha2code());
    }

    @Test
    void setAlpha3code() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setAlpha3code("r");
        assertEquals("r",c.getAlpha3code());
    }

    @Test
    void getPopulation() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals(1.0,c.getPopulation());
    }

    @Test
    void getPopulation2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals(4.0,c.getPopulation());
    }

    @Test
    void setPopulation() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setPopulation(9.0);
        assertEquals(9.0,c.getPopulation());
    }

    @Test
    void getCapital() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals("c5",c.getCapital());
    }

    @Test
    void getCapital2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals("r",c.getCapital());
    }

    @Test
    void setCapital() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setCapital("c8");
        assertEquals("c8",c.getCapital());
    }

    @Test
    void getLat() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals(2.0,c.getLat());
    }

    @Test
    void getLat2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals(3.0,c.getLat());
    }

    @Test
    void setLat() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setLat(5.0);
        assertEquals(5.0,c.getLat());
    }

    @Test
    void getLon() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertEquals(3.0,c.getLon());
    }

    @Test
    void getLon2() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        assertNotEquals(11.0,c.getLon());
    }

    @Test
    void setLon() {
        Country c=new Country("c1","c2","c3","c4",1.0,"c5",2.0,3.0);
        c.setLon(5.0);
        assertEquals(5.0,c.getLon());
    }
}

