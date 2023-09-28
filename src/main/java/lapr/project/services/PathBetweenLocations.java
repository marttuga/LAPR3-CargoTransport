package lapr.project.services;

import lapr.project.graph.Algorithms;
import lapr.project.graph.Edge;
import lapr.project.graph.Graph;
import lapr.project.graph.matrix.MatrixGraph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;


import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class PathBetweenLocations {

    public LinkedList<Location> maritimePath(Graph<Location, Borders> graph, Location orig, Location dest, List<Location> intermediaryPoints, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path) {
        Graph<Location, Borders> cloneGraph = graph;

        for (Location l : cloneGraph.vertices()) {
            if (l.getType().equalsIgnoreCase("capital")) {
                cloneGraph.removeVertex(l);
            }

        }
        return pathWithMandatoryLocations(cloneGraph, orig, dest, intermediaryPoints, ce, sum, zero, path);
    }

    public LinkedList<Location> landPath(Graph<Location, Borders> graph, Location orig, Location dest, List<Location> intermediaryPoints, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path) {
        Graph<Location, Borders> cloneGraph = graph;

        for (Location l : cloneGraph.vertices()) {
            if (l.getType().equalsIgnoreCase("port") && !l.equals(orig) && !l.equals(dest)) {
                cloneGraph.removeVertex(l);
            }

        }

        return pathWithMandatoryLocations(cloneGraph, orig, dest, intermediaryPoints, ce, sum, zero, path);
    }

    public LinkedList<Location> pathWithMandatoryLocations(Graph<Location, Borders> graph, Location orig, Location dest, List<Location> mandatoryLocations, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path) {

        if (!graph.validVertex(orig) || !graph.validVertex(dest)) {
            return null; //verifica se ambos os pontos origem e destino pertencem ao graph
        }

        if (orig == dest) {
            path.add(orig); //no caso da origem ser igual ao destino retorna uma lista apenas com uma location
            return path;
        }

        path.clear();
        LinkedList<Location> tempPath = new LinkedList<>();

        List<Location> mandatory = new LinkedList<>(mandatoryLocations);//locations obrigatórias

        //Floyd-Warshall
        MatrixGraph<Location, Borders> minDistGraph = Algorithms.minDistGraph(graph, ce, sum);//algoritmo Floyd-Warshall para ir buscar as distancias minimas entre vertices
        assert minDistGraph != null;
        if (minDistGraph.edge(orig, dest) == null) return null;

        Borders maxValue = graph.edges().stream().map(Edge::getWeight).collect(Collectors.toList()).get(0);
        for (int i = 0; i < graph.numVertices(); i++) {
            maxValue = sum.apply(maxValue, graph.edges().stream().map(Edge::getWeight).collect(Collectors.toList()).get(i));
        }//ir buscar o edge com maior weight do grafo

        Borders min = maxValue;
        for (List<Location> vertexList : permutations(mandatory)) {//percorrer a lista de listas com as permutações dos caminhos mandatory
            vertexList.add(0, orig);//adicionar o ponto origem à posição zero
            vertexList.add(dest);
            Borders size = sizeWithMandatoryLocations(vertexList, minDistGraph, sum);//edge com maior weight da lista
            if (ce.compare(size, min) < 0) {// se min for maior que size
                min = size;//atualiza o min (atribui lhe o valor de size)
                tempPath.clear();//apaga o caminho temporário
                tempPath.addAll(vertexList);//adiciona um novo caminho temporario
            }
        }
        if (tempPath.size() == 0) return null;
        path.addAll(getShortPathWithMandatoryLocations(graph, ce, sum, zero, tempPath));//chamar o metodo para construir o short caminho final

        return path;
    }

    private Borders sizeWithMandatoryLocations(List<Location> vertexList, MatrixGraph<Location, Borders> minDistGraph, BinaryOperator<Borders> sum) {

        //Borders total = zero;
        Borders total = new Borders();
        if (vertexList.size() < 2) return total;

        Iterator<Location> iterator1 = vertexList.iterator();
        Iterator<Location> iterator2 = vertexList.iterator();
        iterator2.next();
        while (iterator2.hasNext()) {
            Location vertex1 = iterator1.next();
            Location vertex2 = iterator2.next();
            total = sum.apply(total, minDistGraph.edge(vertex1, vertex2).getWeight());
        }

        return total;
    }

    public List<List<Location>> permutations(List<Location> vertexList) {
        //fazer as permutações com todos os mandatory vertices
        //devolve uma lista de listas  com os caminhos possiveis entre as mandatory locations

        List<List<Location>> list = new LinkedList<>();
        if (vertexList.size() < 2) {
            list.add(vertexList);
            return list;
        }

        for (int i = 0; i < vertexList.size(); i++) {
            List<Location> vertexList2 = new LinkedList<>(vertexList);
            Location vertex = vertexList2.get(i);
            vertexList2.remove(i);
            List<List<Location>> permutationsList = permutations(vertexList2);
            for (List<Location> lp : permutationsList) lp.add(0, vertex);
            list.addAll(permutationsList);
        }
        return list;
    }

    private LinkedList<Location> getShortPathWithMandatoryLocations(Graph<Location, Borders> g, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path) {
        LinkedList<Location> tempPath = new LinkedList<>();
        LinkedList<Location> finalPath = new LinkedList<>();
        finalPath.add(path.get(0));//adiciona o ponto origem (posição 0)

        for (int i = 0; i < path.size() - 1; i++) {
            Algorithms.shortestPath(g, path.get(i), path.get(i + 1), ce, sum, zero, tempPath);//faz o shortest path entre vertices seguidos da lista
            for (int j = 1; j < tempPath.size(); j++) {//começa em 1 porque a origem já foi adicionada
                finalPath.add(tempPath.get(j));//criar construindo o caminho
            }
        }

        return finalPath;
    }



    /*public LinkedList<Location> LandAndSeaPath(Graph<Location, Borders> graph, Location vOrig, Location vDestino, List<Location> mandatoryLocations) {
        LinkedList<Location> pathRequired = new LinkedList<>();
        Map<Location, Double> map = new HashMap<>();
        pathRequired.add(vOrig);
        LinkedList<Location> path = new LinkedList<>();

        for (Location l : mandatoryLocations) {//Mandatory Locations
            Algorithms.shortestPath(graph, vOrig, l, Comparator.comparing(Borders::getWeight), BinaryOperator.minBy(Comparator.comparing(Borders::getWeight)), new Borders(), path);
            map.put(l, pathWeight(graph, path));
        }

        while (!map.isEmpty()) {
            Location closestLocation = getCloseLocation(map);
            pathRequired.add(closestLocation);
            map.remove(closestLocation, map.get(closestLocation));
            mandatoryLocations.remove(closestLocation);
            map = getNewAlteredMap(graph, closestLocation, mandatoryLocations);
        }

        Algorithms.shortestPath(graph, pathRequired.getLast(), vDestino, Comparator.comparing(Borders::getWeight), BinaryOperator.minBy(Comparator.comparing(Borders::getWeight)), new Borders(), path);

        for (Location location : path) {
            if (!pathRequired.contains(location)) {
                pathRequired.add(location);
            }
        }
        return pathRequired;
    }


    private Map<Location, Double> getNewAlteredMap(Graph<Location, Borders> graph, Location vOrig, List<Location> mandatoryLocations) {
        Map<Location, Double> map = new HashMap<>();
        LinkedList<Location> path = new LinkedList<>();
        for (Location l : mandatoryLocations) {
            Algorithms.shortestPath(graph, vOrig, l, Comparator.comparingDouble(Borders::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Borders::getWeight)), new Borders(), path);
            map.put(l, pathWeight(graph, path));
        }
        return map;
    }

    private List<Location> getList(List<Location> list, Location location) {
        List<Location> locationList = new LinkedList<>();
        for (Location l : list) {
            if (!l.equals(location)) {
                locationList.add(l);
            }
        }
        return locationList;
    }

    private Location getCloseLocation(Map<Location, Double> map) {
        Location l = null;
        double value = 0;
        for (Map.Entry<Location, Double> entry : map.entrySet()) {
            if (l == null) {
                l = entry.getKey();
                value = entry.getValue();
            } else if (entry.getValue() < value) {
                l = entry.getKey();
                value = entry.getValue();
            }
        }
        return l;
    }


    private double pathWeight(Graph<Location, Borders> graph, List<Location> path) {
        double total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            total += graph.edge(path.get(i), path.get(i + 1)).getWeight().getWeight();
        }
        return total;
    }*/
}
