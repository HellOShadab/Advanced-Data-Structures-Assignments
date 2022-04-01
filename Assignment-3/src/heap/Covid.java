package heap;

/**
 * This is an immutable class which represents a COVID-19 record.
 * Each object is an entry in the dataset.
 * The following are the properties :-
 *
 * CountyName : represents the name of the County
 * ProvinceName : represents the name of the Province
 * Date : represents the Date
 * NewCases : represents the new cases Daily
 *
 * @author Shadab Khan
 */

public class Covid {
    private String countyName;
    private String provinceName;
    private String date;
    private int newCases;

    /**
     * Constructs the Covid object
     *
     * @param countyName
     * @param provinceName
     * @param date
     * @param newCases
     */
    public Covid(String countyName, String provinceName, String date, int newCases) {
        this.countyName = countyName;
        this.provinceName = provinceName;
        this.date = date;
        this.newCases = newCases;
    }

    /**
     * Accessor method for CountyName
     * @return countyName
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * Accessor method for ProvinceName
     * @return provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * Accessor method for Date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Accessor method for NewCases
     * @return newCases
     */
    public int getNewCases() {
        return newCases;
    }

    /**
     * Produces a string representation of the Covid Object.
     * @return textual representation of Covid Object.
     */
    @Override
    public String toString() {
        return "Covid Case{" +
                "countyName='" + countyName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", date='" + date + '\'' +
                ", newCases=" + newCases +
                '}';
    }
}
