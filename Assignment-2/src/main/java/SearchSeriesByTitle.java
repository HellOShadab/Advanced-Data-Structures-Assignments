public class SearchSeriesByTitle {

   public TVSeries searchBySeriesTitle(LinkedBinarySearchTree.Node root, String key){
       if(root.getKey().equals(key)){
           return (TVSeries) root.getElement();
       }
       if(key.compareTo(root.getKey()) >= 1){           //(key.compareTo(root.getKey()) > 1){
           return searchBySeriesTitle(root.getRight(), key);
       }
       return searchBySeriesTitle(root.getLeft(), key);
   }

}
