package lapr.project.services;

import lapr.project.controller.ReadFilesController;
import lapr.project.controller.BuildTreeController;
import lapr.project.model.ship.PositionalMessage;
import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipMMSI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipSortedTemporallyTest {

    ReadFilesController readFilesController;
    ShipSortedTemporally shipSortedTemporally;


    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        shipSortedTemporally = new ShipSortedTemporally();
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void sortTemporally() throws ParseException {
        readFilesController.load();
        List<ShipMMSI> list1 = shipSortedTemporally.sortTemporally(212180000, BuildTreeController.getInstance().getBSTByShipMMSI());

        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship2 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 20:17"), 24.28016, -85.00316, 11.3, 120.8, 118, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship3 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:07"), 24.20221, -84.85411, 11.3, 116.8, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship4 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:49"), 24.14301, -84.72268, 11.7, 116.6, 114, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship5 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:10"), 24.11445, -84.65529, 11.6, 113.3, 110, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        ShipMMSI shipA5 = new ShipMMSI(ship5);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        list.add(shipA5);

        assertEquals(list.toString(),list1.toString());
    }

    @Test
    void sortTemporallyNoShip() throws ParseException {
        readFilesController.load();
        List<ShipMMSI> list1 = shipSortedTemporally.sortTemporally(212180001, BuildTreeController.getInstance().getBSTByShipMMSI());

        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship2 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 20:17"), 24.28016, -85.00316, 11.3, 120.8, 118, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship3 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:07"), 24.20221, -84.85411, 11.3, 116.8, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship4 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:49"), 24.14301, -84.72268, 11.7, 116.6, 114, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship5 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:10"), 24.11445, -84.65529, 11.6, 113.3, 110, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        ShipMMSI shipA5 = new ShipMMSI(ship5);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        list.add(shipA5);

        assertEquals(null,list1);
    }



    @Test
    void positionValues() throws ParseException {
        readFilesController.load();
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship2 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 20:17"), 24.28016, -85.00316, 11.3, 120.8, 118, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship3 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:07"), 24.20221, -84.85411, 11.3, 116.8, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship4 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:49"), 24.14301, -84.72268, 11.7, 116.6, 114, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship5 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:10"), 24.11445, -84.65529, 11.6, 113.3, 110, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        ShipMMSI shipA5 = new ShipMMSI(ship5);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        list.add(shipA5);
        List<PositionalMessage> positiontest = new LinkedList<>();
        PositionalMessage a= new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        PositionalMessage b= new PositionalMessage(212180000,70,11.3,120.8,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 20:17"),24.28016,-85.00316);
        PositionalMessage c= new PositionalMessage(212180000,70,11.3,116.8,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:07"),24.20221,-84.85411);
        positiontest.add(a);
        positiontest.add(b);
        positiontest.add(c);
        List<PositionalMessage> actualPositions = shipSortedTemporally.positionValues(list, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:30"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:30"));
        assertEquals(positiontest.toString(), actualPositions.toString());
    }

    @Test
    void positionValuesNoDate() throws ParseException {
        readFilesController.load();
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"), 24.34573, -85.12394, 11.7, 119.9, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship2 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 20:17"), 24.28016, -85.00316, 11.3, 120.8, 118, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship3 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:07"), 24.20221, -84.85411, 11.3, 116.8, 117, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "A","32454");
        Ship ship4 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 21:49"), 24.14301, -84.72268, 11.7, 116.6, 114, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");
        Ship ship5 = new Ship(212180000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:10"), 24.11445, -84.65529, 11.6, 113.3, 110, "SAITA I", "IMO9643544", "5BBA4", 70, 228, 32, 14.4, 0, "B","32454");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);
        ShipMMSI shipA5 = new ShipMMSI(ship5);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        list.add(shipA5);
        assertNull(shipSortedTemporally.positionValues(list, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/12/2020 19:30"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/12/2020 20:30")));
    }


    @Test
    void checkDate() throws ParseException {
        Date date=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/12/2020 22:10");
        Date date2=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("30/12/2020 22:10");
        Date date3=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("30/12/2020 15:30");
        assertTrue(shipSortedTemporally.checkDate(date, date2, date3));
    }


}