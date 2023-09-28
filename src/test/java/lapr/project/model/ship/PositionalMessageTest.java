package lapr.project.model.ship;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class PositionalMessageTest {
    PositionalMessage positionalMessage;

    @Test
    void getmMSI() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(212180000, pm.getmMSI());
    }

    @Test
    void getVesselType() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(70, pm.getVesselType());
    }

    @Test
    void getDate() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), pm.getDate());
    }

    @Test
    void getsOG() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(11.7, pm.getsOG());
    }

    @Test
    void getcOG() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(119.9, pm.getcOG());
    }

    @Test
    void getLat() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(24.34573, pm.getLat());
    }

    @Test
    void getLon() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(-85.12394, pm.getLon());
    }

    @Test
    void testToString() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        String expected= pm.toString();
        assertEquals(expected,"PositionalMessage{" + "MMSI:" + 212180000 + "| Vessel Type:" + 70 + "| Date:" + new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37") + "| SOG:" + 11.7 + "| COG:" + 119.9 + "| Lat:" + 24.34573 + "| Lon:" + -85.12394 + "}\n");
    }

    @Test
    void testEquals() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(pm,pm1);
    }

    @Test
    void testEquals2() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180001,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertNotEquals(pm,pm1);
    }


    @Test
    void testEquals3() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,71,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertNotEquals(pm,pm1);
    }

    @Test
    void testEquals4() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,70,11.8,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertNotEquals(pm,pm1);
    }

    @Test
    void testEquals5() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,70,11.7,119.8,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertNotEquals(pm,pm1);
    }

    @Test
    void testEquals6() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:47"),24.34573,-85.12394);
        assertNotEquals(pm,pm1);
    }

    @Test
    void testEquals7() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34575,-85.12394);
        assertNotEquals(pm,pm1);
    }

    @Test
    void testEquals8() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage pm1= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12396);
        assertNotEquals(pm,pm1);
    }

    @Test
    void testHashCode() throws ParseException {
        PositionalMessage pm= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        assertEquals(-2035730248, pm.hashCode());
    }
}