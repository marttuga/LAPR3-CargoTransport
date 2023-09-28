package lapr.project.model.cargoManifest;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class CargoManifestTest {

    @Test
    void getCargoManifestID() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals(1,c.getCargoManifestID());
    }

    @Test
    void getCargoManifestID2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals(2,c.getCargoManifestID());
    }

    @Test
    void setCargoManifestID() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        c.setCargoManifestID(2);
        assertEquals(2,c.getCargoManifestID());
    }

    @Test
    void getVehicleID() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals("1",c.getVehicleID());
    }

    @Test
    void getVehicleID2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals(2,c.getVehicleID());
    }

    @Test
    void setVehicleID() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        c.setVehicleID("2");
        assertEquals("2",c.getVehicleID());
    }
    @Test
    void getGrossWeight() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals(1,c.getGrossWeight());
    }

    @Test
    void getGrossWeight2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals(2,c.getGrossWeight());
    }

    @Test
    void setGrossWeight() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        c.setGrossWeight(2);
        assertEquals(2,c.getGrossWeight());
    }

    @Test
    void getManifestDate() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),c.getManifestDate());
    }

    @Test
    void getManifestDate2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 15:32"),c.getManifestDate());
    }

    @Test
    void setManifestDate() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        c.setManifestDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:12"));
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:12"),c.getManifestDate());
    }

    @Test
    void getType() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals("g",c.getType());
    }

    @Test
    void getType2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals("e",c.getType());
    }

    @Test
    void setType() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        c.setType("r");
        assertEquals("r",c.getType());
    }


    @Test
    void getStopName() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals("1",c.getStopName());
    }

    @Test
    void getStopName2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals("a",c.getStopName());
    }

    @Test
    void setStopName() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        c.setStopName("t");
        assertEquals("t",c.getStopName());
    }

    @Test
    void testEquals() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        CargoManifest c1= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals(c,c1);
    }

    @Test
    void testEquals2() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        CargoManifest c1= null;
        assertNotEquals(c,c1);
    }

    @Test
    void testEquals3() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        CargoManifest c1= null;
        assertEquals(c.toString(),c.toString());
    }

    @Test
    void testHashCode() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertEquals(1386591634,c.hashCode());
    }

    @Test
    void testHashCodeNull() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals(0,c.hashCode());
    }

    @Test
    void testToString() throws ParseException {
        CargoManifest c= new CargoManifest(1,1,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2020 17:19"),"g","1","1");
        assertNotEquals("{cargoManifestID=1, grossWeight=1, manifestDate=Tue Dec 01 17:19:00 WET 2020, type='g', MMSI=1, stopName='w'}",c.toString());
    }


}