package Stax;

import Stocks.Stock;

/**
 * A Stack class that is made using Nodes to create a linked list.
 *
 * @author ShadabKhan
 */
public class StackLL {
    Node top;
    int size;

    /**
     * Constructor to set stack top and size to null and 0 respectively.
     */
    public StackLL()
    {
        this.top = null;
        this.size = 0;
    }

    /**
     * Checks if stack is empty.
     */
    public boolean isEmpty()
    {
        return top == null;
    }

    /**
     * Getter method for Node at top.
     *
     * @return top
     */
    public Node getTop() {
        return top;
    }

    /**
     * Setter method for Node at top.
     *
     * @param top
     */
    public void setTop(Node top) {
        this.top = top;
    }
    public int getSize()
    {
        return size;
    }

    /**
     * Push method for Stack. Creates a Node from a Stock object
     * and then pushes it into stack. Performs change to the top accordingly.
     *
     * @param stock
     */
    public void push(Stock stock)
    {
        Node n = new Node(stock);
        if (getTop() != null) {
            top.setNext(n);
        }
        setTop(n);
        size++;
    }

    /**
     * Pop method for Stack. Pops the top element in the stack.
     * Does changes to top accordingly.
     *
     * @return Stock
     */
    public Stock pop()
    {
        if(getTop() == null) {
            System.out.println("No elements in stack");
            return null;
        }
        Node n = new Node(this.top.getStock());
        this.setTop(top.getNext());
        size--;
        return n.getStock();
    }

    /**
     * Method to Peak the current element at the top of the stack.
     *
     * @return Stock
     */
    public Stock Peak()
    {
        if(getTop() == null)
        {
            System.out.println("Stack is empty!");
            return null;
        }
        return top.getStock();
    }
}
