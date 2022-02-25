package DQ;

import Stocks.Stock;

public class DNode {
    Stock stock;
    DNode prev, next;

    public DNode(Stock stock)
    {
        this.stock = stock;
        this.next = null;
        this.prev = null;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
};
