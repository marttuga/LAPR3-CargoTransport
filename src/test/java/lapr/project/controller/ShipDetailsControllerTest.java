package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipDetailsControllerTest {

    ShipDetailsController shipDetailsController = new ShipDetailsController();
    ReadFilesController readFilesController = new ReadFilesController();


    @Test
    public void getShipDetailsMMSI() {
        readFilesController.load();
        String a;
        String b;
        if (!ReadFilesController.isUseBigFiles()) {
            a = shipDetailsController.getShipDetailsMMSI(228339600, BuildTreeController.getInstance().getBSTByShipMMSI());
            b = "\nMMSI: " + 228339600 +
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
        } else {
            a = shipDetailsController.getShipDetailsMMSI(211331640, BuildTreeController.getInstance().getBSTByShipMMSI());
            b = "\nMMSI: " + 211331640 +
                    " \nIMO: " + "IMO9193305" +
                    " \nCALL SIGN: " + "DHBN" +
                    "\nVESSEL NAME: " + "SEOUL EXPRESS" +
                    " \nVESSEL TYPE: " + 70 +
                    " \nLENGHT: " + 294 +
                    " \nWIDTH: " + 32 +
                    " \nDRAFT: " + 13.6 +
                    " \nCARGO:" + 79 +
                    " \nTRANSCEIVER CLASS: " + "B" +
                    "\n--//--";

        }
        assertEquals(a, b);
    }

    @Test
    public void getShipDetailsIMO() {
        readFilesController.load();
        String a;
        String b;
        if (!ReadFilesController.isUseBigFiles()) {
            a = shipDetailsController.getShipDetailsIMO("IMO9450648", BuildTreeController.getInstance().getBSTByShipIMO());
            b = "\nMMSI: " + 228339600 +
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


        } else {
            a = shipDetailsController.getShipDetailsIMO("IMO9193305", BuildTreeController.getInstance().getBSTByShipIMO());
            b = "\nMMSI: " + 211331640 +
                    " \nIMO: " + "IMO9193305" +
                    " \nCALL SIGN: " + "DHBN" +
                    "\nVESSEL NAME: " + "SEOUL EXPRESS" +
                    " \nVESSEL TYPE: " + 70 +
                    " \nLENGHT: " + 294 +
                    " \nWIDTH: " + 32 +
                    " \nDRAFT: " + 13.6 +
                    " \nCARGO:" + 79 +
                    " \nTRANSCEIVER CLASS: " + "B" +
                    "\n--//--";

        }
        assertEquals(a, b);
    }

    @Test
    public void getShipDetailsCallSign() {
        readFilesController.load();
        String a;
        String b;
        if (!ReadFilesController.isUseBigFiles()) {

            a = shipDetailsController.getShipDetailsCallSign("FLSU", BuildTreeController.getInstance().getBSTByCallSign());
            b = "\nMMSI: " + 228339600 +
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

        } else {
            a = shipDetailsController.getShipDetailsCallSign("DHBN", BuildTreeController.getInstance().getBSTByCallSign());
            b = "\nMMSI: " + 211331640 +
                    " \nIMO: " + "IMO9193305" +
                    " \nCALL SIGN: " + "DHBN" +
                    "\nVESSEL NAME: " + "SEOUL EXPRESS" +
                    " \nVESSEL TYPE: " + 70 +
                    " \nLENGHT: " + 294 +
                    " \nWIDTH: " + 32 +
                    " \nDRAFT: " + 13.6 +
                    " \nCARGO:" + 79 +
                    " \nTRANSCEIVER CLASS: " + "B" +
                    "\n--//--";

        }
        assertEquals(a, b);
    }
}