/**
 * This class creates a hash table using the AVL Tree data structure.
 *
 * hashArray : Stores the hash value at key indexes in the AVL Tree array.
 * tableSize : Stores the table size (1.5 * data set).
 *
 * @author Shadab Khan
 **/
public class HashTableAVL<dataType extends Comparable<? super dataType>>{
    private AVLTree[] hashArray;
    private int tableSize;

    /**
     * Constructor to initialize the variables.
     *
     * @param N int
     * @param ratio int
     */
    public HashTableAVL(int N, int ratio){
        this.tableSize = N + (N*ratio)/100; 				// 1.5 x the size of the data set
        hashArray = new AVLTree [tableSize];
        for(int i = 0 ; i < (tableSize) ; i ++){
            hashArray[i] = new AVLTree();
        }
    }

    /**
     * Generates hash values. Uses bit mask to clear out register for rotation (& 0x7fffffff).
     *
     * @param key long
     * @return int
     */
    public int computeHash(long key){
        String temp = Long.toString(key);
        return (temp.hashCode() & 0x7fffffff) % tableSize;  				// a 13 digit ID number warrants a basic hash function
    }

    /**
     * Insert generated hash value into hashArray.
     *
     * @param d dataType
     * @param key long
     */
    public void put(dataType d, long key){
        int hash = computeHash(key);
        hashArray[hash].insert(d);
    }

    /**
     * Returns the data in given hash value by accessing the node using key.
     *
     * @param d dataType
     * @param key long
     * @return dataType
     */
    public dataType get(dataType d, long key){
        AVLTree<dataType> position = hashArray[computeHash(key)];
        try{
            return (position.find(d)).data;
        }
        catch(NullPointerException e){
            return null;
        }
    }

    /**
     * Computes collisions occurred for computational comparison purposes.
     * @return float
     */
    public float getAverageCollisions(){
        float nonEmpty = 0;
        float  totalClashes = 0;
        for (AVLTree avlTree : hashArray) {
            int size = avlTree.getSize();
            if (size != 0) {
                nonEmpty++;
                totalClashes += size - 1.0; // more than one entry is considered a clash
            }
        }
        return totalClashes / nonEmpty;
    }
}