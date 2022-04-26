import java.util.*;
/**
 * This class is generic implementation of a node in the graph.
 *
 * shortestPath : stores the shortest path for each edge for a particular node in an ArrayList
 * adjacentNodes : stores the adjacent list in a HashMap
 * distance : stores distance to other nodes.
 * name : stores the name of the node.
 *
 * @author Shadab Khan
 */

public class Node {

    private ArrayList<Node> shortestPath;
    private HashMap<Node, Integer> adjacentNodes;
    private int distance;
    private String name;

    /**
     * Constructors to initialize variables for object creation.
     */
    public Node() {}

    public Node(ArrayList<Node> shortestPath, HashMap<Node, Integer> adjacentNodes, String name) {
        super();
        this.shortestPath = shortestPath;
        this.adjacentNodes = adjacentNodes;
        this.distance = 999999999;
        this.name = name;
    }

    /**
     * Accessor method for shortestPath
     * @return shortestPath ArrayList<Node>
     */
    public ArrayList<Node> getShortestPath() {
        return shortestPath;
    }

    /**
     * Mutator method for shortestPath
     * @param shortestPath ArrayList<Node>
     */
    public void setShortestPath(ArrayList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /**
     * Accessor method for adjacentNodes
     * @return adjacentNodes Hashmap<Node, Integer>
     */
    public HashMap<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     * Accessor method for distance
     * @return distance int
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Mutator method for distance
     * @param distance int
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Accessor method for name
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * Method to add new adjacent nodes.
     * @param destination Node
     * @param distance int
     */
    public void addAdjacent(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    /**
     * toString method for String representation of the Node object.
     * @return String
     */
    @Override
    public String toString() {
        return "(" + name + "," + distance + ")";
    }
}