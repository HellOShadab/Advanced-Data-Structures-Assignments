import java.io.*;
import java.util.*;
/**
 * Main class
 *
 * @author Shadab Khan
 **/
public class Main {

    // Main...
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run(0); // 1 * table size
        long stop = System.currentTimeMillis();
        long run1 = stop - start;
        start = System.currentTimeMillis();
        run(50); // 1.5* table size
        stop = System.currentTimeMillis();
        long run2 = stop - start;

        System.out.println("See files in \"Results\" folder for results.");

        System.out.println("Time taken for 1 * table size : " + run1);
        System.out.println("Time taken for 1.5 * table size : " + run2);
    }
    /**
     * Reads from file, calls makeIDList fn to create IDs, passes list into hash tables,
     * creates write files output, writes into output files, displays results.
     *
     * @param ratio int
     */
    public static void run(int ratio){
        System.out.println("Running hash table (ratio "+ratio+")...");
        String namePath = "src/data/voter_data.csv";
        Long[] list = makeIDList(namePath);

        StringBuilder sbLin = new StringBuilder();
        StringBuilder sbAVL = new StringBuilder();

        for(int i = 1 ; i < 200 ; i++){
            int tableSize = i + (ratio*i)/100;

            HashTableLinear htbLin = new HashTableLinear(i, tableSize);
            HashTableAVL htbAVL = new HashTableAVL(i, tableSize);

            String path = "src/data/subsets/voter_test_"+(i+1)+".csv";
            loadData(htbLin, htbAVL, path);

            int[] opCountLin = new int[i];
            float linSum = 0;

            int[] opCountAVL = new int[i];
            float AVLSum = 0;

            for(int j=0 ; j < i ; j ++){
                Voter query = new Voter(list[j],"","",0,"","");
                Voter v1 = (Voter)htbLin.get(query, list[j]);
                Voter v2 = (Voter)htbAVL.get(query, list[j]);

                int op1 = v1.getOpCount();
                int op2 = v2.getOpCount();

                opCountLin[j] = op1;
                linSum += op1;

                opCountAVL[j] = op2;
                AVLSum += op2;
            }

            Arrays.sort(opCountLin);
            Arrays.sort(opCountAVL);

            sbLin.append(opCountLin[0]+","+(linSum / i)+","+opCountLin[i-1]+","+htbLin.getAverageCollisions()+"\n");
            sbAVL.append(opCountAVL[0]+","+(AVLSum / i)+","+opCountAVL[i-1]+","+htbAVL.getAverageCollisions()+"\n");
        }
        try{
            // Write search results to file
            File f1 = new File("src/Results/LinearResults_"+ratio+".txt");
            File f2 = new File("src/Results/AVLResults_"+ratio+".txt");
            if(f1.createNewFile());
            if(f2.createNewFile());
            PrintWriter pw1 = new PrintWriter(new FileWriter(f1));
            PrintWriter pw2 = new PrintWriter(new FileWriter(f2));
            pw1.write("OP-comp, Comp-val, OP-collisions, Collisions-val\n");
            pw2.write("OP-comp, Comp-val, OP-collisions, Collisions-val\n");
            pw1.write(sbLin.toString());
            pw2.write(sbAVL.toString());
            pw1.close();
            pw2.close();

            System.out.println("Done! :D");
        } catch (IOException e){
            System.out.println(e);
            System.out.println("Error creating or writing results to file...");
        }
    }

    /**
     * Static function that loads all values in dataset into hash table.
     *
     * @param htbLin HashTableLinear
     * @param htbAVL HashTableAVL
     * @param path String
     */
    public static void loadData(HashTableLinear htbLin, HashTableAVL htbAVL, String path){
        String line = "";
        String cvsSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // handle first line

            File f3 = new File("src/Results/results.txt");
            if(f3.createNewFile());
            PrintWriter pw3 = new PrintWriter(new FileWriter(f3));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = (line.trim()).split(cvsSplitBy);
                long id = Long.parseLong(data[0]);
                int age = Integer.parseInt(data[3]);
                htbLin.put(new Voter(id,data[1],data[2],age,data[4],data[5]), id);
                htbAVL.put(new Voter(id,data[1],data[2],age,data[4],data[5]), id);
                pw3.write(String.valueOf(new Voter(id,data[1],data[2],age,data[4],data[5])));
                pw3.write("\n\n");
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static function to generate list of IDs to pass into get functions
     * of the hash objects.
     *
     * @param path String
     * @return Long[]
     */
    public static Long[] makeIDList(String path){
        String line = "";
        String cvsSplitBy = ",";
        Long[] list = new Long[200];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // handle first line

            for(int i = 0 ; i < 200; i++) {
                line = br.readLine();
                // use comma as separator
                String[] temp = (line.trim()).split(cvsSplitBy);
                list[i] = Long.parseLong(temp[0]);
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }
}