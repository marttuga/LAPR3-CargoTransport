package lapr.project.services;

import lapr.project.controller.BuildMatrixGraphController;
import lapr.project.graph.Edge;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.model.Location.Position;
import lapr.project.model.Location.SeaDists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixCreateTest {
    GraphMatrixCreate graphMatrixCreate;

    @BeforeEach
    void setUp() {
        graphMatrixCreate = new GraphMatrixCreate();

    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void addConnectionBetweenNClosestPorts() {
        //int n, List<Location> ports, List<Position> portsPosition
        List<Location> ports = new LinkedList<>();
        List<Position> positions = new LinkedList<>();
        Location port1 = new Location("246265", "port", "Ambarli", 1, "Turkey", 0,1);
        Position p1 = new Position(1, 40.98333333, 28.53333333);
        Location port2 = new Location("216592", "capital", "Cristobal", 2, "Panama", 0,1);
        Position p2 = new Position(2, 9.35, -79.91666667);
        Location port3 = new Location("24795", "capital", "Izola", 3, "Slovenia", 0,1);
        Position p3 = new Position(3, 45.51666667, 13.68333333);

        ports.add(port1);
        ports.add(port2);
        ports.add(port3);
        positions.add(p1);
        positions.add(p2);
        positions.add(p3);
        graphMatrixCreate.addCapitalVertex(port1);
        graphMatrixCreate.addCapitalVertex(port2);
        graphMatrixCreate.addCapitalVertex(port3);
        graphMatrixCreate.addConnectionBetweenNClosestPorts(1, ports, positions);

        Borders b = new Borders("Turkey", "Slovenia");
        b.setWeight(1301.4991834176744);
        Edge<Location, Borders> a = new Edge<>(port2, port3,b);
        assertTrue(graphMatrixCreate.getLocationMap().edges().contains(a));
        Borders d = new Borders("Panama","Slovenia");
        d.setWeight(9544.791100908897);
        b.setWeight(1301.4991834176744);
        Edge<Location, Borders> c = new Edge<>(port3, port2, d);
        assertTrue(graphMatrixCreate.getLocationMap().edges().contains(c));


    }

    @Test
    //adiciona locations (cidades) e verifica o tamanho do grafo para confirmar que foi adicionado
    void addCapitalVertex() {
        Location cap1 = new Location("1", "capital", "Porto", 1, "Portugal", 0,1);
        graphMatrixCreate.addCapitalVertex(cap1);
        Location cap2 = new Location("2", "capital", "Lisboa", 2, "Portugal", 0,1);
        assertEquals(graphMatrixCreate.getLocationMap().vertices().size(), 1);
        graphMatrixCreate.addCapitalVertex(cap2);
        assertEquals(graphMatrixCreate.getLocationMap().vertices().size(), 2);
    }

    @Test
    //adiciona vertices(locations) e edges(borders) e verifica o tamanho dos edges criados ao chamar o metodo
    //addCapitalConnections: adiciona as conexoes entre as capitais
    void addCapitalConnections() {
        List<Location> capitals = new LinkedList<>();
        List<Borders> borders = new LinkedList<>();
        List<Position> positions = new LinkedList<>();
        Location cap1 = new Location("1", "capital", "Porto", 1, "Portugal", 0,1);
        Position p1 = new Position(1, 41.1579, 8.6291);
        Location cap2 = new Location("2", "capital", "Madrid", 2, "Spain", 0,1);
        Position p2 = new Position(2, 40.4168, 3.7038);
        Location cap3 = new Location("3", "capital", "Paris", 3, "France", 0,1);
        Position p3 = new Position(3, 48.8566, 2.3522);
        Borders border1 = new Borders("Portugal", "Spain");
        Borders border2 = new Borders("Spain", "France");
        capitals.add(cap1);
        capitals.add(cap2);
        capitals.add(cap3);
        borders.add(border1);
        borders.add(border2);
        positions.add(p1);
        positions.add(p2);
        positions.add(p3);
        graphMatrixCreate.addCapitalVertex(cap1);
        graphMatrixCreate.addCapitalVertex(cap2);
        graphMatrixCreate.addCapitalVertex(cap3);
        graphMatrixCreate.addCapitalConnections(capitals, borders, positions);
        System.out.println(graphMatrixCreate.getLocationMap().edges());
        assertEquals(graphMatrixCreate.getLocationMap().edges().size(), 4);

    }

    @Test
    //adiciona locations (portos) e verifica o tamanho do grafo para ver se foi adicionado
    void addPortVertex() {
        Location port1 = new Location("1", "port", "Porto", 1, "Portugal", 0,1);
        Location port2 = new Location("2", "port", "Lisboa", 2, "Portugal", 0,1);
        graphMatrixCreate.addPortVertex(port1);
        assertEquals(graphMatrixCreate.getLocationMap().vertices().size(), 1);
        graphMatrixCreate.addPortVertex(port2);
        assertEquals(graphMatrixCreate.getLocationMap().vertices().size(), 2);

    }

    @Test
    //adiciona as conexoes entre portos, 1 adiciona 2 portos e uma seadist e depois chama o método que cria
    //edge entre eles, o Assert vai confirmar se o edge foi criado
    void addPortConnections() {
        Location port1 = new Location("1", "port", "Porto", 1, "Portugal", 0,1);
        Location port2 = new Location("2", "port", "Lisboa", 2, "Portugal", 0,1);

        SeaDists seaDist1 = new SeaDists("Portugal", 1, "Porto", "Portugal", 2, "Lisboa", 0);
        graphMatrixCreate.addPortVertex(port1);
        graphMatrixCreate.addPortVertex(port2);
        List<Location> ports = new LinkedList<>();
        ports.add(port1);
        ports.add(port2);
        List<SeaDists> seaDists = new LinkedList<>();
        seaDists.add(seaDist1);
        graphMatrixCreate.addPortConnections(seaDists, ports);
        assertEquals(graphMatrixCreate.getLocationMap().edges().size(), 1);

        Location port3 = new Location("3", "port", "Madrid", 3, "Spain", 0,1);
        Location port4 = new Location("4", "port", "Barcelona", 4, "Spain", 0,1);
        graphMatrixCreate.addPortVertex(port3);
        graphMatrixCreate.addPortVertex(port4);
        SeaDists seaDist2 = new SeaDists("Spain", 3, "Madrid", "Spain", 4, "Barcelona", 0);
        ports.add(port3);
        ports.add(port4);
        seaDists.add(seaDist2);
        graphMatrixCreate.resetMatrix();
        graphMatrixCreate.addPortConnections(seaDists, ports);
        assertEquals(graphMatrixCreate.getLocationMap().edges().size(), 2);

    }

    @Test
    //retorna o porto pelo nome
    void getPortByName() {
        Location port1 = new Location("1", "port", "Porto", 1, "Portugal", 0,1);
        Location port2 = new Location("2", "port", "Lisboa", 2, "Portugal", 0,1);
        Location port3 = new Location("3", "port", "Madrid", 3, "Spain", 0,1);
        List<Location> ports = new LinkedList<>();
        ports.add(port1);
        ports.add(port2);
        ports.add(port3);
        assertEquals(port1, graphMatrixCreate.getPortByName(ports, "Porto"));
        assertEquals(port2, graphMatrixCreate.getPortByName(ports, "Lisboa"));
        assertEquals(port3, graphMatrixCreate.getPortByName(ports, "Madrid"));

    }

    @Test
    //retorna a location pelo país
    void getLocationByCountry() throws SQLException, IOException {
        BuildMatrixGraphController.getInstance().loadGraph();
        List<Location> list = BuildMatrixGraphController.getInstance().getCapitals();
        Location l = graphMatrixCreate.getLocationByCountry(list, "Monaco");
        assertEquals(l.getCountry(), "Monaco");

        Location l1 = graphMatrixCreate.getLocationByCountry(list, "Portugal");
        assertEquals(l1.getCountry(), "Portugal");
    }

    @Test
    //retorna um mapa com uma lista de portos agrupados por país
    void mapPortsOfCountry() {
        Location port1 = new Location("1", "port", "Porto", 1, "Portugal", 0,1);
        Location port2 = new Location("2", "port", "Lisboa", 2, "Portugal", 0,1);
        Location port3 = new Location("3", "port", "Madrid", 3, "Spain", 0,1);
        List<Location> ports = new LinkedList<>();
        List<Location> portugal = new LinkedList<>();
        portugal.add(port1);
        portugal.add(port2);
        List<Location> spain = new LinkedList<>();
        spain.add(port3);

        ports.add(port1);
        ports.add(port2);
        ports.add(port3);
        Map<String, List<Location>> expected = new HashMap<>();
        expected.put("Portugal", portugal);
        expected.put("Spain", spain);
        Map<String, List<Location>> actual = graphMatrixCreate.mapPortsOfCountry(ports);
        assertEquals(expected, actual);
    }

    @Test
    void getLocationMap() {
        assertEquals(BuildMatrixGraphController.getInstance().getLocationMap(), BuildMatrixGraphController.getInstance().getLocationMap());
    }
}