import java.util.List;

    public class Main {
        public static void main(String[] args) {
            DataParser dp = new DataParser();
            List<TVSeries> TVSeriesList = dp.getListSeries();
            final int ITERATIONS = 5; // runs the implementations five time for each treesize
            int size = TVSeriesList.size();
            LinkedBinarySearchTree tree = null;
            SearchHighestRatedSeries highestRatedTVSeries = new SearchHighestRatedSeries();
            SearchSeriesByTitle TVSeriesByTitle = new SearchSeriesByTitle();

            TVSeries TVSeries = new TVSeries();
            TVSeries topRatedTVSeries = new TVSeries();
            String TVSeriesTitle =  "Nine Men";

            // increment the number of tree nodes by 5000 on each iteration
            for (int n = 5000; n <= size; n += 5000) {
                long timing1 = 0, timing2 = 0, timing3 = 0;
                for (int it = 0; it < ITERATIONS; it++) {
                    tree = new LinkedBinarySearchTree();
                    long start = System.nanoTime();
                    for (int i = 0; i < n; i++) {
                        tree.insert(TVSeriesList.get(i), TVSeriesList.get(i).getTitle());
                    }
                    long end = System.nanoTime();
                    timing1 += end - start;
                }

                for (int it = 0; it < ITERATIONS; it++) {
                    long start = System.nanoTime();
                    TVSeries = TVSeriesByTitle.searchBySeriesTitle(tree.root, TVSeriesTitle);
                    long end = System.nanoTime();
                    timing2 += end - start;

                    start = System.nanoTime();
                    topRatedTVSeries =  highestRatedTVSeries.getHighestRatedSeries(tree.root);
                    end = System.nanoTime();
                    timing3 += end - start;
                }

                // time taken for implementation
                timing1 = timing1 / ITERATIONS;
                timing2 = timing2 / ITERATIONS;
                timing3 = timing3 / ITERATIONS;

                System.out.println("\n\nTree size : " + n);
                System.out.println("Operation : Insertion\nTime for operation : " + timing1 +" nanoseconds");
                System.out.println("Operation : Search Title\nTime for operation : " + timing2 + " nanoseconds");
                System.out.println("Operation : Search ImDb Top Score\nTime for operation : " + timing3 + " nanoseconds");
            }
            System.out.println("\nResult for Search Title : "+TVSeries.getTitle());
            System.out.println("Result for Highest Rated ImDb Score :\nTitle : " + topRatedTVSeries.getTitle() + "; Rating : " + topRatedTVSeries.getAverageVotes());
        }
    }
