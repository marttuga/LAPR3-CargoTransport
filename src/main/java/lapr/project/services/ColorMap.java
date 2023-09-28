package lapr.project.services;

import lapr.project.graph.Edge;
import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;

import java.util.*;

public class ColorMap {


    // Map<Vertex, Color>
    private HashMap<Location, Integer> vertexColors;

    // the current color
    private int color;


    public ColorMap() {

        this.vertexColors = new HashMap<>();

        this.color = -1;
    }


    /**
     * Run the Welsh-Powell algorithm of the graph {@code G}
     */
    public HashMap<Location, Integer> colorVertices(Graph<Location, Borders> graph) {


        // add all vertices to an list
        ArrayList<Location> vertices = graph.vertices();


        // Step 1 in Welsh-Powell:
        // Sort the vertices in order of descending valence
        vertices.sort((o1, o2) -> Integer.compare(graph.outDegree(o2), graph.outDegree(o1)));

        // Setp 2:
        // now we run the the coloring loop
        for (int i = 0; i < vertices.size(); i++) {

            Location vi = vertices.get(i);


            if (!vertexColors.containsKey(vi) && vi.getType().equalsIgnoreCase("capital")) { // if vi is not colored

                int c = nextColor();

                // color vi with c
                vertexColors.put(vi, c);
                System.out.println("Coloring " + vi + " with " + c);

                // go down the list of the remaining vertices
                for (int j = i + 1; j < vertices.size(); j++) {

                    Location vj = vertices.get(j);

                    if (!vertexColors.containsKey(vj)
                            &&
                            !inNeighbourhoodOf(graph, vj, c) && vj.getType().equalsIgnoreCase("capital")) {

                        // color vj with c
                        vertexColors.put(vj, c);
                        System.out.println("Coloring " + vj + " with " + c);

                    } // end if vj

                } // end for j

            } // end if vi

        } // end for  i

        return vertexColors;
    }

    /**
     * This method returns {@code true} of the {@code vertex} is in connected to some other
     * vertex in the graph {@code G} where the other vertex is colored with {@code color}
     *
     * @param vertex the vertex to check
     * @param color  the color of the neighbourhood vertices to be checked
     * @return {@code true} of one of the neighbourhood vertices is colored wiht {@code color}
     */
    public boolean inNeighbourhoodOf(Graph<Location, Borders> graph, Location vertex, int color) {


        for (Edge<Location, Borders> edge : graph.outgoingEdges(vertex)) {

            if (vertexColors.containsKey(edge.getVDest())
                    && vertexColors.get(edge.getVDest()) == color)
                return true;
        }

        return false;
    }

    /**
     * Pick the next available unsed color. In this implementation
     * simple increment the value of {@code color}
     *
     * @return
     */
    private int nextColor() {
        color++;

        return color;
    }


}