package lapr.project.matrix;

import lapr.project.graph.Algorithms;
import lapr.project.graph.Graph;
import lapr.project.graph.matrix.MatrixGraph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAlgorithmsTest {

    final Graph<String, Integer> completeMap = new MatrixGraph<>(false);
    Graph<String, Integer> incompleteMap = new MatrixGraph<>(false);

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

    public MatrixAlgorithmsTest() {
    }

    @BeforeEach
    public void setUp() {

        testGraph.addVertex(v1);
        testGraph.addVertex(v2);
        testGraph.addVertex(v3);
        testGraph.addVertex(v4);
        testGraph.addVertex(v5);
        testGraph.addVertex(v6);
        testGraph.addVertex(v7);
        testGraph.addVertex(v8);

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

        completeMap.addVertex("Porto");
        completeMap.addVertex("Braga");
        completeMap.addVertex("Vila Real");
        completeMap.addVertex("Aveiro");
        completeMap.addVertex("Coimbra");
        completeMap.addVertex("Leiria");

        completeMap.addVertex("Viseu");
        completeMap.addVertex("Guarda");
        completeMap.addVertex("Castelo Branco");
        completeMap.addVertex("Lisboa");
        completeMap.addVertex("Faro");

        completeMap.addEdge("Porto", "Aveiro", 75);
        completeMap.addEdge("Porto", "Braga", 60);
        completeMap.addEdge("Porto", "Vila Real", 100);
        completeMap.addEdge("Viseu", "Guarda", 75);
        completeMap.addEdge("Guarda", "Castelo Branco", 100);
        completeMap.addEdge("Aveiro", "Coimbra", 60);
        completeMap.addEdge("Coimbra", "Lisboa", 200);
        completeMap.addEdge("Coimbra", "Leiria", 80);
        completeMap.addEdge("Aveiro", "Leiria", 120);
        completeMap.addEdge("Leiria", "Lisboa", 150);

        incompleteMap = completeMap.clone();

        completeMap.addEdge("Aveiro", "Viseu", 85);
        completeMap.addEdge("Leiria", "Castelo Branco", 170);
        completeMap.addEdge("Lisboa", "Faro", 280);
    }

    private void checkContentEquals(List<String> l1, List<String> l2, String msg) {
        Collections.sort(l1);
        Collections.sort(l2);
        assertEquals(l1, l2, msg);
    }

    /**
     * Test of BreadthFirstSearch method, of class Algorithms.
     */
    @Test
    public void testBreadthFirstSearch() {
        System.out.println("Test BreadthFirstSearch");

        Assertions.assertNull(Algorithms.BreadthFirstSearch(completeMap, "LX"), "Should be null if vertex does not exist");

        LinkedList<String> path = Algorithms.BreadthFirstSearch(incompleteMap, "Faro");

        assertEquals(1, path.size(), "Should be just one");

        assertEquals("Faro", path.peekFirst());

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Porto");
        assertEquals(7, path.size(), "Should give seven vertices");

        assertEquals("Porto", path.removeFirst(), "BreathFirst Porto");

        LinkedList<String> expected = new LinkedList<>(Arrays.asList("Aveiro", "Braga", "Vila Real"));
        checkContentEquals(expected, path.subList(0, 3), "BreathFirst Porto");

        expected = new LinkedList<>(Arrays.asList("Coimbra", "Leiria"));
        checkContentEquals(expected, path.subList(3, 5), "BreathFirst Porto");

        expected = new LinkedList<>(Arrays.asList("Lisboa"));
        checkContentEquals(expected, path.subList(5, 6), "BreathFirst Porto");

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Viseu");
        expected = new LinkedList<>(Arrays.asList("Viseu", "Guarda", "Castelo Branco"));
        assertEquals(expected, path, "BreathFirst Viseu");
    }

    /**
     * Test of DepthFirstSearch method, of class Algorithms.
     */
    @Test
    public void testDepthFirstSearch() {
        System.out.println("Test of DepthFirstSearch");

        assertNull(Algorithms.DepthFirstSearch(completeMap, "LX"), "Should be null if vertex does not exist");

        LinkedList<String> path = Algorithms.DepthFirstSearch(incompleteMap, "Faro");
        assertEquals(1, path.size(), "Should be just one");

        assertEquals("Faro", path.peekFirst());

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Porto");
        assertEquals(7, path.size(), "Should give seven vertices");

        assertEquals("Porto", path.removeFirst(), "DepthFirst Porto");
        assertTrue(new LinkedList<>(Arrays.asList("Aveiro", "Braga", "Vila Real")).contains(path.removeFirst()), "DepthFirst Porto");

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Viseu");
        List<String> expected = new LinkedList<>(Arrays.asList("Viseu", "Guarda", "Castelo Branco"));
        assertEquals(expected, path, "DepthFirst Viseu");
    }

    /**
     * Test of shortestPath method, of class Algorithms.
     */
    @Test
    public void testShortestPath() {
        System.out.println("Test of shortest path");

        LinkedList<String> shortPath = new LinkedList<>();

        Integer lenPath = Algorithms.shortestPath(completeMap, "Porto", "LX", Integer::compare, Integer::sum, 0, shortPath);
        assertNull(lenPath, "Length path should be null if vertex does not exist");
        assertEquals(0, shortPath.size(), "Shortest Path does not exist");

        lenPath = Algorithms.shortestPath(incompleteMap, "Porto", "Faro", Integer::compare, Integer::sum, 0, shortPath);
        assertNull(lenPath, "Length path should be null if vertex does not exist");
        assertEquals(0, shortPath.size(), "Shortest Path does not exist");

        lenPath = Algorithms.shortestPath(completeMap, "Porto", "Porto", Integer::compare, Integer::sum, 0, shortPath);
        assertEquals(0, lenPath, "Length path should be 0 if vertices are the same");
        assertEquals(Arrays.asList("Porto"), shortPath, "Shortest Path only contains Porto");

        lenPath = Algorithms.shortestPath(incompleteMap, "Porto", "Lisboa", Integer::compare, Integer::sum, 0, shortPath);
        assertEquals(335, lenPath, "Length path should be 0 if vertices are the same");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Coimbra", "Lisboa"), shortPath, "Shortest Path Porto - Lisboa");

        lenPath = Algorithms.shortestPath(incompleteMap, "Braga", "Leiria", Integer::compare, Integer::sum, 0, shortPath);
        assertEquals(255, lenPath, "Length path should be 0 if vertices are the same");
        assertEquals(Arrays.asList("Braga", "Porto", "Aveiro", "Leiria"), shortPath, "Shortest Path Braga - Leiria");

        lenPath = Algorithms.shortestPath(completeMap, "Porto", "Castelo Branco", Integer::compare, Integer::sum, 0, shortPath);
        assertEquals(335, lenPath, "Length path should be 0 if vertices are the same");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Viseu", "Guarda", "Castelo Branco"), shortPath, "Shortest Path Porto - Castelo Branco");

        //Changing Edge: Aveiro-Viseu with Edge: Leiria-C.Branco
        //should change shortest path between Porto and Castelo Branco

        completeMap.removeEdge("Aveiro", "Viseu");
        completeMap.addEdge("Leiria", "Castelo Branco", 170);

        lenPath = Algorithms.shortestPath(completeMap, "Porto", "Castelo Branco", Integer::compare, Integer::sum, 0, shortPath);
        assertEquals(365, lenPath, "Length path should be 0 if vertices are the same");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Leiria", "Castelo Branco"), shortPath, "Shortest Path Porto - Castelo Branco");
    }

    /**
     * Test of shortestPaths method, of class Algorithms.
     */
    @Test
    public void testShortestPaths() {
        System.out.println("Test of shortest path");

        ArrayList<LinkedList<String>> paths = new ArrayList<>();
        ArrayList<Integer> dists = new ArrayList<>();

        Algorithms.shortestPaths(completeMap, "Porto", Integer::compare, Integer::sum, 0, paths, dists);

        assertEquals(paths.size(), dists.size(), "There should be as many paths as sizes");
        assertEquals(completeMap.numVertices(), paths.size(), "There should be a path to every vertex");
        assertEquals(Arrays.asList("Porto"), paths.get(completeMap.key("Porto")), "Number of nodes should be 1 if source and vertex are the same");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Coimbra", "Lisboa"), paths.get(completeMap.key("Lisboa")), "Path to Lisbon");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Viseu", "Guarda", "Castelo Branco"), paths.get(completeMap.key("Castelo Branco")), "Path to Castelo Branco");
        assertEquals(335, dists.get(completeMap.key("Castelo Branco")), "Path between Porto and Castelo Branco should be 335 Km");

        //Changing Edge: Aveiro-Viseu with Edge: Leiria-C.Branco
        //should change shortest path between Porto and Castelo Branco
        completeMap.removeEdge("Aveiro", "Viseu");
        completeMap.addEdge("Leiria", "Castelo Branco", 170);
        Algorithms.shortestPaths(completeMap, "Porto", Integer::compare, Integer::sum, 0, paths, dists);
        assertEquals(365, dists.get(completeMap.key("Castelo Branco")), "Path between Porto and Castelo Branco should now be 365 Km");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Leiria", "Castelo Branco"), paths.get(completeMap.key("Castelo Branco")), "Path to Castelo Branco");

        Algorithms.shortestPaths(incompleteMap, "Porto", Integer::compare, Integer::sum, 0, paths, dists);
        assertNull(dists.get(completeMap.key("Faro")), "Length path should be null if there is no path");
        assertEquals(335, dists.get(completeMap.key("Lisboa")), "Path between Porto and Lisboa should be 335 Km");
        assertEquals(Arrays.asList("Porto", "Aveiro", "Coimbra", "Lisboa"), paths.get(completeMap.key("Lisboa")), "Path to Lisboa");

        Algorithms.shortestPaths(incompleteMap, "Braga", Integer::compare, Integer::sum, 0, paths, dists);
        assertEquals(255, dists.get(completeMap.key("Leiria")), "Path between Braga and Leiria should be 255 Km");
        assertEquals(Arrays.asList("Braga", "Porto", "Aveiro", "Leiria"), paths.get(completeMap.key("Leiria")), "Path to Leiria");
    }

    /**
     * Test minimum distance graph using Floyd-Warshall.
     */
    @Test
    public void testminDistGraph() {
        assertNotNull(Algorithms.minDistGraph(completeMap, Integer::compare, Integer::sum));
    }

    @Test
    void findCircuit() {
        LinkedList<Location> path = new LinkedList<>();
        path.add(v1);
        path.add(v2);
        path.add(v3);
        path.add(v6);
        assertNull(Algorithms.findCircuit(testGraph, path), "Should be null because the first element and the last will never be an edge");
        LinkedList<Location> path2 = new LinkedList<>();
        path2.add(vUm);
        path2.add(v1);
        path2.add(v2);
        path2.add(v3);
        path2.add(v6);
        path2.add(v7);
        path2.add(vOito);
        assertNotNull(Algorithms.findCircuit(testGraph, path2), "Should not be null because first element and last element form an edge");
    }

    @Test
    void nearestLocationSearch() {
        LinkedList<Location> path1 = new LinkedList<>();
        //path1.add(v1);
        //path1.add(v2);
        //path1.add(v3);
        boolean[] visited = new boolean[testGraph.numVertices()];
        Algorithms.nearestLocationSearch(testGraph, v1, visited, path1);
        assertEquals(vUm, path1.get(1),"Local Um mais próximo de Lisboa");
        assertEquals(vDois, path1.get(2),"Local Dois mais próximo de Lisboa");
        assertEquals(v2, path1.get(3),"Local Tres mais próximo de Lisboa");

    }

    @Test
    void findBiggestCircuit() {
        ArrayList<LinkedList<Location>> paths = new ArrayList<>();
        ArrayList<LinkedList<Location>> result = new ArrayList<>();
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
        path3.add(v7);
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        result.add(path3);

        assertEquals(result, Algorithms.findBiggestCircuit(paths), "Should return the biggest List");
    }
}