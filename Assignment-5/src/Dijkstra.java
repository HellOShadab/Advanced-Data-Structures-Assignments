import java.util.*;
import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * This class implements the Dijkstra's shortest path algorithm starting from the first node till whole graph is traversed.
 * Uses Map.Entry interface.
 *
 * @author Shadab Khan
 */
public class Dijkstra {
    public Dijkstra() {}

    /**
     * Dijkstra execution.
     * @param graph Graph
     * @return Graph
     */
    public Graph runDijkstra(Graph graph) {
        ArrayList<Node> visitedNodes = new ArrayList<>();   //Create lists for visited and unvisited nodes.
        PriorityQueue<Node> unvisitedNodes = new
                PriorityQueue<>(5, new NodeComparator());
        unvisitedNodes.addAll(graph.getNodes());

        while(unvisitedNodes.size() != 0) { //Till all nodes are visited.
            Node node = unvisitedNodes.remove();

            for (Entry < Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if(adjacentNode.getDistance() > node.getDistance() + edgeWeight) {  //Check for shortest route
                    adjacentNode.setDistance(node.getDistance() + edgeWeight);
                    ArrayList<Node> shortestPath = new ArrayList<>(node.getShortestPath());
                    shortestPath.add(node);
                    adjacentNode.setShortestPath(shortestPath);
                }
            }
            visitedNodes.add(node); //add the segment to whole shortest path in order of traversal
        }
        graph.setNodes(visitedNodes);
        return graph;
    }
}