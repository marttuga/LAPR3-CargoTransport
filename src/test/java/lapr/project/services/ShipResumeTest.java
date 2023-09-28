package lapr.project.services;

import lapr.project.controller.ReadFilesController;
import lapr.project.controller.BuildTreeController;
import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.BST;
import lapr.project.utils.DiferenceBetweenToDates;
import lapr.project.utils.DistanceBetweenTwoPointsCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShipResumeTest {
    ReadFilesController readFilesController;
    ShipResume shipResume;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        shipResume = new ShipResume();
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void getShipResume() throws ParseException {

        readFilesController.load();
        if (!ReadFilesController.isUseBigFiles()) {
            String a = shipResume.getShipResume(228339600, BuildTreeController.getInstance().getBSTByShipMMSI());
            String b = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 228339600, "IMO9450648", "FLSU", "CMA CGM ALMAVIVA", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:00"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 3:56"), 236, 18, 12.0, 11.732, 131.1, 129.037, 28.37458, -88.88584, 27.87869, -88.88584, 85.261, 85.222);
            assertEquals(a, b);

            String c = shipResume.getShipResume(212351000, BuildTreeController.getInstance().getBSTByShipMMSI());
            String d = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 212351000, "IMO9305685", "5BZP3", "HYUNDAI SINGAPORE", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 23:03"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 23:03"), 0, 0, 3.5, 3.5, -61.6, -61.6, 55.09307, -167.63625, 55.09307, -167.63625, 0.0, 0.0);
            assertEquals(c, d);
        } else {
            String a = shipResume.getShipResume(441188000, BuildTreeController.getInstance().getBSTByShipMMSI());
            String b = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 441188000, "IMO9651113", "D8GS", "GLOVIS CHAMPION", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:00"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:20"), 1340, 624, 18.5, 13.328, 201.4, -77.909, 26.67097, -79.4351, 30.94004, -79.4351, 557.372, 503.309);
            assertEquals(a, b);

            String c = shipResume.getShipResume(366904930, BuildTreeController.getInstance().getBSTByShipMMSI());
            String d = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 366904930, "IMO5148417", "WL3972", "HERBERT C JACKSON", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:00"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:59"), 1379, 1202, 12.8, 11.484, 50.1, -50.565, 42.5556, -82.58517, 46.37353, -82.58517, 491.848, 443.804);
            assertEquals(c, d);
        }
    }

    @Test
    void getBaseDateTimeInicial() throws ParseException {

        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);

        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/12/2020 16:20"), shipResume.getBaseDateTimeInicial(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/12/2020 17:16"), 42.96912, -66.97061, 15, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/12/2020 17:16"), shipResume.getBaseDateTimeInicial(list));

        Ship ship6 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("02/12/2020 10:00"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA6 = new ShipMMSI(ship6);
        list.add(shipA6);
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("02/12/2020 10:00"),shipResume.getBaseDateTimeInicial(list));

    }

    @Test
    void getBaseDateTimeFinal() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);

        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), shipResume.getBaseDateTimeFinal(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/01/2021 17:16"), 42.96912, -66.97061, 15, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);

        list.add(shipA5);
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/01/2021 17:16"), shipResume.getBaseDateTimeFinal(list));

        Ship ship6 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:06"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA6 = new ShipMMSI(ship6);
        list.add(shipA6);
        assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:06"),shipResume.getBaseDateTimeInicial(list));
    }


    @Test
    void getMovementTime() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("30/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA4);
        long expected = shipResume.getTotalMovementTime(list);
        long atual = DiferenceBetweenToDates.findDifference(shipA4.getBaseDateTime(), shipA1.getBaseDateTime());
     /*   System.out.println("Atual: " + atual);
        System.out.println("Expected: " + expected);*/
        assertEquals(atual, expected);
        list.add(shipA2);
        long expected2 = shipResume.getTotalMovementTime(list);
        long atual2 = DiferenceBetweenToDates.findDifference(shipA2.getBaseDateTime(), shipA1.getBaseDateTime());
      /*  System.out.println("Atual: " + atual2);
        System.out.println("Expected: " + expected2);*/
        assertEquals(atual2, expected2);
        list.add(shipA3);
        long expected3 = shipResume.getTotalMovementTime(list);
        long atual3 = DiferenceBetweenToDates.findDifference(shipA3.getBaseDateTime(), shipA1.getBaseDateTime());
    /*    System.out.println("Atual: " + atual3);
        System.out.println("Expected: " + expected3);*/
        assertEquals(atual3, expected3);

    }

    @Test
    void getNumberOfMovements() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:04"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.7698, -66.9759, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/01/2021 17:16"), 42.96912, -66.9759, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        Ship ship6 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/01/2021 17:17"), 42.96912, -66.9755, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        ShipMMSI shipA6 = new ShipMMSI(ship6);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);

        int expected = shipResume.getTotalNumberOfMovements(list);
        assertEquals(2, expected);

        list.add(shipA4);
        int expected2 = shipResume.getTotalNumberOfMovements(list);
        assertEquals(2, expected2);

        list.add(shipA5);
        int expected3 = shipResume.getTotalNumberOfMovements(list);
        assertEquals(3, expected3);

        list.add(shipA6);
        int expected4 = shipResume.getTotalNumberOfMovements(list);
        assertEquals(4, expected4);
    }

    @Test
    void getMaxSOG() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);

        assertEquals(13.3, shipResume.getMaxSOG(list));
        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 15, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);

        list.add(shipA5);

        assertEquals(15, shipResume.getMaxSOG(list));
    }

    @Test
    void containShip() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        List<Map.Entry<ShipMMSI, Double>> entryList = new LinkedList<>();
        Map<ShipMMSI, Double> map = new HashMap<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950002, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950003, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);

        for (ShipMMSI s : list) {
            map.put(s, 0.0);
        }
        entryList.addAll(map.entrySet());

        boolean a = shipResume.containShip(210950000, entryList);
        assertTrue(a);
        boolean b = shipResume.containShip(210950004, entryList);
        assertFalse(b);
    }

    @Test
    void getMeanSOG() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);

        BigDecimal bd1 = new BigDecimal( (12.9 + 12.5 + 13.3 + 12.7) / list.size()).setScale(3, RoundingMode.HALF_EVEN);

        assertEquals(bd1.doubleValue(), shipResume.getMeanSOG(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/01/2021 17:16"), 42.96912, -66.97061, 15, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);
        BigDecimal bd2 = new BigDecimal( (12.9 + 12.5 + 13.3 + 12.7 + 15) / list.size()).setScale(3, RoundingMode.HALF_EVEN);

        assertEquals(bd2.doubleValue(), shipResume.getMeanSOG(list));

    }

    @Test
    void getMaxCOG() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);

        assertEquals(13.1, shipResume.getMaxCOG(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 15, 15.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);

        assertEquals(15.4, shipResume.getMaxCOG(list));
    }

    @Test
    void getMeanCOG() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        BigDecimal bd1 = new BigDecimal( (13.1 + 2.4 + 3.7 - 55.4) / list.size()).setScale(3, RoundingMode.HALF_EVEN);

        assertEquals(bd1.doubleValue(), shipResume.getMeanCOG(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/01/2021 17:16"), 42.96912, -66.97061, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);
        BigDecimal bd2 = new BigDecimal( (13.1 + 2.4 + 3.7 - 55.4 + 35.4) / list.size()).setScale(3, RoundingMode.HALF_EVEN);

        assertEquals(bd2.doubleValue(), shipResume.getMeanCOG(list));

    }

    @Test
    void getDepartureLatitude() throws ParseException {

        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/01/2021 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(42.7698, shipResume.getDepartureLatitude(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/01/2020 17:16"), 42.96912, -66.97061, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);

        assertEquals(42.96912, shipResume.getDepartureLatitude(list));

    }

    @Test
    void getDepartureLongitude() throws ParseException {

        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/01/2021 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");


        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(-66.9759, shipResume.getDepartureLongitude(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/01/2020 17:16"), 42.96912, -66.97061, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);
        assertEquals(-66.97061, shipResume.getDepartureLongitude(list));
    }

    @Test
    void getArrivalLatitude() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/01/2021 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(42.96912, shipResume.getArrivalLatitude(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/04/2021 17:16"), 42.96912, -66.97061, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);
        assertEquals(42.96912, shipResume.getArrivalLatitude(list));

    }

    @Test
    void getArrivalLongitude() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/01/2021 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(-66.97061, shipResume.getArrivalLongitude(list));

        Ship ship5 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/02/2020 17:16"), 42.96912, -66.97061, 15, 35.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA5 = new ShipMMSI(ship5);
        list.add(shipA5);
        assertEquals(-66.97061, shipResume.getArrivalLongitude(list));
    }

    @Test
    void getTravelDistance() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/01/2021 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);

        double actual1 = shipResume.getTravelDistance(list);
        double expected1 = DistanceBetweenTwoPointsCalculator.distance(ship2.getlAT(), ship1.getlAT(), ship2.getlON(), ship1.getlON());
        assertEquals(expected1, actual1);

        list.add(shipA3);
        double actual2 = shipResume.getTravelDistance(list);
        double expected2 = DistanceBetweenTwoPointsCalculator.distance(ship3.getlAT(), ship2.getlAT(), ship3.getlON(), ship2.getlON()) + DistanceBetweenTwoPointsCalculator.distance(ship2.getlAT(), ship1.getlAT(), ship2.getlON(), ship1.getlON());
        assertEquals(actual2, expected2);

        list.add(shipA4);
        double actual3 = shipResume.getTravelDistance(list);
        double expected3 = DistanceBetweenTwoPointsCalculator.distance(ship3.getlAT(), ship2.getlAT(), ship3.getlON(), ship2.getlON()) + DistanceBetweenTwoPointsCalculator.distance(ship2.getlAT(), ship1.getlAT(), ship2.getlON(), ship1.getlON()) + DistanceBetweenTwoPointsCalculator.distance(ship1.getlAT(), ship4.getlAT(), ship1.getlON(), ship4.getlON());
        assertEquals(actual3, expected3);
    }

    @Test
    void getDeltaDistance() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("30/11/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("30/10/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/01/2021 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        list.add(shipA1);
        list.add(shipA2);


        double actual1 = shipResume.getDeltaDistance(list);
        double expected1 = DistanceBetweenTwoPointsCalculator.distance(ship2.getlAT(), ship1.getlAT(), ship2.getlON(), ship1.getlON());
        assertEquals(expected1, actual1);

        list.add(shipA3);
        double actual2 = shipResume.getDeltaDistance(list);
        double expected2 = DistanceBetweenTwoPointsCalculator.distance(ship3.getlAT(), ship1.getlAT(), ship3.getlON(), ship1.getlON());
        assertEquals(actual2, expected2);

        list.add(shipA4);
        double actual3 = shipResume.getDeltaDistance(list);
        double expected3 = DistanceBetweenTwoPointsCalculator.distance(ship3.getlAT(), ship4.getlAT(), ship3.getlON(), ship4.getlON());
        assertEquals(actual3, expected3);
        if (!ReadFilesController.isUseBigFiles()) {
            BuildTreeController.getInstance().resetShipTrees();

            readFilesController.load();
          //  System.out.println("Tree size: " + BuildTreeController.getInstance().getBSTByShipMMSI().size());
            List<ShipMMSI> list1 = new LinkedList<>();
            List<Map.Entry<Integer, ShipMMSI>> shipMMSIList = new LinkedList<>();
            for (ShipMMSI s : BuildTreeController.getInstance().getBSTByShipMMSI().inOrder()) {
                shipMMSIList.addAll(s.getMapList());
            }

            for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
                if (s.getKey() == 210950000) {
                    list1.add(s.getValue());
                }
            }
            list.sort(Comparator.comparing(ShipMMSI::getBaseDateTime));
         //   System.out.println("Inicio" + list.get(0).getBaseDateTime());
            list.sort((o1, o2) -> o2.getBaseDateTime().compareTo(o1.getBaseDateTime()));
        //    System.out.println("Fim" + list.get(0).getBaseDateTime());
       //     System.out.println("Size: " + list1.size());

            double actuall4 = shipResume.getDeltaDistance(list1);
            double expected4 = 58.869;
            assertEquals(actuall4, expected4);
        } else {
            BuildTreeController.getInstance().resetShipTrees();

            readFilesController.load();
    //        System.out.println("Tree size: " + BuildTreeController.getInstance().getBSTByShipMMSI().size());
            List<ShipMMSI> list1 = new LinkedList<>();
            List<Map.Entry<Integer, ShipMMSI>> shipMMSIList = new LinkedList<>();
            for (ShipMMSI s : BuildTreeController.getInstance().getBSTByShipMMSI().inOrder()) {
                shipMMSIList.addAll(s.getMapList());
            }

            for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
                if (s.getKey() == 366759530) {
                    list1.add(s.getValue());
                }
            }
            list.sort(Comparator.comparing(ShipMMSI::getBaseDateTime));
     //       System.out.println("Inicio" + list.get(0).getBaseDateTime());
            list.sort((o1, o2) -> o2.getBaseDateTime().compareTo(o1.getBaseDateTime()));
      //      System.out.println("Fim" + list.get(0).getBaseDateTime());
      //      System.out.println("Size: " + list1.size());

            double actuall4 = shipResume.getDeltaDistance(list1);
            double expected4 = 37.726;
            assertEquals(actuall4, expected4);
        }
    }

    @Test
    void checkIfMMSIExists() throws ParseException {
        readFilesController.load();
        assertNull(shipResume.getShipResume(210951111,BuildTreeController.getInstance().getBSTByShipMMSI()));
        }

}

