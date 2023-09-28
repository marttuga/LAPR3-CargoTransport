package lapr.project.services;

import lapr.project.graph.Algorithms;
import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;

import java.util.*;
import java.util.function.BinaryOperator;

public class CriticalPorts {


    public List<Location> getPortsCriticality(Graph<Location, Borders> graph, int nPorts, List<Location> locationList) {
        List<Location> returnList = new LinkedList<>();
        Map<Location, Integer> map = new HashMap<>();

        for (Location location : locationList) {
            ArrayList<LinkedList<Location>> paths = new ArrayList<>();
            ArrayList<Borders> dists = new ArrayList<>();

            Algorithms.shortestPaths(graph, location,Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), paths, dists);


            for (LinkedList<Location> l1 : paths) {
                if (l1 != null) {
                    for (Location l2 : l1) {
                        if (l2.getType().equals("port")) {
                            if (!map.containsKey(l2)) {
                                map.put(l2, 1);
                            } else {
                                int value = map.get(l2) + 1;
                                map.replace(l2, value);
                            }
                        }
                    }
                }
            }
        }
        List<Map.Entry<Location, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Location, Integer> entry : list) {
            if (returnList.size() < nPorts) {
                returnList.add(entry.getKey());
            }
        }
        return returnList;


    }


}
