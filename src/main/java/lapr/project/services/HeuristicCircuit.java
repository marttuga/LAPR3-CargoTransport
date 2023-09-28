


package lapr.project.services;

import lapr.project.graph.Algorithms;
import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HeuristicCircuit {

    public List<Location> heuristicCircuit(Graph<Location, Borders> graph) {

        ArrayList<LinkedList<Location>> list = new ArrayList<>();
        for (Location location : graph.vertices()) {//Percorrer a lista de todos os vertices (locations) do graph
            LinkedList<Location> list1 = nearestLocation(graph, location);//ir buscar a lista de locations mais proximas de cada um desses vertices
            list.add(list1);//guardar essa lista de localizações mais próximas num arrayList de listas
        }

        ArrayList<LinkedList<Location>> circuits = new ArrayList<>();
        for (LinkedList<Location> list1 : list) {//percorrer a lista com as locations mais proximas de uma determinada location
            LinkedList<Location> circuit = Algorithms.findCircuit(graph, list1);//para cada lista ir executar o metodo findCircuit que devolve um caminho em quem o vertice destino forma um edge com o vertice origem
            if (circuit != null) {
                circuits.add(circuit);// guardar os circuitos
            }
        }
        ArrayList<LinkedList<Location>> paths = Algorithms.findBiggestCircuit(circuits);//recebe um array list com os circuitos e devolve o circuito com mais locations (maior size)
        List<Location> locationList = new LinkedList<>();
        if (!paths.isEmpty()) {
            locationList = getLessWeightBiggestCycle(graph, paths);//recebe o grafo e a lista de paths e devolve o caminho já formado com vertice origem e destino iguais
            System.out.println(locationList);
        }

        return locationList;
    }

    public LinkedList<Location> nearestLocation(Graph<Location, Borders> graph, Location location) {
        if (!graph.validVertex(location))
            return null;
        LinkedList<Location> list = new LinkedList<>();
        boolean[] visited = new boolean[graph.numVertices()];
        Algorithms.nearestLocationSearch(graph, location, visited, list);
        return list;
    }

    public LinkedList<Location> getLessWeightBiggestCycle(Graph<Location, Borders> graph, ArrayList<LinkedList<Location>> paths) {
        return paths.get(getPathIndex(paths, graph));//devolve o maior caminho com o maior numero de locations e com menor distancia percorrida
    }

    public int getPathIndex(ArrayList<LinkedList<Location>> paths, Graph<Location, Borders> graph) {
        double pathWeight = 0;
        int i = 0;
        for (LinkedList<Location> p : paths) {
            double weight = pathWeight(graph, p);
            if (weight < pathWeight) {
                pathWeight = weight;
                i = paths.indexOf(p);
            }

        }
        return i;
    }

    public double pathWeight(Graph<Location, Borders> graph, LinkedList<Location> path) {//calcula o weight do caminho
        double result = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            result += Objects.requireNonNull(graph.edge(path.get(i), path.get(i + 1))).getWeight().getWeight();
        }
        return result;
    }
}


