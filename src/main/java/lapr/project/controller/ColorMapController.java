package lapr.project.controller;

import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.services.ColorMap;
import lapr.project.utils.ColorMapOutput;

import java.util.HashMap;

public class ColorMapController {

    ColorMap colorMap = new ColorMap();

    public HashMap<Location, Integer> colorVertices(Graph<Location, Borders> graph) {
        ColorMapOutput.outPutColoredMap(colorMap.colorVertices(graph).toString());
        return colorMap.colorVertices(graph);
    }
}
