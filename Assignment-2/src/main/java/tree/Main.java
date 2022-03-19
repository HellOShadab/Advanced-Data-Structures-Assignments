package tree;

    import java.util.List;
    import java.util.Scanner;

/**
 * Main Class
 */
public class Main {
        public static void main(String[] args) {
            DataParser dp = new DataParser();
            List<Movie> movieList = dp.getListMovies();
            final int ITERATIONS = 5; // runs the implementations five time for each treesize
            int size = movieList.size();
            LinkedBinarySearchTree tree = null;
            SearchHighestRatedMovie highestRatedMovie = new SearchHighestRatedMovie();
            SearchMovieByTitle movieByTitle = new SearchMovieByTitle();
            Scanner sc = new Scanner(System.in);

            Movie movie = new Movie();
            Movie topRatedMovie = new Movie();
            //System.out.println("Enter Movie title to search : ");
            String movieTitle =  "Nine Men";

            // increment the number of tree nodes by 5000 on each iteration
            for (int n = 5000; n <= size; n += 5000) {
                long timing1 = 0, timing2 = 0, timing3 = 0;
                for (int it = 0; it < ITERATIONS; it++) {
                    tree = new LinkedBinarySearchTree();
                    long start = System.nanoTime();
                    for (int i = 0; i < n; i++) {
                        tree.insert(movieList.get(i), movieList.get(i).getTitle());
                    }
                    long end = System.nanoTime();
                    timing1 += end - start;
                }

                for (int it = 0; it < ITERATIONS; it++) {
                    long start = System.nanoTime();
                    movie = movieByTitle.searchByMovieTitle(tree.root, movieTitle);
                    long end = System.nanoTime();
                    timing2 += end - start;

                    start = System.nanoTime();
                    topRatedMovie =  highestRatedMovie.getHighestRatedMovie(tree.root);
                    end = System.nanoTime();
                    timing3 += end - start;
                }

                // time taken for implementation
                timing1 = timing1 / ITERATIONS;
                timing2 = timing2 / ITERATIONS;
                timing3 = timing3 / ITERATIONS;

                System.out.println("\nTree construction of size : " + n );
                System.out.println("Operation : Insertion --------------------- Time Taken : " + timing1);
                System.out.println("Operation : Search by title --------------- Time Taken : " + timing2);
                System.out.println("Operation : Highest Rated Movie ----------- Time Taken : " + timing3);
            }
             System.out.println("\n\nOperation : Search --------------- Result : " + movie.getTitle());
             System.out.println("Operation : Highest Rating ------- Result : " + topRatedMovie.getTitle()+", with rating : "+topRatedMovie.getAverageVotes());
        }
    }
