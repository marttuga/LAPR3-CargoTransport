package lapr.project.model.Location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void getPositionID() {
        Position p=new Position(1,1.0,1.0);
    assertEquals(1,p.getPositionID());
    }

    @Test
    void getPositionID2() {
        Position p=new Position(1,1.0,1.0);
        assertNotEquals(2,p.getPositionID());
    }

    @Test
    void setPositionID() {
        Position p=new Position(1,1.0,1.0);
        p.setPositionID(2);
        assertEquals(2,p.getPositionID());
    }

    @Test
    void getLatitude() {
        Position p=new Position(1,1.0,1.0);
        assertEquals(1.0,p.getLatitude());
    }

    @Test
    void getLatitude2() {
        Position p=new Position(1,1.0,1.0);
        assertNotEquals(2.0,p.getLatitude());
    }

    @Test
    void setLatitude() {
        Position p=new Position(1,1.0,1.0);
       p.setLatitude(2.0);
        assertEquals(2.0,p.getLatitude());
    }

    @Test
    void getLongitude() {
        Position p=new Position(1,1.0,1.0);
        assertEquals(1.0,p.getLongitude());
    }

    @Test
    void getLongitude2() {
        Position p=new Position(1,1.0,1.0);
        assertNotEquals(2.0,p.getLongitude());
    }

    @Test
    void setLongitude() {
        Position p=new Position(1,1.0,1.0);
        p.setLongitude(2.0);
        assertEquals(2.0,p.getLongitude());
    }

    @Test
    void testEquals() {
        Position n=null;
        Position p=new Position(1,1.0,1.0);
        assertNotEquals(n,p);
    }

    @Test
    void testEquals2() {
        Position n=null;
        Position p=null;
        assertEquals(n,p);
    }

    @Test
    void testEquals3() {
        Position n= new Position(1,1.0,1.0);
        Position p=new Position(1,1.0,1.0);
        assertEquals(n,p);
    }

    @Test
    void testHashCode() {
        Position p=new Position(1,1.0,1.0);
        assertEquals(-33523680,p.hashCode());
    }

    @Test
    void testHashCodeNull() {
        Position p=new Position(1,1.0,1.0);
        assertNotEquals(0,p.hashCode());
    }

    @Test
    void testToString() {
        Position p=new Position(1,1.0,1.0);
        assertEquals("Position{positionID=1, latitude=1.0, longitude=1.0}",p.toString());
    }
}