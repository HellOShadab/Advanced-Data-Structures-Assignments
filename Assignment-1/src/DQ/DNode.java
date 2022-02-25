package DQ;

import Stocks.Stock;

/**
 * A node in a doubly linked list.
 *
 * @author ShadabKhan
 */
public class DNode {
    Stock stock;
    DNode prev, next;

    /**
     *Node Constructor takes in a stock value and initializes next and previous pointers to null.
     *
     * @param stock
     */
    public DNode(Stock stock)
    {
        this.stock = stock;
        this.next = null;
        this.prev = null;
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
     * Previous Node Getter Method
     *
     * @return next node
     */
    public DNode getPrev() {
        return prev;
    }

    /**
     * Previous Node Setter Method
     *
     * @param prev
     */
    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    /**
     * Next Node Getter Method
     *
     * @return next node
     */
    public DNode getNext() {
        return next;
    }

    /**
     * Next Node Setter Method
     *
     * @param next
     */
    public void setNext(DNode next) {
        this.next = next;
    }
};
