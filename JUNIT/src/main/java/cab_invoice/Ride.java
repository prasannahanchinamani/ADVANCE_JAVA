package main.java.cab_invoice;

//Step 1 - Calculate Fare
public class Ride {
    private int distance;
    private int time;
    private cab_invoice.RideCalculator rideCalculator;
    private static int rideCount = 0;


    public Ride(cab_invoice.RideCalculator rideCalculator, int distance, int time) {
        this.rideCalculator = rideCalculator;
        this.distance = distance;
        this.time = time;
        validateDistance();
        rideCount++;
    }

    public Ride(int distance, int time) {
//        this.rideCalculator = rideCalculator;
        this.distance = distance;
        this.time = time;
        validateDistance();
        rideCount++;
    }

    // fare for single ride
    public int calculateFare() {
        int fare = distance * 10 + time * 1;
        return Math.max(fare, 5);
    }

    // step 5 Premium Rides
    public int calculateFareFor() {
        return rideCalculator.calculateFareBasedOnType(distance, time);
    }

    // total fare for multiple rides
    public static int calculateTotalFare(Ride[] rides) {
        int total = 0;
        for (Ride ride : rides) {
            total += ride.calculateFare();
        }
        return total;
    }

    private void validateDistance() {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance cannot be zero or negative!");
        }
    }

    // ride count handling
    public static int getRideCount() {
        return rideCount;
    }

    public static void resetRideCount() {
        rideCount = 0;
    }

    //Step 2 - Multiple Rides
    public static InvoiceSummary getInvoiceSummary(Ride[] rides) {
        int totalFare = calculateTotalFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }

}
