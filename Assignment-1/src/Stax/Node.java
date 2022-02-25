package Stax;

import Stocks.Stock;

public class Node {
    Stock stock;
    Node next;

    public Node(Stock stock)
    {
        this.stock = stock;
        this.next = null;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
