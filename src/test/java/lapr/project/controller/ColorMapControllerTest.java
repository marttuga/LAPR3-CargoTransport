package lapr.project.controller;

import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.services.ColorMap;
import lapr.project.services.GraphMatrixCreate;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ColorMapControllerTest {

    ColorMapController colorMap  = new ColorMapController();
    @Test
    void colorVertices() throws SQLException, IOException {
        GraphMatrixCreate graphMatrixCreate = new GraphMatrixCreate();
        graphMatrixCreate.resetMatrix();
        BuildMatrixGraphController.getInstance().loadGraph();
        Graph<Location, Borders> graph = BuildMatrixGraphController.getInstance().getLocationMap();
        assertEquals(0, colorMap.colorVertices(graph).get(new Location("IT","capital", "Rome", 10, "Italy", 0, 1)));
        assertEquals(1, colorMap.colorVertices(graph).get(new Location("AR","capital", "Buenos Aires", 58, "Argentina", 0, 1)));
        assertEquals(2, colorMap.colorVertices(graph).get(new Location("BG","capital", "Sofia", 14, "Bulgaria", 0, 1)));
        assertEquals(3, colorMap.colorVertices(graph).get(new Location("HR","capital", "Zagreb", 19, "Croatia", 0, 1)));

    }
}