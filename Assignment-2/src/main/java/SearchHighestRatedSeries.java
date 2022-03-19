public class SearchHighestRatedSeries {
    float maxRating = Float.MIN_VALUE;
    private TVSeries highestRatedSeries = new TVSeries();

    public TVSeries getHighestRatedSeries(LinkedBinarySearchTree.Node node) {
        inorderSearch(node);
        return highestRatedSeries;
    }


    private void inorderSearch(LinkedBinarySearchTree.Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        inorderSearch(node.getLeft());

        /* then compare the data of node */
        TVSeries series = (TVSeries) node.getElement();
        if(series.getAverageVotes() > maxRating){
            highestRatedSeries = series;
            maxRating = series.getAverageVotes();
        }

        /* now recur on right child */
        inorderSearch(node.getRight());
    }

}
