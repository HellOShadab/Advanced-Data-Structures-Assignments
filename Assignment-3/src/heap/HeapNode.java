package heap;

/**
 * An immutable class to represent a node in the heap data structure.
 * Each object is used to create a node in the tree.
 * Each object contains information of a single Covid object, in a String array.
 * A key is set that stores the NewCases parameter of the Covid object.
 * The following are the properties :-
 *
 * info : String Array that stores County, Province names and date of Covid obj.
 * key : Stores newCases property of Covid obj, that is used to compare each node in the Heap.
 *
 * @author Shadab Khan
 */
public class HeapNode {
    private String[] info;
    private int key;

    /**
     * Constructor to construct a HeapNode object.
     *
     * @param node
     */
    public HeapNode(Covid node)
    {
        info = new String[3];
        info[0] = node.getCountyName();
        info[1] = node.getProvinceName();
        info[2] = node.getDate();
        this.key = node.getNewCases();
    }

    /**
     * Accessor method for Info String Array
     * @return info
     */
    public String[] getInfo() {
        return info;
    }

    /**
     * Accessor method for Key Integer
     * @return key
     */
    public int getKey() {
        return key;
    }

    /**
     * Produces a string representation of the HeapNode Object.
     * @return textual representation of HeapNode Object.
     */
    @Override
    public String toString() {
        return "Covid Node info := \n[County Name : " + info[0] + ", Province Name : " + info[1] + ", Date : " + info[2] +
                "]\n Number of new cases =" + key;
    }
}
