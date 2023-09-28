package lapr.project.controller;

import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.services.PathBetweenLocations;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;

public class PathBetweenLocationsController {
    PathBetweenLocations pathBetweenLocations;
    public PathBetweenLocationsController() {
        pathBetweenLocations=new PathBetweenLocations();

    }

    public List<Location> landAndSeaPath(Graph<Location, Borders> graph, Location orig, Location dest, List<Location> intermediaryPoints, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path){
        return pathBetweenLocations.pathWithMandatoryLocations(graph,orig,dest,intermediaryPoints,ce,sum,zero,path);
    }


    public List<Location> maritimePath(Graph<Location, Borders> graph, Location orig, Location dest, List<Location> intermediaryPoints, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path){
        return pathBetweenLocations.maritimePath(graph,orig,dest,intermediaryPoints,ce,sum,zero,path);
    }

    public List<Location> landPath(Graph<Location, Borders> graph, Location orig, Location dest, List<Location> intermediaryPoints, Comparator<Borders> ce, BinaryOperator<Borders> sum, Borders zero, LinkedList<Location> path){
        return pathBetweenLocations.landPath(graph,orig,dest,intermediaryPoints,ce,sum,zero,path);
    }
}
