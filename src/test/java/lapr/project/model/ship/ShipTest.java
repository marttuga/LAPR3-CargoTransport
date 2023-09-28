package lapr.project.model.ship;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;


class ShipTest {

    @Test
    void getVehicleID() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        assertEquals("12345", ship1.getVehicleID());
    }
    @Test
    void setVehicleID() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ship1.setVehicleID("11111");
        assertEquals("11111", ship1.getVehicleID());
    }
    @Test
    void getmMSI() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(210950000, ship1.getmMSI());
    }
    
    @Test
    void setmMSI() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        ship1.setmMSI(111111111);
        assertEquals(111111111, ship1.getmMSI());
    }

    @Test
    void getBaseDateTime() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), ship1.getBaseDateTime());
    }

    @Test
    void getlAT() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(42.97875, ship1.getlAT());
    }

    @Test
    void getlON() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(-66.97001, ship1.getlON());
    }

    @Test
    void getsOG() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(12.9, ship1.getsOG());
    }

    @Test
    void getcOG() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(13.1, ship1.getcOG());
    }

    @Test
    void getHeading() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(355, ship1.getHeading());
    }

    @Test
    void getVesselName() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals("VARAMO", ship1.getVesselName());
    }

    @Test
    void getiMO() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals("IMO9395044", ship1.getiMO());
    }

    @Test
    void setiMO() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        ship1.setiMO("IMO1112221");
        assertEquals("IMO1112221", ship1.getiMO());
    }

    @Test
    void getCallSign() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals("C4SQ2", ship1.getCallSign());
    }

    @Test
    void setCallSign() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        ship1.setCallSign("C4SQ");
        assertEquals("C4SQ", ship1.getCallSign());

    }

    @Test
    void getVesselType() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(70, ship1.getVesselType());
    }

    @Test
    void getLength() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(166, ship1.getLength());
    }

    @Test
    void getWidth() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(25, ship1.getWidth());
    }

    @Test
    void getDraft() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(9.5, ship1.getDraft());
    }

    @Test
    void getCargo() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(76, ship1.getCargo());
    }

    @Test
    void getTranscieverClass() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals("B", ship1.getTranscieverClass());
    }


    @Test
    void testEquals() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(ship1, ship2);
    }

    @Test
    void testEquals2() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertNotEquals(ship1, new Object());

    }

    @Test
    void testHashCode() throws ParseException {
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"),
                42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044",
                "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");        assertEquals(157839445, ship1.hashCode());
    }

    @Test
    void shilpRule1() throws ParseException {
        boolean a = true;
        try {
            Ship  ship1 = new Ship(21, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        } catch (Exception e) {
            a = false;
        }
        assertFalse(a,"MMMSI should have 9 numbers");
    }
    @Test
    void shilpRule2() throws ParseException {
        boolean a = true;
        try {
            Ship  ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "OMI9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        } catch (Exception e) {
            a = false;
        }
        assertFalse(a,"IMO should start with IMO");

        boolean b = true;

        try {
            Ship  ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO93", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        } catch (Exception e) {
            b = false;
        }
        assertFalse(b,"After IMO must be there 7 numbers");
    }

    @Test
    void shilpRule3() throws ParseException {
        boolean a = true;
        try {
            Ship  ship1 = new Ship(210950000, null, 42.97875, -66.97001, 12.9, 13.1, 355, null, null, null, 70, 166, 25, 9.5, 76, null,"12345");
        } catch (Exception e) {
            a = false;
        }

        assertFalse(a,"Ship attributes shouldn't be null");

    }
}