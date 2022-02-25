package Stax;

import Stocks.Stock;


/**
 * A node in a singly linked list.
 *
 * @author ShadabKhan
 */
public class Node {

    Stock stock;
    Node next;

    /**
     *Node Constructor takes in a stock value and initializes next pointer to null.
     *
     * @param stock
     */
    public Node(Stock stock)
    {
        this.stock = stock;
        this.next = null;
    }

    /**
     *Stock Getter Method
     *
     * @return single stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Stock Setter Method
     *
     * @param stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     * Next Node Getter Method
     *
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Next Node Setter Method
     *
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
