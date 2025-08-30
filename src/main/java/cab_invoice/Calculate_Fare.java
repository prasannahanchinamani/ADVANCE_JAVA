package cab_invoice;

public class Calculate_Fare {
    private int distance;
    private int time;

    public Calculate_Fare(int distance, int time) {
        this.distance = distance;
        this.time = time;
        validateDistance();
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    // Fare formula: distance * 10 + time * 1
    public int calculateFare(int distance, int time) {
        int fare = distance * 10 + time * 1;
        return Math.max(fare, 5);
    }

    public boolean validateDistance() {
        if (distance <=0)  // now also blocks zero
            throw new IllegalArgumentException("Distance cannot be zero or negative!");
        return true;
    }
}
