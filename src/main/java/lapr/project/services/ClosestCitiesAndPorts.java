package lapr.project.services;

import lapr.project.graph.Algorithms;
import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Country;
import lapr.project.model.Location.Location;
//import lapr.project.utils.ClosestPlacesSystem;

import java.util.*;
import java.util.function.BinaryOperator;

public class ClosestCitiesAndPorts {

    public Map<String, LinkedList<Location>> getClosestPlaces(Graph<Location, Borders> graph, Location place, int nClosest, List<Country> countries) {
        ArrayList<LinkedList<Location>> paths = new ArrayList<>();
        ArrayList<Borders> dists = new ArrayList<>();
        //chamar o shortestPaths: obter todos os caminhos de uma dada posição para todas as outras posições
        //mando um sitio e ele dá todos os caminhos até as outras posições que existem no mapa
        Algorithms.shortestPaths(graph, place, Comparator.comparing(Borders::getWeight), BinaryOperator.minBy(Comparator.comparing(Borders::getWeight)), new Borders(), paths, dists);


        // Location,  path size
        Map<Location, Integer> map = new HashMap<>(); //todas as ultimas posiçoes do caminho, com o seu tamanho

        for (LinkedList<Location> path : paths) { //percorro os caminhos, um de cada vez
            if (path != null) { //para não por reetidos
                if (!map.containsKey(path.getLast())) {
                    map.put(path.getLast(), path.size());//ve o size
                }
            }
        }

        //meto a lista no mapa, mete os valores do mapa numa lista(map.entrySet)
        LinkedList<Map.Entry<Location, Integer>> mapOrderedByShortPath = new LinkedList<>(map.entrySet());

        mapOrderedByShortPath.sort(Comparator.comparingInt(Map.Entry::getValue));//faço um sort para ordenar o tamanho dos caminhos

        //lista de string que vao ser os continentes, a linked list vai ser uma location desse continent

        //continent, Location
        Map<String, LinkedList<Location>> mapOrderedByContinent = new HashMap<>();

        for (Country continents : countries) { //lista de countries para por os continents num map
            mapOrderedByContinent.put(continents.getContinent(), new LinkedList<>());
        }

        //mete as locations no respetivo continente
        for (Map.Entry<String, LinkedList<Location>> entry1 : mapOrderedByContinent.entrySet()) {

            for (Map.Entry<Location, Integer> entry2 : mapOrderedByShortPath) {
                if (belongsToContinent(countries, entry1.getKey(), entry2.getKey())) { // lista de countries
                    if (entry1.getValue().size() < nClosest) { //verificar se a lista que eu envio que terá
                        LinkedList<Location> places = entry1.getValue(); //entra a location com menor caminho
                        places.add(entry2.getKey()); //
                        entry1.setValue(places); //
                    }
                }
            }
        }
        //ClosestPlacesSystem.outPutResume(mapOrderedByContinent.toString());
        return mapOrderedByContinent;
    }
    
    private boolean belongsToContinent(List<Country> continents, String continent, Location location) {
        for (Country c : continents) { //percorrer a lista de countries, para ver o continente e ver se a location faz parte desse continente
            if (c.getCountry().equals(location.getCountry()) && c.getContinent().equals(continent)) {
                return true;
            }
        }
        return false;
    }

}
