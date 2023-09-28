package lapr.project.model.ship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ShipIMOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compareTo() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ShipIMO shipIMO1 = new ShipIMO(ship1);
        ShipIMO shipIMO2 = new ShipIMO(ship1);
        int re = shipIMO1.compareTo(shipIMO2);
        assertEquals(0, re);
    }

    @Test
    void testToString() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ShipIMO shipIMO1 = new ShipIMO(ship1);
        String s = "IMO:IMO9395044";
        assertEquals(s,shipIMO1.toString());
    }
}