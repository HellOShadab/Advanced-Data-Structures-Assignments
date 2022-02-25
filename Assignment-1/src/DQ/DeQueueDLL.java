package DQ;

import Stocks.Stock;

/**
 * A DeQueue class that is made using Nodes to create a doubly linked list.
 *
 * @author ShadabKhan
 */
public class DeQueueDLL {
    DNode front;
    DNode rear;

    int size;

    /**
     * Constructor to initialize all values to 0 and null.
     */
    public DeQueueDLL()
    {
        this.front = this.rear = null;
        this.size = 0;
    }

    /**
     * Checks if DeQueue is empty.
     */
    boolean isEmpty()
    {
        return front == null;
    }
    public int getSize()
    {
        return size;
    }

    /**
     * Element insertion in queue from front.
     * Appropriate changes to front and rear pointers made.
     *
     * @param stock
     */
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

    /**
     * Element insertion in queue from rear.
     * Appropriate changes to front and rear pointers made.
     *
     * @param stock
     */
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

    /**
     * Element extraction in queue from front.
     * Appropriate changes to front and rear pointers made.
     *
     * @return stock
     */
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

    /**
     * Element extraction in queue from rear.
     * Appropriate changes to front and rear pointers made.
     *
     * @return stock
     */
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

    /**
     * Peak into deQueue from the front.
     *
     * @return stock
     */
    public Stock peakFront()
    {
        if(this.isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        return front.getStock();
    }

    /**
     * Peak into deQueue from the rear.
     *
     * @return stock
     */
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
