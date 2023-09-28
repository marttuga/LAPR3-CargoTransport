package lapr.project.controller;

import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Country;
import lapr.project.model.Location.Location;
import lapr.project.services.ClosestCitiesAndPorts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClosestCitiesAndPortsController {

    ClosestCitiesAndPorts closestCitiesAndPorts=new ClosestCitiesAndPorts();


    public Map<String, LinkedList<Location>> getClosestPlaces(Graph<Location, Borders> graph, Location place, int nClosest, List<Country> countries) {
        return closestCitiesAndPorts.getClosestPlaces(graph,place,nClosest,countries);
    }
}
