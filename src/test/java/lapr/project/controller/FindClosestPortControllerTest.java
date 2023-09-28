package lapr.project.controller;

import lapr.project.model.port.Port;
import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipCallSign;
import lapr.project.services.FindClosestPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FindClosestPortControllerTest {

    ReadFilesController readFilesController;
    FindClosestPortController findClosestPort;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        findClosestPort = new FindClosestPortController();
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().reset2DPortTree();
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void findPortClose() throws ParseException {
        readFilesController.load();
        Port p = new Port("America", "Canada", 22226, "Halifax", 44.65, -63.567);
        assertEquals(p, findClosestPort.findPortClose(BuildTreeController.getInstance().getPort2dTree(), "C4SQ2", BuildTreeController.getInstance().getBSTByCallSign(), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20")));
    }

    @Test
    void getNearestPort() throws ParseException {
        readFilesController.load();
        if (!ReadFilesController.isUseBigFiles()) {
            Port p = new Port("America", "Colombia", 28313, "Cartagena", 10.417, -75.533);
            Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A", "32454");
            ShipCallSign shipCallSign = new ShipCallSign(ship1);
            Map<String, ShipCallSign> map = new HashMap<>();
            map.put("5BBA4", shipCallSign);
            List<Map.Entry<String, ShipCallSign>> groupedList = new LinkedList<>(map.entrySet());
            assertEquals(p, findClosestPort.getNearestPort(BuildTreeController.getInstance().getPort2dTree(), groupedList, "5BBA4", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37")));
        } else {
            Port p = new Port("America", "United States", 14635, "Los Angeles", 33.717, -118.267);
            Ship ship1 = new Ship(211331640, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 01:25"), 36.39094, -122.71335, 19.7, 145.5, 147, "SEOUL EXPRESS", "IMO9193305", "DHBN", 70, 294, 32, 13.6, 79, "b", "98765");
            ShipCallSign shipCallSign = new ShipCallSign(ship1);
            Map<String, ShipCallSign> map = new HashMap<>();
            map.put("DHBN", shipCallSign);
            List<Map.Entry<String, ShipCallSign>> groupedList = new LinkedList<>(map.entrySet());
            assertEquals(p, findClosestPort.getNearestPort(BuildTreeController.getInstance().getPort2dTree(), groupedList, "DHBN", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 01:25")));
        }

    }
        @Test
        void getNearestPortNoCallsign () throws ParseException {
            readFilesController.load();
            Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A", "32454");
            ShipCallSign shipCallSign = new ShipCallSign(ship1);
            Map<String, ShipCallSign> map = new HashMap<>();
            map.put("5BBA4", shipCallSign);
            List<Map.Entry<String, ShipCallSign>> groupedList = new LinkedList<>(map.entrySet());
            System.out.println("|-  There isn't any ship registered for that Callsign!  -| \n \n Not able to find any port :(  ");
            assertNull(findClosestPort.getNearestPort(BuildTreeController.getInstance().getPort2dTree(), groupedList, "5BBA9", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37")));
        }

        @Test
        void getNearestPortNoDate () throws ParseException {
            readFilesController.load();
            Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A", "32454");
            ShipCallSign shipCallSign = new ShipCallSign(ship1);
            Map<String, ShipCallSign> map = new HashMap<>();
            map.put("5BBA4", shipCallSign);
            List<Map.Entry<String, ShipCallSign>> groupedList = new LinkedList<>(map.entrySet());
            System.out.println("|-  There isn't any ship registered in this date!  -| \n \n Not able to find any port :(  ");
            assertNull(findClosestPort.getNearestPort(BuildTreeController.getInstance().getPort2dTree(), groupedList, "5BBA4", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("25/12/2020 19:37")));
        }
    }