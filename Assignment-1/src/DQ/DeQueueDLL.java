package DQ;

import Stocks.Stock;

public class DeQueueDLL {
    DNode front;
    DNode rear;

    int size;

    public DeQueueDLL()
    {
        this.front = this.rear = null;
        this.size = 0;
    }

    boolean isEmpty()
    {
        return front == null;
    }
    public int getSize()
    {
        return size;
    }

    public void enQueueFront(Stock stock)
    {
        DNode node = new DNode(stock);
        if(this.isEmpty())
            this.rear = this.front = node;
        else
        {
            node.setNext(this.front);
            this.front.setPrev(node);
            front = node;
        }
        size++;
    }

    public void enQueueRear(Stock stock)
    {
        DNode node = new DNode(stock);
        if(this.isEmpty())
            this.rear = this.front = node;
        else
        {
            node.setPrev(this.rear);
            this.rear.setNext(node);
            rear = node;
        }
        size++;
    }

    public Stock deQueueFront()
    {
        if(this.isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        else
        {
            DNode temp = front;
            front = front.getNext();

            if(front == null)
                rear = null;
            else
                front.setPrev(null);

            size--;
            return temp.getStock();
        }
    }

    public Stock deQueueRear()
    {
        if(this.isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        else
        {
            DNode temp = rear;
            rear = rear.getPrev();

            if (rear == null)
                front = null;
            else
                rear.setNext(null);

            size--;
            return temp.getStock();
        }
    }

    public Stock peakFront()
    {
        if(this.isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        return front.getStock();
    }

    public Stock peakRear()
    {
        if(this.isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        return rear.getStock();
    }
}
