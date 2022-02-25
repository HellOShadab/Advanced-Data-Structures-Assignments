package Stocks;

/**
 * Basic object (stock). It is the main building block for the entire project.
 * Each stock contains an index value (double) and a date (String).
 *
 * @author ShadabKhan
 */
public class Stock {
    double value;
    String date;

    /**
     * Constructor to initialize a stock.
     *
     * @param value
     * @param date
     */
    Stock(double value, String date)
    {
        this.value = value;
        this.date = date;
    }

    /**
     * Getter method for Value.
     * @return value
     */
    public double getValue() {return value;}
    /**
     * Setter method for Value.
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Getter Method for Date.
     * @return date
     */
    public String getDate() {
        return date;
    }
    /**
     * Setter Method for Date.
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * To string method for displaying a stock.
     * @return String
     */
    @Override
    public String toString() {
        return "{" + "Date : " + this.getDate() + ", Value = " + this.getValue() + '}';
    }
}
