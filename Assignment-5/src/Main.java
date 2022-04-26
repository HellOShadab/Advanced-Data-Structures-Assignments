/**
 * This is the Main class.
 *
 * @author Shadab Khan
 */
public class Main {

    public static void main(String[] args) {

        GraphGenerator generator = new GraphGenerator();    //Initialize Graph generators for each algorithms.
        GraphGenerator generator1 = new GraphGenerator();
        GraphGenerator generator2 = new GraphGenerator();

        Dijkstra dijkstra = new Dijkstra();     //Objects for each algorithm.
        BellmanFord bellmanFord = new BellmanFord();
        FloydWarshall floydWarshall = new FloydWarshall();

        String path = "src/resources/output_300_90000.gr";     //File path.
        boolean k = true; //bool to check if space or tab delimiter required. true->space || false->tab

        //----Dijkstra----//
        System.out.println("Starting Dijkstra...");
        Graph constantGraph = generator.generateGraph(path, k);
        double startTime = System.nanoTime();
        Graph dijkstraGraph = dijkstra.runDijkstra(constantGraph);
        double endTime = System.nanoTime();
        double duration = endTime - startTime;
        duration /= 1000000;
        System.out.println("The shortest path (starting from node 1) is : " + dijkstraGraph);
        System.out.println("\nRuntime of Dijkstra = " + duration + " milliseconds.");
        System.out.println("\n-------------------------------------------------\n");

        //----Bellman-Ford-----//
        constantGraph = generator1.generateGraph(path, k);
        startTime = System.nanoTime();
        Graph bellmanFordGraph = bellmanFord.runBellmanFord(constantGraph);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        duration /= 1000000;
        System.out.println("\nRuntime of Bellman-Ford = " + duration + " milliseconds.");
        System.out.println("\n-------------------------------------------------\n");

        //----Floyd-Warshall----//
        constantGraph = generator2.generateGraph(path, k);
        startTime = System.nanoTime();
        int[][] floydWarshallMatrix = floydWarshall.runFloydWarshall(constantGraph);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        duration /= 1000000;
        System.out.println("Runtime of Floyd-Warshall = " + duration + " milliseconds.");
        System.out.println("\n-------------------------------------------------\n");
        System.out.println("\nThank You :D");
    }
}