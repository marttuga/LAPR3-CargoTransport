package lapr.project.services;

import lapr.project.controller.BuildMatrixGraphController;
import lapr.project.graph.Graph;
import lapr.project.graph.matrix.MatrixGraph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ColorMapTest {


    ColorMap colorMap  = new ColorMap();
@Test
    void colorVertices() throws IOException, SQLException {
        GraphMatrixCreate graphMatrixCreate = new GraphMatrixCreate();
        graphMatrixCreate.resetMatrix();
        BuildMatrixGraphController.getInstance().loadGraph();
        Graph<Location, Borders> graph = BuildMatrixGraphController.getInstance().getLocationMap();
        //Check if all countries were coloured
        assertEquals(68, colorMap.colorVertices(graph).size());
        //Get colors of neighbour countries
        assertEquals(1, colorMap.colorVertices(graph).get(new Location("PT","capital", "Lisbon", 4, "Portugal", 0, 1)));
        assertEquals(0, colorMap.colorVertices(graph).get(new Location("ES","capital", "Madrid", 7, "Spain", 0, 1)));
        assertEquals(1, colorMap.colorVertices(graph).get(new Location("FR","capital", "Paris", 27, "France", 0, 1)));
        assertEquals(2, colorMap.colorVertices(graph).get(new Location("BE","capital", "Brussels", 31, "Belgium", 0, 1)));
        assertEquals(0, colorMap.colorVertices(graph).get(new Location("DE","capital", "Berlin", 35, "Germany", 0, 1)));
        assertEquals(1, colorMap.colorVertices(graph).get(new Location("NL","capital", "Amsterdam", 34, "Netherlands", 0, 1)));
        assertEquals(3, colorMap.colorVertices(graph).get(new Location("LU","capital", "Luxembourg", 28, "Luxembourg", 0, 1)));
        }

}