package lapr.project.services;

import lapr.project.graph.Graph;
import lapr.project.graph.matrix.MatrixGraph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HeuristicCircuitTest {
    HeuristicCircuit heuristicCircuit;
    final Graph<Location, Borders> testGraph = new MatrixGraph<>(false);
    Location v1 = new Location("PT", "capital", "Lisbon", 4, "Portugal", 0, 1);
    Location v2 = new Location("ES", "capital", "Madrid", 7, "Spain", 0, 1);
    Location v3 = new Location("FR", "capital", "Paris", 27, "France", 0, 1);
    Location v4 = new Location("BE", "capital", "Brussels", 31, "Belgium", 0, 1);
    Location v5 = new Location("LU", "capital", "Luxembourg", 28, "Luxembourg", 0, 1);
    Location v6 = new Location("DE", "capital", "Berlin", 35, "Germany", 0, 1);
    Location v7 = new Location("CH", "capital", "Bern", 21, "Switzerland", 0, 1);
    Location v8 = new Location("IT", "capital", "Rome", 10, "Italy", 0, 1);
    Location vUm = new Location("20301", "port", "Matarani", 533922, "Portugal", 4, 19);
    Location vDois = new Location("22226", "port", "Kaliningrad", 274074, "Spain", 7, 63);
    Location vTres = new Location("10860", "port", "Rio Grande", 965762, "France", 27, 28);
    Location vSete = new Location("13012", "port", "Sargaço", 591409, "Switzerland", 21, 90);
    Location vOito = new Location("28082", "port", "Venice", 510955, "Italy", 10, 85);
    Location v6Tov1 = new Location("1", "capital", "Connection", 1, "Germany", 0, 2);

    @BeforeEach
    void setUp() throws SQLException, IOException {
        heuristicCircuit = new HeuristicCircuit();

        testGraph.addVertex(v1);
        testGraph.addVertex(v2);
        testGraph.addVertex(v3);
        testGraph.addVertex(v4);
        testGraph.addVertex(v5);
        testGraph.addVertex(v6);
        testGraph.addVertex(v7);
        testGraph.addVertex(v8);
        testGraph.addVertex(vUm);
        testGraph.addVertex(vDois);
        testGraph.addVertex(vTres);
        testGraph.addVertex(vSete);
        testGraph.addVertex(vOito);
        testGraph.addVertex(v6Tov1);

        Borders b1 = new Borders(v1.getName(), v2.getName());
        b1.setWeight(503.11);
        testGraph.addEdge(v1, v2, b1);

        Borders bUm = new Borders(v1.getName(), vUm.getName());
        bUm.setWeight(50.8);
        testGraph.addEdge(v1, vUm, bUm);

        Borders b2 = new Borders(v2.getName(), v3.getName());
        b2.setWeight(1052.76);
        testGraph.addEdge(v2, v3, b2);

        Borders bDois = new Borders(v2.getName(), vDois.getName());
        bDois.setWeight(50.8);
        testGraph.addEdge(v2, vDois, bDois);

        Borders b3 = new Borders(v3.getName(), v4.getName());
        b3.setWeight(263.72);
        testGraph.addEdge(v3, v4, b3);

        Borders bTres = new Borders(v3.getName(), vTres.getName());
        bTres.setWeight(50.8);
        testGraph.addEdge(v3, vTres, bTres);


        Borders b4 = new Borders(v3.getName(), v5.getName());
        b4.setWeight(286.83);
        testGraph.addEdge(v3, v5, b4);

        Borders b5 = new Borders(v3.getName(), v6.getName());
        b5.setWeight(878.08);
        testGraph.addEdge(v3, v6, b5);

        Borders b6 = new Borders(v3.getName(), v7.getName());
        b6.setWeight(435.11);
        testGraph.addEdge(v3, v7, b6);

        Borders bSete = new Borders(v7.getName(), vSete.getName());
        bSete.setWeight(50.8);
        testGraph.addEdge(v7, vSete, bSete);

        Borders b7 = new Borders(v3.getName(), v8.getName());
        b7.setWeight(1106.27);
        testGraph.addEdge(v3, v8, b7);

        Borders bOito = new Borders(v8.getName(), vOito.getName());
        bOito.setWeight(50.8);
        testGraph.addEdge(v8, vOito, bOito);

        Borders b8 = new Borders(v4.getName(), v5.getName());
        b8.setWeight(186.53);
        testGraph.addEdge(v4, v5, b8);

        Borders b9 = new Borders(v4.getName(), v6.getName());
        b9.setWeight(651.08);
        testGraph.addEdge(v4, v6, b9);

        Borders b10 = new Borders(v6.getName(), v5.getName());
        b10.setWeight(602.77);
        testGraph.addEdge(v6, v5, b10);

        Borders b11 = new Borders(v6.getName(), v7.getName());
        b11.setWeight(753.11);
        testGraph.addEdge(v6, v7, b11);


        Borders bUmTobDois = new Borders(vUm.getName(), vDois.getName());
        bUmTobDois.setWeight(500);
        testGraph.addEdge(vUm, vDois, bUmTobDois);

        Borders bDoisToTres = new Borders(vDois.getName(), vTres.getName());
        bDoisToTres.setWeight(1050);
        testGraph.addEdge(vDois, vTres, bDoisToTres);

        Borders bTresToSete = new Borders(vTres.getName(), vSete.getName());
        bTresToSete.setWeight(430);
        testGraph.addEdge(vTres, vSete, bTresToSete);

        Borders bSeteToOito = new Borders(vSete.getName(), vOito.getName());
        bSeteToOito.setWeight(900);
        testGraph.addEdge(vSete, vOito, bSeteToOito);

        Borders bOitoToUm = new Borders(vOito.getName(), vUm.getName());
        bOitoToUm.setWeight(1000);
        testGraph.addEdge(vOito, vUm, bOitoToUm);

        Borders seisToUm =new Borders(v6Tov1.getName(), v1.getName() );
        seisToUm.setWeight(10);
        testGraph.addEdge(v6Tov1,v1,seisToUm);

        Borders seisTo6 =new Borders(v6Tov1.getName(), v6.getName() );
        seisTo6.setWeight(10);
        testGraph.addEdge(v6Tov1,v6,seisTo6);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void heuristicCircuit() {
        List<Location> list = heuristicCircuit.heuristicCircuit(testGraph);
        assertEquals(list.get(0), list.get(list.size() - 1), "First point and Last Point should be the same");
        Map<Location, Integer> map = new HashMap<>();
        for (Location l : list) {
            if (!l.equals(list.get(0)) && !l.equals(list.get(list.size() - 1))) {
                if (!map.containsKey(l)) {
                    map.put(l, 1);
                } else {
                    map.replace(l, map.get(l) + 1);
                }
            }
        }
        for (Map.Entry<Location, Integer> m : map.entrySet()) {
            assertEquals(1, m.getValue(), "Each Location can only appear once");
        }


    }

    @Test
    void getLessWeightBiggestCycle() {
        ArrayList<LinkedList<Location>> paths = new ArrayList<>();
        LinkedList<Location> path1 = new LinkedList<>();
        path1.add(v1);
        path1.add(v2);
        path1.add(v3);
        LinkedList<Location> path2 = new LinkedList<>();
        path2.add(v1);
        path2.add(v2);
        path2.add(v3);
        path2.add(v4);
        LinkedList<Location> path3 = new LinkedList<>();
        path3.add(v1);
        path3.add(v2);
        path3.add(v3);
        path3.add(v6);
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);

        assertEquals(path1, heuristicCircuit.getLessWeightBiggestCycle(testGraph, paths), "Path with Less Weight is Path1");
    }

    @Test
    void getPathIndex() {
        ArrayList<LinkedList<Location>> paths = new ArrayList<>();
        LinkedList<Location> path1 = new LinkedList<>();
        path1.add(v1);
        path1.add(v2);
        path1.add(v3);
        LinkedList<Location> path2 = new LinkedList<>();
        path2.add(v1);
        path2.add(v2);
        path2.add(v3);
        path2.add(v4);
        LinkedList<Location> path3 = new LinkedList<>();
        path3.add(v1);
        path3.add(v2);
        path3.add(v3);
        path3.add(v6);
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        assertEquals(0, heuristicCircuit.getPathIndex(paths, testGraph), "Path with Less Weight is Path1 with index 0");
    }


    @Test
    void nearestLocation() {
        assertTrue(heuristicCircuit.nearestLocation(testGraph, v2).contains(v1));
        assertTrue(heuristicCircuit.nearestLocation(testGraph, v2).contains(vUm));
        assertTrue(heuristicCircuit.nearestLocation(testGraph, v2).contains(vDois));

    }

    @Test
    void pathWeight() {
        LinkedList<Location> path = new LinkedList<>();
        path.add(v1);
        path.add(v2);
        path.add(v3);
        assertEquals(1555.87, heuristicCircuit.pathWeight(testGraph, path));
        path.add(v4);
        path.add(v5);
        assertEquals(2006.12, heuristicCircuit.pathWeight(testGraph, path));


    }
}