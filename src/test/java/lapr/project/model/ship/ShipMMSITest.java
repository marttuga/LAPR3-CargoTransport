package lapr.project.model.ship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ShipMMSITest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compareTo() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ShipMMSI shipMMSI = new ShipMMSI(ship1);
        ShipMMSI shipMMSI1 = new ShipMMSI(ship1);
        int re = shipMMSI.compareTo(shipMMSI1);
        assertEquals(0, re);
    }

    @Test
    void testToString() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ShipMMSI shipMMSI = new ShipMMSI(ship1);
        String s="MMSI:210950000  Travelled Distance:0.0  MeanSOG:12.9  VesselType:70\n";
        assertEquals(s,shipMMSI.toString());
    }
}