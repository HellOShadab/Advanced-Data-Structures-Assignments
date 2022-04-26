/**
 * This class implements the Dijkstra's shortest path algorithm starting from the first node till whole graph is traversed.
 *
 * @author Shadab Khan
 */
public class FloydWarshall {

    public FloydWarshall() {}

    /**
     * Floyd-Warshall Execution
     * @param graph Graph
     * @return int[][]
     */
    public int[][] runFloydWarshall(Graph graph){
        int[][] resultMatrix = new int[graph.getNodeCount()][graph.getNodeCount()];

        for(int i = 0; i < graph.getNodeCount(); i++) { //Initialize solution matrix.
            for(int j = 0; j < graph.getNodeCount(); j++) {
                Node sourceNode = graph.getNode(graph, (i+1));
                Node destNode = graph.getNode(graph, (j+1));

                if(i==j)
                    resultMatrix[i][j] = 0;
                else if(graph.isAdjacent(sourceNode, destNode))
                    resultMatrix[i][j] = sourceNode.getAdjacentNodes().get(destNode);
                else
                    resultMatrix[i][j] = 9999;
            }
        }

        for(int k = 0; k < graph.getNodeCount(); k++) {
            for(int i = 0; i < graph.getNodeCount(); i++) {
                for(int j = 0; j < graph.getNodeCount(); j++) {

                    if (resultMatrix[i][k] + resultMatrix[k][j] < resultMatrix[i][j])   //If vertex k is on the shortest path from i to j
                        resultMatrix[i][j] = resultMatrix[i][k] + resultMatrix[k][j];   //then update the value of dist[i][j]

                }
            }
        }
        return resultMatrix;
    }
}