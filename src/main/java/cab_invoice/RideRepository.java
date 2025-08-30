package cab_invoice;

import java.util.HashMap;
import java.util.Map;
// step 4   Invoice Service
public class RideRepository {
    private final Map<String, Ride[]> userRides = new HashMap<>();

    public void addRides(String userId, Ride[] rides) {
        userRides.put(userId, rides);
    }

    public Ride[] getRideDetails(String userId) {
        return userRides.get(userId);
    }

}
