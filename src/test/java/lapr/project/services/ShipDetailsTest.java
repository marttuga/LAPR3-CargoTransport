package lapr.project.services;

import lapr.project.controller.ReadFilesController;
import lapr.project.controller.BuildTreeController;
import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipDetailsTest {
    ReadFilesController readFilesController = new ReadFilesController();

    ShipDetails shipDetails = new ShipDetails();


    @After
    public void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    public void getShipDetailsMMSI() {
        readFilesController.load();
        String a = shipDetails.getShipDetailsMMSI(228339600, BuildTreeController.getInstance().getBSTByShipMMSI());
        String b = "\nMMSI: " + 228339600 +
                " \nIMO: " + "IMO9450648" +
                " \nCALL SIGN: " + "FLSU" +
                "\nVESSEL NAME: " + "CMA CGM ALMAVIVA" +
                " \nVESSEL TYPE: " + 70 +
                " \nLENGHT: " + 334 +
                " \nWIDTH: " + 42 +
                " \nDRAFT: " + 15.0 +
                " \nCARGO:" + 79 +
                " \nTRANSCEIVER CLASS: " + "B" +
                "\n--//--";
        assertEquals(a, b);
    }

    @Test
    public void getShipDetailsMMSINull() {
        readFilesController.load();
        String a = shipDetails.getShipDetailsMMSI(332122222, BuildTreeController.getInstance().getBSTByShipMMSI());
        assertNull(a);
    }

    @Test
    public void getShipDetailsIMO() {
        readFilesController.load();
        String a = shipDetails.getShipDetailsIMO("IMO9450648", BuildTreeController.getInstance().getBSTByShipIMO());
        String b = "\nMMSI: " + 228339600 +
                " \nIMO: " + "IMO9450648" +
                " \nCALL SIGN: " + "FLSU" +
                "\nVESSEL NAME: " + "CMA CGM ALMAVIVA" +
                " \nVESSEL TYPE: " + 70 +
                " \nLENGHT: " + 334 +
                " \nWIDTH: " + 42 +
                " \nDRAFT: " + 15.0 +
                " \nCARGO:" + 79 +
                " \nTRANSCEIVER CLASS: " + "B" +
                "\n--//--";
        assertEquals(a, b);
    }

    @Test
    public void getShipDetailsIMONull() {
        readFilesController.load();
        String a = shipDetails.getShipDetailsIMO("IMO9221222", BuildTreeController.getInstance().getBSTByShipIMO());
        assertNull(a);
    }


    @Test
    public void getShipDetailsCallSign() {
        readFilesController.load();
        String a = shipDetails.getShipDetailsCallSign("FLSU", BuildTreeController.getInstance().getBSTByCallSign());
        String b = "\nMMSI: " + 228339600 +
                " \nIMO: " + "IMO9450648" +
                " \nCALL SIGN: " + "FLSU" +
                "\nVESSEL NAME: " + "CMA CGM ALMAVIVA" +
                " \nVESSEL TYPE: " + 70 +
                " \nLENGHT: " + 334 +
                " \nWIDTH: " + 42 +
                " \nDRAFT: " + 15.0 +
                " \nCARGO:" + 79 +
                " \nTRANSCEIVER CLASS: " + "B" +
                "\n--//--";
        assertEquals(a, b);
    }

    @Test
    public void getShipDetailsCallSignNull() {
        readFilesController.load();
        String a = shipDetails.getShipDetailsCallSign("21222", BuildTreeController.getInstance().getBSTByCallSign());
        assertNull(a);
    }

}