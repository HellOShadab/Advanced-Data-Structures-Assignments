package tree;

/**
 * Class to search a movie title in the tree.
 */
public class SearchMovieByTitle {

   public Movie searchByMovieTitle(LinkedBinarySearchTree.Node root, String key){
       if(root.getKey().equals(key)){
           return (Movie) root.getElement();
       }
       if(key.compareTo(root.getKey()) >= 1){           //(key.compareTo(root.getKey()) > 1){
           return searchByMovieTitle(root.getRight(), key);
       }
       return searchByMovieTitle(root.getLeft(), key);
   }

}
