import java.util.*;
/**
 * This class creates a generic hash table.
 *
 * hashArray : Stores the hash values at key indexes in a Voter type array.
 * tableSize : Stores the size of the hash table.
 * dataSetSize : Stores the size of the current data set.
 * totalClashes : Used to compute the number of clashes occurred.
 *
 * @author Shadab Khan
 **/
public class HashTableLinear {
    private Voter[] hashArray;
    private int tableSize;
    private int dataSetSize;
    private float totalClashes;

    /**
     * Constructor to initialize variables.
     * @param N int
     * @param M int
     */
    public HashTableLinear(int N, int M){
        this.dataSetSize = N;
        this.tableSize = M;
        this.totalClashes = 0;
        hashArray = new Voter[tableSize];
    }

    /**
     * Generates hash values. Uses bit mask to clear out register for rotation (& 0x7fffffff).
     * @param key long
     * @return int
     */
    public int hash(Long key){
        String temp = Long.toString(key);
        return (temp.hashCode() & 0x7fffffff) % tableSize;
    }

    /**
     * Insert generated hash value into hashArray.
     *
     * @param v Voter
     * @param key long
     */
    public void put(Voter v, long key){
        int i = hash(key);
        while(hashArray[i] != null){
            totalClashes++;
            i = (i + 1) % tableSize;
        }
        hashArray[i] = v;
    }

    /**
     * Returns the data in given hash value by accessing the node using key.
     *
     * @param v Voter
     * @param key key
     * @return Voter
     */
    public Voter get(Voter v, long key){
        int i = hash(key);
        int[] opCount = {0};
        while(hashArray[i] != null){
            opCount[0]++;
            if(v.getId() == hashArray[i].getId()){
                hashArray[i].setOpCount(opCount[0]);
                return hashArray[i];
            }
            i = (i + 1) % tableSize;
        }
        return null;
    }

    /**
     * Computes the average Collisions occurred.
     * @return float
     */
    public float getAverageCollisions(){
        return totalClashes / dataSetSize;
    }

    /**
     * toString method to get String representation of the hashArray.
     * @return String
     */
    public String toString(){
        return Arrays.toString(hashArray);
    }
}