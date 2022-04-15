/**
 * This class represents the individual voter in the dataset.
 * Voter details are immutable.
 *
 * id : stores voter ID
 * name : stores voter first name
 * surname : stores voter last name
 * age : stores voter age
 * gender : stores voter gender
 * race : stores voter race
 * opCount : stores the operation count during hashing process.
 *
 * @author Shadab Khan
 **/
public class Voter implements Comparable{
    private long id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String race;
    private int opCount;

    /**
     * Constructor to assign values.
     *
     * @param id long
     * @param name String
     * @param surname String
     * @param age int
     * @param gender String
     * @param race String
     */
    public Voter(long id, String name, String surname, int age, String gender, String race){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.opCount = 0;
    }

    /**
     * ID Accessor method
     * @return id long
     */
    public long getId(){
        return id;
    }

    /**
     * Mutator method for opCount
     * @param n int
     */
    public void setOpCount(int n){
        this.opCount = n;
    }

    /**
     * Accessor method for opCount
     * @return opCount int
     */
    public int getOpCount(){
        return opCount;
    }

    /**
     * Compares ID of voters to eliminate discrepancies.
     * @param otherObject Object
     * @return int
     */
    public int compareTo(Object otherObject){
        Voter v = (Voter)otherObject;
        return Long.compare(v.getId(), this.id);
    }

    /**
     * toString method for String representation of the voter object.
     * @return String
     */
    public String toString(){
        return "ID Number: "+id+"\nName: "+name+"\tSurname: "+surname+"\nAge: "+age+"\tGender: "+gender+"\tRace: "+race+"\nopCount: "+opCount;
    }
}