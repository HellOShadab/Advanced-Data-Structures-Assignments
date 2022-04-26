import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * This class implements the Bellman-Ford's shortest path algorithm starting from the first node.
 * Uses the Map.Entry interface.
 *
 * @author Shadab Khan
 */
public class BellmanFord {

    public BellmanFord() {}

    /**
     * Bellman-Ford execution
     * @param graph Graph
     * @return Graph
     */
    public Graph runBellmanFord(Graph graph) {
        ArrayList<Node> nodes;
        nodes = graph.getNodes();

        for(int i = 0; i < nodes.size(); i++) {
            for (Node node : nodes) {
                for (Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {
                    Node adjacentNode = adjacencyPair.getKey(); //Initialize nodes and weights.
                    int edgeWeight = adjacencyPair.getValue();

                    if (adjacentNode.getDistance() > node.getDistance() + edgeWeight) { //Check for shortest route
                        adjacentNode.setDistance(node.getDistance() + edgeWeight);
                        ArrayList<Node> shortestPath = new ArrayList<>(node.getShortestPath()); //create new segment of shortest path and add current node
                        shortestPath.add(node);
                        adjacentNode.setShortestPath(shortestPath); //add the segment to whole shortest path in order of traversal
                    }
                }
            }

        }
        graph.setNodes(nodes);  //create graph with nodes in list
        return graph;
    }
}