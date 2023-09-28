/*
package lapr.project.controller;

import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipMMSI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MostTravelledDistanceControllerTest {

    ReadFilesController readFilesController;
    MostTravelledDistanceController mostTravelledDistance;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        mostTravelledDistance = new MostTravelledDistanceController();
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void getTopNShips() throws ParseException {
        readFilesController.load();
        List<ShipMMSI> listVesselType1= new LinkedList<>();
        listVesselType1.add(new ShipMMSI(new Ship(257881000,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:50"),24.2153,-84.80182,12.133,117.7,113,"SPAR ARIES","IMO9701920","LATO7",70,199,32,13.3,0,"B",18415),6.045));
        listVesselType1.add(new ShipMMSI(new Ship(210950000,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:31"),43.22513,-66.96725,11.7,5.5,355,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5,0,"B",12345),0.00));
        listVesselType1.add(new ShipMMSI(new Ship(636091400,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:26"),23.07187,-83.53367,15.9,66.2,68,"SPAR ARIES","IMO9395044","A8ND5",70,176,27,10.9,71,"B",23181),0.00));
        listVesselType1.add(new ShipMMSI(new Ship(249047000,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:35"),25.74774,-78.29988,0.033,30,138,"CELEBRITY SUMMIT","IMO9192387","9HJC9",60,294,32,8,0,"A",15310),0.014));
        listVesselType1.add(new ShipMMSI(new Ship(309416000,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:56"),25.83611,-78.50491,1.1,34.1,83,"SEABOURN ODYSSEY","IMO9417086","C6XC6",60,198,26,6.4,0,"A",17465),0.00));
        listVesselType1.add(new ShipMMSI(new Ship(636092932,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:49"),26.52601,-78.76733,0.0,-190.6,219,"MSC ILONA","IMO9225641","D5VK6",79,299,40,11.8,79,"A",26039),0.00));
        Map<Integer, List<ShipMMSI>> groupedMap = listVesselType1.stream().collect(Collectors.groupingBy(ShipMMSI::getVesselType));

        List<Map.Entry<Integer, List<ShipMMSI>>> groupedList = new LinkedList<>(groupedMap.entrySet());

        List<Map.Entry<Integer, List<ShipMMSI>>> topList= mostTravelledDistance.getTopNShips(BuildTreeController.getInstance().getBSTByShipMMSI(),new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 18:00"),new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:00"),3);
        assertEquals(groupedList.toString(),topList.toString());
    }

    @Test
    void containShip() throws ParseException {
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B",12345);
        ShipMMSI a = new ShipMMSI(ship1);

        list.add(a);
        assertTrue(mostTravelledDistance.containShip(list, 210950000));
    }

    @Test
    void sameMMSIList() throws ParseException {
        List<ShipMMSI> listt = new LinkedList<>();
        List<ShipMMSI> list = new LinkedList<>();
        Ship ship1 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B",12345);
        ShipMMSI shipMMSI = new ShipMMSI(ship1);
        Ship ship2 = new Ship(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:18"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B",12345);
        ShipMMSI shipMMSI2 = new ShipMMSI(ship2);
        Ship ship3 = new Ship(210950001, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:18"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B",12345);
        ShipMMSI shipMMSI3 = new ShipMMSI(ship3);
        listt.add(shipMMSI);
        listt.add(shipMMSI2);
        listt.add(shipMMSI3);
        list.add(shipMMSI);
        list.add(shipMMSI2);
        assertEquals(list, mostTravelledDistance.sameMMSIList(listt, 210950000));
    }

}*/
