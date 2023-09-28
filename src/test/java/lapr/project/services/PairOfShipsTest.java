package lapr.project.services;

import lapr.project.controller.ReadFilesController;
import lapr.project.controller.BuildTreeController;
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

class PairOfShipsTest {
    ReadFilesController readFilesController;
    PairOfShips pairOfShips;
    ShipResume shipResume;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        pairOfShips = new PairOfShips();
        shipResume = new ShipResume();
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void pairOfShips() {
        List<ShipAtrib> listShips = new LinkedList<>();
        double d1 = 1.595;

        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        listShips.add(ship1);

        ShipAtrib ship2 = listShips.get(0);

        assertEquals(ship1, ship2);
    }

    /**
     * Test to ensure you correctly add a ship to the list
     */
    @Test
    void fillList() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ShipMMSI a = new ShipMMSI(ship1);
        list.add(a);
        Ship ship2 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        ShipMMSI b = new ShipMMSI(ship2);
        list.add(b);
        assertEquals(new ShipAtrib(210950000,0,0.0,0.0).toString(), pairOfShips.fillList(a, list).get(0).toString());

    }


    /**
     * Test to verify that it correctly calculates the delta distance of a given ship
     *
     * @throws ParseException the parse exception
     */
    @Test
    void dDistance1() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950003, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        list.add(shipA1);
        list.add(shipA2);
        double expected = pairOfShips.dDistance1(list, 210950000);
        double d = 0.0;
        assertEquals(d, expected);
    }

    /**
     * Test to verify that it correctly calculates the delta distance of a given ship
     *
     * @throws ParseException the parse exception
     */
    @Test
    void dDistance2() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        Ship ship2 = new Ship(210950003, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16"), 42.96912, -66.97061, 12.7, -55.4, 358, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 21, "B","12345");
        ShipMMSI shipA1 = new ShipMMSI(ship1);
        ShipMMSI shipA2 = new ShipMMSI(ship2);
        list.add(shipA1);
        list.add(shipA2);
        double expected = pairOfShips.dDistance2(list, 210950003);
        double d1 = 0.0;
        assertEquals(d1, expected);
    }


    /**
     * Test to see if it correctly returns the number of movements in a ships list
     *
     * @throws ParseException the parse exception
     */
    @Test
    void getNumberOfMovements() throws ParseException {
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

        double expected = pairOfShips.getNumberOfMovements(list, ship1.getmMSI());
        assertEquals(3, expected);
    }

    /**
     * Test to ensure the shipAtrib list is sorted
     */
    @Test
    void sort() {
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