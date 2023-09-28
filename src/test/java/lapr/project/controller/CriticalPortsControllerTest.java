package lapr.project.controller;

import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriticalPortsControllerTest {
    CriticalPortsController criticalPortsController;

    @BeforeEach
    void setUp() {
        criticalPortsController = new CriticalPortsController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPortsCriticality() throws SQLException, IOException {
        BuildMatrixGraphController.getInstance().loadGraph();
        Graph<Location, Borders> graph = BuildMatrixGraphController.getInstance().getLocationMap();
        List<Location> allLocations = BuildMatrixGraphController.getInstance().getPorts();
        List<Location> actual1 = new LinkedList<>();
        List<Location> expected1 = criticalPortsController.getPortsCriticality(graph, 1, allLocations);
        assertEquals(expected1.size(), 1);
        Location l1 = new Location("25350", "port", "Gdansk", 101472, "Albania", 8, 66);
        actual1.add(l1);
        assertEquals(expected1, actual1);

        List<Location> actual2 = new LinkedList<>();
        List<Location> expected2 = criticalPortsController.getPortsCriticality(graph, 2, allLocations);
        assertEquals(expected2.size(), 2);
        actual2.add(l1);
        Location l2 = new Location("18476", "port", "Mareiro", 848581, "Romania", 17, 16);
        actual2.add(l2);
        assertEquals(expected2, actual2);


    }
}