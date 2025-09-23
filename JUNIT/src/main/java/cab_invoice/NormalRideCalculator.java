package main.java.cab_invoice;

public class NormalRideCalculator implements cab_invoice.RideCalculator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;

    @Override
    public int calculateFareBasedOnType(int distance, int time) {
        int fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(fare, MIN_FARE);
    }
}
