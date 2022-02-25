package Stax;

import Stocks.Stock;

public class StackLL {
    Node top;
    int size;

        public StackLL()
    {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }
    public int getSize()
    {
        return size;
    }

    public void push(Stock stock)
    {
        Node n = new Node(stock);
        if (getTop() != null) {
            top.setNext(n);
        }
        setTop(n);
        size++;
    }

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
