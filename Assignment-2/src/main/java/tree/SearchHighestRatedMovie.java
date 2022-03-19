package tree;

/**
 * Class to find the highest rated movie in a given tree.
 */
public class SearchHighestRatedMovie {
    float maxRating = Float.MIN_VALUE;
    private Movie highestRatedMovie = new Movie();

    public Movie getHighestRatedMovie(LinkedBinarySearchTree.Node node) {
        inorderSearch(node);
        return highestRatedMovie;
    }


    private void inorderSearch(LinkedBinarySearchTree.Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        inorderSearch(node.getLeft());

        /* then print the data of node */
        Movie movie = (Movie) node.getElement();
        if(movie.getAverageVotes() > maxRating){
            highestRatedMovie = movie;
            maxRating = movie.getAverageVotes();
        }
      //  System.out.print(movie.getTitle() + " ");

        /* now recur on right child */
        inorderSearch(node.getRight());
    }

}
