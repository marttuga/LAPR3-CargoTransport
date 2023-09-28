package lapr.project.model.ship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipAtribTest {
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEquals() {
        double d1 = 1.595;
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        ShipAtrib ship2 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        assertEquals(ship1, ship2);
    }
    @Test
    void testEquals2() {
        double d1 = 1.595;
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        ShipAtrib ship2 = new ShipAtrib(966759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        assertNotEquals(ship1, ship2);
    }

    @Test
    void testHashCode() {
        double d1 = 1.595;
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        assertEquals(-656639101, ship1.hashCode());
    }

    @Test
    void testToString() {
        double d1 = 1.595;
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        String s = "\nMMSI:366759530 NUMBER OF MOVEMENTS:1217 TRAVELLED DISTANCE:78.724 DELTA DISTANCE:1.595";
        assertEquals(s, ship1.toString());
    }
    @Test
    void getmMSI1()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(366772990, ship1.getmMSI1());
    }
    @Test
    void getDDistance1()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(1.595, ship1.getDDistance1());
    }
    @Test
    void getDDistance2()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(1.595, ship1.getDDistance2());
    }
    @Test
    void getNumberMovements()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(1217, ship1.getNumberOfMovements());
    }
    @Test
    void getNumberMovements2()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(1251, ship1.getNumberOfMovements1());
    }
    @Test
    void getTDistance()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(78.724, ship1.getTravelDistance());
    }
    @Test
    void getTDistance2()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);
        assertEquals(360.596, ship1.getTravelDistance1());
    }
    @Test
    void getTDistanceDif()  {
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, 1.595,1.595, 1217, 78.724, 1251, 360.596);

        assertEquals(281.872, ship1.getTravelDistanceDiference());
    }
}