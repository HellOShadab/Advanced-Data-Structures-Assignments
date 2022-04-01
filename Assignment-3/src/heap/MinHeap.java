package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * This class uses the HeapNode object to create a list and further use this list
 * to create a Heap Data Structure.
 * The following are the properties:-
 *
 * Nodes : A list of HeapNode
 * Size : An integer to store size of heap
 *
 * @author Shadab Khan
 */

public class MinHeap {
    private List<HeapNode> nodes;
    private int size;

    /**
     * Constructor to create MinHeap object.
     * Sets size to 0 and initialises the List.
     */
    public MinHeap()
    {
        nodes = new ArrayList<HeapNode>();
        this.size = 0;
    }

    /**
     * Function to insert new HeapNode into the heap.
     * @param node
     */
    public void insert(HeapNode node)
    {
            nodes.add(size, node); //add node to current max position

        int temp =size, parent = (size - 1) / 2; //calculate parent

        while (nodes.get(temp).getKey() < nodes.get(parent).getKey()) {
            //swap nodes if minheap condition not satisfied
            HeapNode tempValue = nodes.get(parent);
            nodes.set(parent, nodes.get(temp));
            nodes.set(temp, tempValue);

            temp = parent;

            parent = (parent - 1) / 2;
        }
        this.size++; //increase size of heap
    }

    /**
     * Function to create shifts in the heap for heapifying and maintaining Heap property.
     * @param position
     */
    public void shift(int position) {
        int left = 2 * position + 1, right = 2 * position + 2; //Calculate position of children

        if(left < size() && right < size()) { //Prevent going beyond max size
            if (nodes.get(left) != null && (nodes.get(right) == null || nodes.get(left).getKey() <= nodes.get(right).getKey())) {
                HeapNode tempValue = nodes.get(left);
                nodes.set(left, nodes.get(position));
                nodes.set(position, tempValue);
                shift(left); //swap and shift left if left <= right
            } else if (nodes.get(right) != null && (nodes.get(left) == null || nodes.get(left).getKey() > nodes.get(right).getKey())) {
                HeapNode tempValue = nodes.get(right);
                nodes.set(right, nodes.get(position));
                nodes.set(position, tempValue);
                shift(right); //swap and shift right if left > right
            }
        }
    }

    /**
     * Accessor function for size.
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Function to peak minimum value in heap (root node since MinHeap).
     * @return rootNode
     */
    public HeapNode min() {
        return nodes.get(0);
    }

    /**
     * Function to remove root node and heapify heap again.
     * @return rootNode
     */
    public HeapNode removeMin() {
        HeapNode result = nodes.get(0);

        nodes.set(0, nodes.get(size - 1));
        nodes.set(size - 1, null);
        size--;

        shift(0);

        return result;
    }
}
