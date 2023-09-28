package lapr.project.controller;

import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipAtrib;
import lapr.project.model.ship.ShipMMSI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairOfShipsControllerTest {
    PairOfShipsController pairOfShips;
    ReadFilesController readFilesController;

    @BeforeEach
    void setUp() {
        pairOfShips = new PairOfShipsController();
        readFilesController = new ReadFilesController();

    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void pairOfShips() {
        readFilesController.load();
        if (!ReadFilesController.isUseBigFiles()) {
            List<ShipAtrib> list = pairOfShips.pairShips(BuildTreeController.getInstance().getBSTByShipMMSI());
            ShipAtrib sA = list.get(0);
            double d1 = 58.869;
            double d2 = 54.033;

            ShipAtrib sB = new ShipAtrib(210950000, 212180000, d1,
                    d2, 24, 58.875, 4, 54.076);


            assertEquals(sA, sB);
        }
    }

    @Test
    void fillList() throws ParseException {

        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);

        list.add(shipA1);
        list.add(shipA2);
        List<ShipMMSI> list1 = new LinkedList<>();
        list1.add(shipA1);
        boolean a = pairOfShips.fillList(shipA1, list).get(0).getmMSI() == shipA1.getmMSI();
       // System.out.println(pairOfShips.fillList(shipA1, list));
        assertTrue(a);
        boolean b = pairOfShips.fillList(shipA2, list).get(0).getmMSI() == shipA2.getmMSI();
        assertTrue(b);

    }

    @Test
    void dDistance1() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(23.239,pairOfShips.dDistance1(list, ship1.getmMSI()));
        assertEquals(5.202,pairOfShips.dDistance1(list, ship2.getmMSI()));

    }
    @Test
    void dDistance2() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(23.239,pairOfShips.dDistance2(list, ship1.getmMSI()));
        assertEquals(5.202,pairOfShips.dDistance2(list, ship2.getmMSI()));
    }
    @Test
    void getNumberOfMovements() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 42.92236, -66.97243, 12.5, 2.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 34, "B","12345");
        Ship ship3 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/12/2020 16:20"), 42.7698, -66.9759, 13.3, 3.7, 356, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 22, "B","12345");
        Ship ship4 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");

        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        ShipMMSI shipA3 = new ShipMMSI(ship3);
        ShipMMSI shipA4 = new ShipMMSI(ship4);

        list.add(shipA1);
        list.add(shipA2);
        list.add(shipA3);
        list.add(shipA4);
        assertEquals(1,pairOfShips.getNumberOfMovements(list, ship1.getmMSI()));
        assertEquals(1,pairOfShips.getNumberOfMovements(list, ship2.getmMSI()));
    }
    @Test
    void sort(){
        List<ShipAtrib> listShips = new LinkedList<>();
        List<ShipAtrib> listDes = new LinkedList<>();
        double d1 = 1.595;

        ShipAtrib ship3 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        ShipAtrib ship4 = new ShipAtrib(366759530, 366772760, d1, d1, 1217, 78.724, 1237, 344.448);
        listShips.add(ship4);
        listShips.add(ship3);

        listDes.add(ship4);
        listDes.add(ship3);
        listDes = pairOfShips.sort(listDes);

        assertEquals(listDes, listShips);

    }
}