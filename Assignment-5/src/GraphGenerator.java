import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class generates the graph using the graph and node objects.
 * It uses the file path specified to create an array list of nodes.
 * The file format has 3 types, 'c' 'a' and 'p'.
 * 'c' specifies the components of the file, which is ignored by the graph generator.
 * 'p' specifies the number of nodes and edges in the file.
 * 'a' gives the current node, target node and distance values.
 *
 * @author Shadab Khan
 */
public class GraphGenerator {

    Graph graph = new Graph();
    ArrayList<Node> nodes = new ArrayList<>();

    public GraphGenerator() {}

    /**
     * Function to generate graph. Calls the 'readFile' function and then sets the nodes on in the graph
     * @param path String
     * @return Graph
     */
    public Graph generateGraph(String path, boolean k) {
        readFile(path, k);
        graph.setNodes(nodes);
        return graph;
    }

    /**
     * Function that reads the file and calls 'handleParts' function to create nodes.
     * @param path String
     */
    private void readFile(String path, boolean k) {
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                if(readLine.charAt(0) != 'c') {
                    String[] parts = parseLine(readLine, k);
                    handleParts(parts);
                }
            }
            b.close();
        } catch (IOException e) {
            System.out.println("Incorrect file path!!");
            e.printStackTrace();
        }
    }

    /**
     * internal function to parse each line of the file into an array of strings.
     * @param line String
     * @return String[]
     */
    private static String[] parseLine(String line, boolean k) {
        if(k)
            return line.split(" ");
        else
            return line.split("\t");
    }

    /**
     * Function that checks for format and accordingly creates nodes.
     * @param parts String[]
     */
    private void handleParts(String[] parts) {
        if(parts[0].equals("p")) {
            graph.setNodeCount(Integer.parseInt(parts[2])); //Number of nodes
            createNodes();
        }
        else if(parts[0].equals("a")) {
            Node sourceNode = findNode(nodes, parts[1]);
            Node destinationNode = findNode(nodes, parts[2]);
            if(sourceNode != null && destinationNode != null) {
                sourceNode.addAdjacent(destinationNode, Integer.parseInt(parts[3]));
            }
        }
    }

    /**
     * internal function to find the current node in consideration
     * @param nodes ArrayList<Node>
     * @param name String
     * @return Node
     */
    private Node findNode(ArrayList<Node> nodes, String name) {
        for(Node node : nodes) {
            if(node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    /**
     * internal function to create individual nodes.
     */
    private void createNodes() {
        for(int i = 0; i < graph.getNodeCount(); i++) {

            Node node  = new Node(new ArrayList<>(), new HashMap<>(), Integer.toString(i+1));
            if(i == 0) {
                node.setDistance(0);
            }
            nodes.add(node);
        }
    }
}