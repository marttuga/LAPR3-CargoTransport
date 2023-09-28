package lapr.project.controller;

import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.services.PathBetweenLocations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class PathBetweenLocationsControllerTest {
    @BeforeEach
    void setUp() throws SQLException, IOException {
        BuildMatrixGraphController.getInstance().loadGraph();

    }

    @AfterEach
    void tearDown() {
        BuildMatrixGraphController.getInstance().resetMatrix();
    }

    PathBetweenLocationsController pathBetweenLocationsController = new PathBetweenLocationsController();

    @Test
    void LandAndSeaPathStartInCityEndsCity() throws SQLException, IOException {
        Location orig = new Location("PT", "capital", "Lisbon", 4, "Portugal", 0, 1);
        Location dest = new Location("TR", "capital", "Ankara", 5, "Turkey", 0, 1);
        Location mandatory1 = new Location("MC", "capital", "Monaco", 15, "Monaco", 0, 1);
        Location mandatory2 = new Location("20301", "port", "Matarani", 533922, "Portugal", 4, 19);

        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> intermediaryPoints = new LinkedList<>();

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        intermediaryPoints.add(mandatory1);
        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        intermediaryPoints.add(mandatory2);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));
    }

    @Test
    void LandAndSeaPathStartInPortEndsInCity() throws SQLException, IOException {

        Location dest = new Location("TR", "capital", "Ankara", 5, "Turkey", 0, 1);
        Location orig = new Location("20301", "port", "Matarani", 533922, "Portugal", 4, 19);
        Location mandatory1 = new Location("MC", "capital", "Monaco", 15, "Monaco", 0, 1);
        Location mandatory2 = new Location("10563", "port", "Rostock", 571059, "Germany", 35, 10);

        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> intermediaryPoints = new LinkedList<>();

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));
        intermediaryPoints.add(mandatory1);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));
        intermediaryPoints.add(mandatory2);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

    }

    @Test
    void LandAndSeaPathStartInPortEndsInPort() throws SQLException, IOException {

        Location mandatory1 = new Location("MC", "capital", "Monaco", 15, "Monaco", 0, 1);
        Location mandatory2 = new Location("TR", "capital", "Ankara", 5, "Turkey", 0, 1);
        Location mandatory3 = new Location("10358", "port", "Zeebrugge", 332698, "Netherlands", 34, 57);
        Location orig = new Location("20301", "port", "Matarani", 533922, "Portugal", 4, 19);
        Location dest = new Location("10563", "port", "Rostock", 571059, "Germany", 35, 10);
        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> intermediaryPoints = new LinkedList<>();

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        intermediaryPoints.add(mandatory1);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        intermediaryPoints.add(mandatory2);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory3));

        intermediaryPoints.add(mandatory3);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landAndSeaPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory3));

    }

    @Test
    void MaritimePath() throws SQLException, IOException {

        Location mandatory1 = new Location("29002", "port", "Marsaxlokk", 445419, "Cyprus", 1, 35);
        Location mandatory2 = new Location("14635", "port", "Aarhus", 621073, "Malta", 2, 32);
        Location mandatory3 = new Location("10358", "port", "Zeebrugge", 332698, "Netherlands", 34, 57);
        Location orig = new Location("20301", "port", "Matarani", 533922, "Portugal", 4, 19);
        Location dest = new Location("10563", "port", "Rostock", 571059, "Germany", 35, 10);
        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> intermediaryPoints = new LinkedList<>();

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.maritimePath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        intermediaryPoints.add(mandatory1);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.maritimePath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.maritimePath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        intermediaryPoints.add(mandatory2);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.maritimePath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.maritimePath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory3));

        intermediaryPoints.add(mandatory3);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.maritimePath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory3));
    }

/*    @Test
    void MaritimePathOrigDestCity() throws SQLException, IOException {
       Location mandatory1 = new Location("27248", "port", "Grundartangi", 199859, "Armenia", 6, 52);

        Location mandatory2 = new Location("20351", "port", "Genoa", 535090, "Turkey", 5, 65);
        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> intermediaryPoints = new LinkedList<>();
        Location orig = new Location("PT", "capital", "Lisbon", 4, "Portugal", 0, 1);

        Location dest = new Location("MC", "capital", "Monaco", 15, "Monaco", 0, 1);
        assertFalse(Objects.requireNonNull(PathBetweenLocations.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        intermediaryPoints.add(mandatory1);


        assertTrue(Objects.requireNonNull(PathBetweenLocations.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        assertFalse(Objects.requireNonNull(PathBetweenLocations.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        intermediaryPoints.add(mandatory2);

        assertTrue(Objects.requireNonNull(PathBetweenLocations.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

    }*/

    @Test
    void landPath() throws SQLException, IOException {
        Location mandatory1 = new Location("MC", "capital", "Monaco", 15, "Monaco", 0, 1);
        Location mandatory2 = new Location("PT", "capital", "Lisbon", 4, "Portugal", 0, 1);
        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> intermediaryPoints = new LinkedList<>();
        Location orig = new Location("20351", "port", "Genoa", 535090, "Turkey", 5, 65);
        Location dest = new Location("27248", "port", "Grundartangi", 199859, "Armenia", 6, 52);

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        intermediaryPoints.add(mandatory1);


        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory1));

        assertFalse(Objects.requireNonNull(pathBetweenLocationsController.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

        intermediaryPoints.add(mandatory2);

        assertTrue(Objects.requireNonNull(pathBetweenLocationsController.landPath(BuildMatrixGraphController.getInstance().getLocationMap(), orig, dest, intermediaryPoints, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path)).contains(mandatory2));

    }

}