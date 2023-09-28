package lapr.project.services;

import lapr.project.graph.Edge;
import lapr.project.graph.matrix.MatrixGraph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.model.Location.Position;
import lapr.project.model.Location.SeaDists;
import lapr.project.utils.DistanceBetweenTwoPointsCalculator;

import java.util.*;

public class GraphMatrixCreate {

    private MatrixGraph<Location, Borders> locationMap;

    public GraphMatrixCreate() {
        this.locationMap = new MatrixGraph<>(false);
    }

    public void addCapitalVertex(Location location) {
        locationMap.addVertex(location);
    }

    public void addCapitalConnections(List<Location> capitals, List<Borders> borders, List<Position> capitalPosition) {
        for (Borders b : borders) {
            Location orig = getLocationByCountry(capitals, b.getCountryOrigin());
            Location destiny = getLocationByCountry(capitals, b.getCountryDestiny());
            if (orig != null && destiny != null) {
                b.setWeight(calculateDistance(Objects.requireNonNull(getLocationPosition(capitalPosition, orig)), Objects.requireNonNull(getLocationPosition(capitalPosition, destiny))));
                locationMap.addEdge(orig, destiny, b);
            }
        }
    }

    public void addPortVertex(Location location) {
        locationMap.addVertex(location);
    }

    public void addPortConnections(List<SeaDists> portsConnections, List<Location> ports) {
        Map<String, List<Location>> sameCountryPorts = mapPortsOfCountry(ports);
        for (SeaDists s : portsConnections) {
            List<Location> sameCountryPortsList = sameCountryPorts.get(s.getCountryDestiny());
            if (sameCountryPortsList != null) {
                if (containsPorts(sameCountryPortsList, s.getPortOrigin(), s.getPortDestiny())) {
                    Location orig = getPortByName(ports, s.getPortOrigin());
                    Location destiny = getPortByName(ports, s.getPortOrigin());
                    if (connectionDoestNotExist(orig, destiny)) {
                        Borders borders = new Borders(orig.getCountry(), destiny.getCountry());
                        borders.setWeight(s.getSeaDists());
                        locationMap.addEdge(orig, destiny, borders);
                    }
                }
            }
        }
    }

    public void addConnectionBetweenCapitalAndPort(List<Location> capitals, List<Location> ports, List<Position> capitalPositions, List<Position> portsPosition) {
        Map<String, List<Location>> sameCountryPorts = mapPortsOfCountry(ports);
        for (Location capital : capitals) {
            Position capitalPosition = getLocationPosition(capitalPositions, capital);
            List<Location> list = sameCountryPorts.get(capital.getCountry());
            if (list != null) {
                Location port = getClosestPort(capitalPosition, list, portsPosition);
                if (port != null) {
                    Borders border = new Borders(capital.getName(), port.getName());
                    border.setWeight(calculateDistance(Objects.requireNonNull(getLocationPosition(capitalPositions, capital)), Objects.requireNonNull(getLocationPosition(portsPosition, port))));
                    locationMap.addEdge(capital, port, border);
                }
            }

        }
    }

    public void addConnectionBetweenNClosestPorts(int n, List<Location> ports, List<Position> portsPosition) {
        for (Location l : ports) {
            List<Location> p = getOtherCountryPorts(n, l, ports, portsPosition);
            for (Location lo : p) {
                if (connectionDoestNotExist(l, lo)) {
                    Borders borders = new Borders(l.getCountry(), lo.getCountry());
                    Position p1 = getLocationPosition(portsPosition, l);
                    Position p2 = getLocationPosition(portsPosition, lo);
                    assert p1 != null;
                    assert p2 != null;
                    borders.setWeight(calculateDistance(p1, p2));
                    locationMap.addEdge(l, lo, borders);
                }
            }
        }
    }


    //TODO:AUXILIAR METHODS
    public boolean connectionDoestNotExist(Location l1, Location l2) {
        for (Edge<Location, Borders> a : locationMap.edges()) {
            if ((a.getVOrig().equals(l1) && a.getVDest().equals(l2)) || (a.getVOrig().equals(l2) && a.getVDest().equals(l1))) {
                return false;
            }
        }
        return true;
    }

    public List<Location> getOtherCountryPorts(int n, Location location, List<Location> ports, List<Position> portsPosition) {
        List<Location> otherCountriesPorts = new LinkedList<>();
        Map<Location, Double> map = new HashMap<>();
        for (Location l : ports) {
            if (!l.getCountry().equals(location.getCountry())) {
                Position p1 = getLocationPosition(portsPosition, location);
                Position p2 = getLocationPosition(portsPosition, l);
                assert p2 != null;
                assert p1 != null;
                map.put(l, calculateDistance(p1, p2));
            }
        }
        List<Map.Entry<Location, Double>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Location, Double> l : list) {
            if (n > otherCountriesPorts.size()) {
                otherCountriesPorts.add(l.getKey());
            }
        }

        return otherCountriesPorts;
    }

    private boolean containsPorts(List<Location> tmp, String portOrigin, String portDestiny) {
        boolean a = false;
        boolean b = false;

        for (Location l : tmp) {
            if (l.getName().equals(portOrigin) && !a) {
                a = true;
            }
            if (l.getName().equals(portDestiny) && !b) {
                b = true;
            }
        }
        return a && b;
    }

    public Location getPortByName(List<Location> ports, String portName) {
        for (Location location : ports) {
            if (location.getName().equals(portName)) {
                return location;
            }
        }
        return null;
    }

    public Map<String, List<Location>> mapPortsOfCountry(List<Location> ports) {
        Map<String, List<Location>> map = new HashMap<>();
        for (Location l : ports) {
            if (map.containsKey(l.getCountry())) {
                List<Location> list = map.get(l.getCountry());
                list.add(l);
                map.replace(l.getCountry(), list);
            } else {
                List<Location> list = new LinkedList<>();
                list.add(l);
                map.put(l.getCountry(), list);
            }
        }
        return map;
    }

    private Location getClosestPort(Position capitalPosition, List<Location> ports, List<Position> portsPosition) {
        double minDistance = 0;
        Location port = new Location();
        for (Location location : ports) {
            Position pos = getLocationPosition(portsPosition, location);
            assert pos != null;
            double tempDistance = DistanceBetweenTwoPointsCalculator.distance(capitalPosition.getLatitude(), pos.getLatitude(), capitalPosition.getLongitude(), pos.getLongitude());
            if (tempDistance > minDistance) {
                minDistance = tempDistance;
                port = location;
            }
        }
        return port;
    }

    public void resetMatrix() {
        for (Edge<Location, Borders> e : locationMap.edges()) {
            locationMap.removeEdge(e.getVOrig(), e.getVDest());
        }
        for (Location v : locationMap.vertices()) {
            locationMap.removeVertex(v);
        }
    }

    public MatrixGraph<Location, Borders> getLocationMap() {
        return locationMap;
    }


    public Location getLocationByCountry(List<Location> capitals, String country) {
        for (Location l : capitals) {
            if (l.getCountry().equals(country)) {
                return l;
            }
        }
        return null;
    }

    private Position getLocationPosition(List<Position> positions, Location location) {
        for (Position p : positions) {
            if (p.getPositionID() == location.getPositionID()) {
                return p;
            }
        }
        return null;
    }


    private double calculateDistance(Position position1, Position position2) {
        double lat1 = position1.getLatitude();
        double lon1 = position1.getLongitude();
        double lat2 = position2.getLatitude();
        double lon2 = position2.getLongitude();

        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344; //Kms
            return (dist);
        }
    }

}


