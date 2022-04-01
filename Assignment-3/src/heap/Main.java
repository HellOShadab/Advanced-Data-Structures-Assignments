package heap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main Class
 *
 * @author Shadab Khan
 */

public class Main {
    /**
     * Main function
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int ch;
        do { //Create Main Menu//
            System.out.println("1. THRESHOLD based\t2.10 runs of incrementing dataset of size 40k to 400k\n3.10 individual runs of 40k data points\nEnter Choice (4. for Exit) : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    int THRESHOLD;
                    System.out.println("Set Threshold : ");
                    THRESHOLD = sc.nextInt(); //Taking threshold input from user.
                    thresh(THRESHOLD);
                }
                case 2 -> iter();
                case 3 -> indi();
                case 4 -> System.out.println("Thank You :D");
                default -> System.out.println("INVALID OPTION!!!");
            }
        }while (ch != 4);
    }


    /**
     * Function to Access the Threshold based Heap.
     *
     * @param th
     * @throws IOException
     */
    private static void thresh(int th) throws IOException {
        BufferedReader csvReader1 = new BufferedReader(new FileReader("src/resources/covid.csv"));
        String line;
        MinHeap minHeap = new MinHeap();
        Scanner sc = new Scanner(System.in);

        long start = System.nanoTime();
        while ((line = csvReader1.readLine()) != null) {
            String[] data = line.split(",");
            String county = data[0];
            String province = data[1];
            String date = data[2];
            int cases = Integer.parseInt(data[3]);
            if(cases > th) { //Checking for threshold value and inserting only ones above threshold.
                HeapNode c = new HeapNode(new Covid(county, province, date, cases));
                minHeap.insert(c);
            }
        }
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Time taken to insert entire dataset into heap : " + timeTaken);
        System.out.println("All nodes added successfully!");
        int ch1;
        do { //Inner_Menu1
            System.out.println("1.Size \t2.Check Min value \t3.Remove Min Value \nEnter Choice (4. for Main Menu) : ");
            ch1 = sc.nextInt();

            switch (ch1) {
                case 1 -> System.out.println("Size of heap : " + minHeap.size());
                case 2 -> {
                    start = System.nanoTime();
                    System.out.println("\nMinimum value : " + minHeap.min());
                    end = System.nanoTime();
                    timeTaken = end - start;
                    System.out.println("Time taken for operation : " + timeTaken);
                }
                case 3 ->{
                    start = System.nanoTime();
                    System.out.println("\nRemoving root node : " + minHeap.removeMin());
                    end = System.nanoTime();
                    timeTaken = end - start;
                    System.out.println("Time taken for operation : " + timeTaken);
                }
                case 4 -> System.out.println("Returning to Main Menu....");
                default -> System.out.println("INVALID OPTION!!!");
            }
        }while (ch1 != 4);
    }

    /**
     * Function to access the Iterative heap.
     *
     * @throws IOException
     */
    private static void iter() throws IOException
    {
        BufferedReader csvReader1 = new BufferedReader(new FileReader("src/resources/covid.csv"));
        String line;
        MinHeap minHeap = new MinHeap();
        Scanner sc = new Scanner(System.in);

        int run = 1;
        do{
            int counter = 0;
            System.out.println("Run : " + run);
            if(run == 10)
                System.out.println("**Last run**");
            long start = System.nanoTime();
            while (counter < 40000 && minHeap.size() < 400000) { //10 iterations of 40k each till 400k reached
                line = csvReader1.readLine();
                String[] data = line.split(",");
                String county = data[0];
                String province = data[1];
                String date = data[2];
                int cases = Integer.parseInt(data[3]);
                HeapNode c = new HeapNode(new Covid(county, province, date, cases));
                minHeap.insert(c);
                ++counter;
            }
            long end = System.nanoTime();
            long timeTaken = end - start;
            System.out.println("Time taken to add data points : " + timeTaken);
            System.out.println("40,000 Nodes added.");
            int ch21;
            do { //Inner_Menu2
                System.out.println("1.Size \t2.Check Min value \t3.Remove Min Value \t4.Go for Next 40k \nEnter Choice (5.for Exit) : ");
                ch21 = sc.nextInt();

                switch (ch21) {
                    case 1 -> System.out.println("Size of heap : " + minHeap.size());
                    case 2 -> {
                        start = System.nanoTime();
                        System.out.println("\nMinimum value : " + minHeap.min());
                        end = System.nanoTime();
                        timeTaken = end - start;
                        System.out.println("Time taken for operation : " + timeTaken);
                    }
                    case 3 ->{
                        start = System.nanoTime();
                        System.out.println("\nRemoving root node : " + minHeap.removeMin());
                        end = System.nanoTime();
                        timeTaken = end - start;
                        System.out.println("Time taken for operation : " + timeTaken);
                    }
                    case 4 -> {
                        if(run < 10)
                            System.out.println("Adding next 40k...");
                        else {
                            System.out.println("No more data to add (10x40k is 400k which is max limit of dataset...)");
                        }
                    }
                    case 5 -> run = 11;
                    default -> System.out.println("INVALID OPTION!!!");
                }
            }while (ch21 != 4 && ch21 != 5);
            ++run;
        }while(run <= 10);
    }

    /**
     * Function to access the individual batch based heap.
     *
     * @throws IOException
     */
    private static void indi() throws IOException {
        BufferedReader csvReader1 = new BufferedReader(new FileReader("src/resources/covid.csv"));
        String line;
        Scanner sc = new Scanner(System.in);
        int run = 0, currentIndex = 0;;
        while(run < 10)
        {
            MinHeap minHeap = new MinHeap();
            int max = 40000 * (run + 1);
            long start = System.nanoTime();
            while(currentIndex < max)
            {
                line = csvReader1.readLine();
                String[] data = line.split(",");
                String county = data[0];
                String province = data[1];
                String date = data[2];
                int cases = Integer.parseInt(data[3]);
                HeapNode c = new HeapNode(new Covid(county, province, date, cases));
                minHeap.insert(c);
                ++currentIndex;
            }
            long end = System.nanoTime();
            long timeTaken = end - start;
            System.out.println("Time taken to add data points : " + timeTaken);
            System.out.println("40,000 nodes replaced successfully!");
            int ch3;
            do { //Inner_Menu3
                System.out.println("1.Size \t2.Check Min value \t3.Remove Min Value \t4. Next 40k Data Points\nEnter Choice (5. for Main Menu) : ");
                ch3 = sc.nextInt();

                switch (ch3) {
                    case 1 -> System.out.println("Size of heap : " + minHeap.size());
                    case 2 -> {
                        start = System.nanoTime();
                        System.out.println("\nMinimum value : " + minHeap.min());
                        end = System.nanoTime();
                        timeTaken = end - start;
                        System.out.println("Time taken for operation : " + timeTaken);
                    }
                    case 3 ->{
                        start = System.nanoTime();
                        System.out.println("\nRemoving root node : " + minHeap.removeMin());
                        end = System.nanoTime();
                        timeTaken = end - start;
                        System.out.println("Time taken for operation : " + timeTaken);
                    }
                    case 4 -> {
                        if(max < 400000)
                            System.out.println("Getting next 40k ....");
                        else {
                            System.out.println("No more data available!!");
                            return;
                        }
                    }
                    case 5 -> {
                        System.out.println("Returning to Main Menu....");
                        return;
                    }
                    default -> System.out.println("INVALID OPTION!!!");
                }
            }while (ch3 != 4);
            ++run;
        }
    }
}
