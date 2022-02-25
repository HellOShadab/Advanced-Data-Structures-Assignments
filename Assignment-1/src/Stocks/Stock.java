package Stocks;

public class Stock {
    double value;
    String date;

    Stock(double value, String date)
    {
        this.value = value;
        this.date = date;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" + "Date : " + this.getDate() + ", Value = " + this.getValue() + '}';
    }
}
