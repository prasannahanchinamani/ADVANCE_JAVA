package cab_invoice;

public class PremiumRideCalculator implements RideCalculator {
    private static final int COST_PER_KM = 15;
    private static final int COST_PER_MIN = 2;
    private static final int MIN_FARE = 20;

    @Override
    public int calculateFareBasedOnType(int distance, int time) {
        int fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(fare, MIN_FARE);
    }
}
