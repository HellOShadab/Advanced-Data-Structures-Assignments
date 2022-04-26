import java.util.*;

/**
 * This class uses the Comparator interface to overwrite the "compare()" method
 * for getting the higher distance amongst 2 Node inputs (Descending order).
 *
 * @author Shadab Khan
 */
public class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2) {
        if (n1.getDistance() > n2.getDistance())
            return 1;
        else if (n1.getDistance() < n2.getDistance())
            return -1;
        return 0;
    }
} 