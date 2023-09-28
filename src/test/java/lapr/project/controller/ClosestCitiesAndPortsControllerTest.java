package lapr.project.controller;

import lapr.project.model.Location.Location;
import lapr.project.services.ClosestCitiesAndPorts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClosestCitiesAndPortsControllerTest {

    ClosestCitiesAndPortsController closestCitiesAndPorts;

    @BeforeEach
    void setUp() {
        closestCitiesAndPorts = new ClosestCitiesAndPortsController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getClosestPlaces() throws SQLException, IOException {
        BuildMatrixGraphController.getInstance().loadGraph();
        Location cap1 = new Location("PT", "capital", "Lisbon", 4, "Portugal", 0, 1);
        Map<String, LinkedList<Location>> map1 = closestCitiesAndPorts.getClosestPlaces(BuildMatrixGraphController.getInstance().getLocationMap(), cap1, 1, BuildMatrixGraphController.getInstance().getCountries());
        assertEquals(1, map1.get("Europe").size());
        assertEquals("Lisbon", map1.get("Europe").get(0).getName());

        Map<String, LinkedList<Location>> map2 = closestCitiesAndPorts.getClosestPlaces(BuildMatrixGraphController.getInstance().getLocationMap(), cap1, 2, BuildMatrixGraphController.getInstance().getCountries());
        assertEquals(2, map2.get("Europe").size());
        assertEquals("Lisbon", map2.get("Europe").get(0).getName());
        assertEquals("Matarani", map2.get("Europe").get(1).getName());

        Map<String, LinkedList<Location>> map3 = closestCitiesAndPorts.getClosestPlaces(BuildMatrixGraphController.getInstance().getLocationMap(), cap1, 3, BuildMatrixGraphController.getInstance().getCountries());
        assertEquals(3, map3.get("Europe").size());
        assertEquals("Lisbon", map3.get("Europe").get(0).getName());
        assertEquals("Matarani", map3.get("Europe").get(1).getName());
        assertEquals("Madrid", map3.get("Europe").get(2).getName());

    }
}