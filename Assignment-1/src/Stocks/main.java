package Stocks;

import DQ.DeQueueDLL;
import Stax.StackLL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main.
 */
public class main {

    public static void main(String[] args) throws IOException {

        StackLL stack1 = new StackLL();
        DeQueueDLL dequeue1 = new DeQueueDLL();
        StackLL stack2 = new StackLL();
        DeQueueDLL dequeue2 = new DeQueueDLL();
        StackLL stack3 = new StackLL();
        DeQueueDLL dequeue3 = new DeQueueDLL();

        BufferedReader csvReader1 = new BufferedReader(new FileReader("src/resources/DowJones.csv"));
        BufferedReader csvReader2 = new BufferedReader(new FileReader("src/resources/Nasdaq.csv"));
        BufferedReader csvReader3 = new BufferedReader(new FileReader("src/resources/SP500.csv"));
        Scanner sc = new Scanner(System.in);
        String line;

        while ((line = csvReader1.readLine()) != null) {
            String[] data = line.split(",");
            String date = data[0];
            double value = Double.parseDouble(data[1]);

            Stock s = new Stock(value, date);
            s.setDate(date);
            s.setValue(value);

            stack1.push(s);
            dequeue1.enQueueFront(s);
        }

        while ((line = csvReader2.readLine()) != null) {
            String[] data = line.split(",");
            String date = data[0];
            double value = Double.parseDouble(data[1]);

            Stock s = new Stock(value, date);
            s.setDate(date);
            s.setValue(value);

            stack2.push(s);
            dequeue2.enQueueFront(s);
        }

        while ((line = csvReader3.readLine()) != null) {
            String[] data = line.split(",");
            String date = data[0];
            double value = Double.parseDouble(data[1]);

            Stock s = new Stock(value, date);
            s.setDate(date);
            s.setValue(value);

            stack3.push(s);
            dequeue3.enQueueFront(s);
        }

        System.out.println("3 Stacks and DeQueues have been created for DowJones, Nasdaq and SP500 indices");


        long start, end, timeTaken;
        System.out.println("\nStacks......");
        System.out.println("Stack push operation.....");
        String dateTemp, valTemp;
        System.out.println("Enter date and values for DowJones : ");
        System.out.println("Date : ");
        dateTemp = sc.nextLine();
        System.out.println("Value : ");
        valTemp = sc.nextLine();
        Stock s1 = new Stock(Double.parseDouble(valTemp), dateTemp);

        System.out.println("Enter date and values for Nasdaq : ");
        System.out.println("Date : ");
        dateTemp = sc.nextLine();
        System.out.println("Value : ");
        valTemp = sc.nextLine();
        Stock s2 = new Stock(Double.parseDouble(valTemp), dateTemp);

        System.out.println("Enter date and values for SP500 : ");
        System.out.println("Date : ");
        dateTemp = sc.nextLine();
        System.out.println("Value : ");
        valTemp = sc.nextLine();
        Stock s3 = new Stock(Double.parseDouble(valTemp), dateTemp);

        start = System.nanoTime();
        stack1.push(s1);
        stack2.push(s2);
        stack3.push(s3);
        end = System.nanoTime();
        timeTaken = end - start;
        System.out.println("Pushed Successfully!");

        System.out.println("\nStack Peak operation.....");
        start = System.nanoTime();
        System.out.println("Stack 1 : " + stack1.Peak());
        System.out.println("Stack 2 : " + stack2.Peak());
        System.out.println("Stack 3 : " + stack3.Peak());
        end = System.nanoTime();
        timeTaken += (end - start);
        System.out.println("Peaked Successfully!");

        System.out.println("\nStack Pop operation.....");
        start = System.nanoTime();
        System.out.println("Stack 1 : " + stack1.pop());
        System.out.println("Stack 2 : " + stack2.pop());
        System.out.println("Stack 3 : " + stack3.pop());
        end = System.nanoTime();
        timeTaken += (end - start);
        System.out.println("Popped Successfully!");

        System.out.println("\nTime taken for all above operations : " + (double)timeTaken / 100000000 + " seconds");


        System.out.println("Sorting the stack by market index values : ");
        start = System.nanoTime();
        sortStack(stack1);
        sortStack(stack2);
        sortStack(stack3);
        end = System.nanoTime();
        timeTaken = end - start;

        System.out.println("\nTime taken for sorting all stacks : " + (double)timeTaken / 10000 + " seconds");


        System.out.println("\n\nDeQueues...");
        System.out.println("DeQueue EnqueFront...");
        String dateTemp1, valTemp1;
        System.out.println("Enter date and values for DowJones : ");
        System.out.println("Date : ");
        dateTemp1 = sc.nextLine();
        System.out.println("Value : ");
        valTemp1 = sc.nextLine();
        Stock stock1 = new Stock(Double.parseDouble(valTemp1), dateTemp1);

        System.out.println("Enter date and values for Nasdaq : ");
        System.out.println("Date : ");
        dateTemp1 = sc.nextLine();
        System.out.println("Value : ");
        valTemp1 = sc.nextLine();
        Stock stock2 = new Stock(Double.parseDouble(valTemp1), dateTemp1);

        System.out.println("Enter date and values for SP500 : ");
        System.out.println("Date : ");
        dateTemp1 = sc.nextLine();
        System.out.println("Value : ");
        valTemp1 = sc.nextLine();
        Stock stock3 = new Stock(Double.parseDouble(valTemp1), dateTemp1);

        start = System.nanoTime();
        dequeue1.enQueueFront(stock1);
        dequeue2.enQueueFront(stock2);
        dequeue3.enQueueFront(stock3);
        end = System.nanoTime();
        timeTaken = end - start;
        System.out.println("EnQueued from Front Successfully!");

        System.out.println("\nDeQueue Peak Front operation.....");
        start = System.nanoTime();
        System.out.println("DeQueue 1 : " + dequeue1.peakFront());
        System.out.println("DeQueue 2 : " + dequeue2.peakFront());
        System.out.println("DeQueue 3 : " + dequeue3.peakFront());
        end = System.nanoTime();
        timeTaken += (end - start);
        System.out.println("Peaked Front Successfully!");

        System.out.println("\nDeQueue DeQue Front operation.....");
        start = System.nanoTime();
        System.out.println("DeQueue 1 : " + dequeue1.deQueueFront());
        System.out.println("DeQueue 2 : " + dequeue2.deQueueFront());
        System.out.println("DeQueue 3 : " + dequeue3.deQueueFront());
        end = System.nanoTime();
        timeTaken += (end - start);
        System.out.println("DeQued front Successfully!");

        System.out.println("\nTime taken for all above operations : " + (double)timeTaken / 100000000 + " seconds");


        System.out.println("\nDeQueue EnqueRear...");
        String dateTemp2, valTemp2;
        System.out.println("Enter date and values for DowJones : ");
        System.out.println("Date : ");
        dateTemp2 = sc.nextLine();
        System.out.println("Value : ");
        valTemp2 = sc.nextLine();
        stock1 = new Stock(Double.parseDouble(valTemp2), dateTemp2);

        System.out.println("Enter date and values for Nasdaq : ");
        System.out.println("Date : ");
        dateTemp2 = sc.nextLine();
        System.out.println("Value : ");
        valTemp2 = sc.nextLine();
        stock2 = new Stock(Double.parseDouble(valTemp2), dateTemp2);

        System.out.println("Enter date and values for SP500 : ");
        System.out.println("Date : ");
        dateTemp2 = sc.nextLine();
        System.out.println("Value : ");
        valTemp2 = sc.nextLine();
        stock3 = new Stock(Double.parseDouble(valTemp2), dateTemp2);

        start = System.nanoTime();
        dequeue1.enQueueRear(stock1);
        dequeue2.enQueueRear(stock2);
        dequeue3.enQueueRear(stock3);
        end = System.nanoTime();
        timeTaken = end - start;
        System.out.println("EnQueued from Rear Successfully!");

        System.out.println("\nDeQueue Peak Rear operation.....");
        start = System.nanoTime();
        System.out.println("DeQueue 1 : " + dequeue1.peakRear());
        System.out.println("DeQueue 2 : " + dequeue2.peakRear());
        System.out.println("DeQueue 3 : " + dequeue3.peakRear());
        end = System.nanoTime();
        timeTaken += (end - start);
        System.out.println("Peaked Rear Successfully!");

        System.out.println("\nDeQueue DeQue Rear operation.....");
        start = System.nanoTime();
        System.out.println("DeQueue 1 : " + dequeue1.deQueueRear());
        System.out.println("DeQueue 2 : " + dequeue2.deQueueRear());
        System.out.println("DeQueue 3 : " + dequeue3.deQueueRear());
        end = System.nanoTime();
        timeTaken += (end - start);
        System.out.println("DeQued rear Successfully!");

        System.out.println("\nTime taken for all above operations : " + (double)timeTaken / 100000000 + " seconds");
    }


    /**
     * Assisting methods for sorting.
     * @param stack
     * @param top
     */
    static void insertTop(StackLL stack, Stock top)
    {
        if(stack.isEmpty() || top.getValue() > stack.getTop().getStock().getValue())
        {
            stack.push(top);
            return;
        }

        Stock temp = stack.pop();
        insertTop(stack, temp);
        stack.push(temp);
    }

    /**
     * Assisting methods for sorting.
     * @param stack
     */
    static void sortStack(StackLL stack)
    {
        if(!stack.isEmpty())
        {
            Stock top = stack.pop();
            sortStack(stack);
            insertTop(stack, top);
        }
    }

}
