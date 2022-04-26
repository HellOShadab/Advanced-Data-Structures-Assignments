import java.util.*;

/**
 * This class is a template for the graph data structure.
 * It uses the Node object to create nodes in the graph and then makes the adjacency list.
 *
 * nodes : ArrayList of Nodes in the graph.
 * nodeCount : an integer to store total number of nodes in the graph.
 *
 * @author Shadab Khan
 */
public class Graph {

    private ArrayList<Node> nodes;
    private int nodeCount;

    public Graph() {}

    /**
     * Accessor method for nodes.
     * @return nodes ArrayList<Node>
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * Mutator method for nodes.
     * @param nodes ArrayList<Node>
     */
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Accessor method for nodeCount.
     * @return nodeCount int
     */
    public int getNodeCount() {
        return nodeCount;
    }

    /**
     * Mutator method for nodeCount.
     * @param nodeCount int
     */
    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    /**
     * Method to return particular node pointed by the 'num' parameter
     * for Floyd-Warshall algorithm.
     * @param g Graph
     * @param num int
     * @return Node
     */
    public Node getNode(Graph g, int num) {
        for(Node node : g.getNodes()) {
            if(node.getName().equals(Integer.toString(num))) {
                return node;
            }
        }
        return null;
    }

    /**
     * Method to check if 2 nodes are adjacent.
     * @param source Node
     * @param dest Node
     * @return boolean
     */
    public boolean isAdjacent(Node source, Node dest) {
        return source.getAdjacentNodes().containsKey(dest);
    }

    /**
     * toString method for String representation of the graph object.
     * @return String
     */
    @Override
    public String toString() {
        return nodes.toString();
    }
}