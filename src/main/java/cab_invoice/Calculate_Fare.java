package cab_invoice;

public class Calculate_Fare {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MINIMUM_FARE = 5;

    private int distance;
    private int time;

    public Calculate_Fare(int distance, int time) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero!");
        }
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    // Fare formula: distance * 10 + time * 1
    public int calculateFare() {
        int fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(fare, MINIMUM_FARE);
    }
}
