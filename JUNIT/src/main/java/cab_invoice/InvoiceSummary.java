package main.java.cab_invoice;
//Step 2 - Multiple Rides
//Step 3 - Enhanced Invoice
public class InvoiceSummary {
    private final int numberOfRides;
    private final int totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, int totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = (double) totalFare / numberOfRides;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummary)) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numberOfRides == that.numberOfRides &&
                totalFare == that.totalFare &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "rides=" + numberOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }
}
