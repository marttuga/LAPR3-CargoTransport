package lapr.project.controller;

import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.services.CriticalPorts;

import java.util.List;

public class CriticalPortsController {

    CriticalPorts criticalPorts = new CriticalPorts();

    public List<Location> getPortsCriticality(Graph<Location, Borders> graph, int nPorts, List<Location> locationList) {
      return   criticalPorts.getPortsCriticality(graph, nPorts, locationList);
    }


}
