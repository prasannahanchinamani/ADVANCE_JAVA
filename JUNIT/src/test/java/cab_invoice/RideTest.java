package cab_invoice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    @BeforeEach
    void setUp() {
        Ride.resetRideCount(); // only reset before each test
    }

    @Test
    void givenDistanceAndTime() {
        Ride ride = new Ride(10, 2); // fare = 102
        assertEquals(102, ride.calculateFare());
    }

    @Test
    void givenSmallDistance() {
        Ride ride = new Ride(1, 0); // fare = 10 (>5)
        assertEquals(10, ride.calculateFare());
    }

    @Test
    void givenZeroDistance() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ride(0, 5));
    }

    @Test
    void givenNegativeDistance() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ride(-2, 5));
    }

    @Test
    void calculateTotalFare_ForMultipleRides() {
        Ride[] rides = {
                new Ride(10, 2), // 102
                new Ride(5, 5),  // 55
                new Ride(1, 1)   // 11
        };
        int totalFare = Ride.calculateTotalFare(rides);
        assertEquals(168, totalFare);
    }

    @Test
    void rideCount() {
        new Ride(10, 2);
        new Ride(5, 5);
        new Ride(1, 1);
        assertEquals(3, Ride.getRideCount());
    }

    @Test
    void enhancedInvoiceSummary() {
        Ride[] rides = {
                new Ride(10, 2), // 102
                new Ride(5, 5),  // 55
                new Ride(1, 1)   // 11
        };
        InvoiceSummary summary = Ride.getInvoiceSummary(rides);

        assertEquals(3, summary.getNumberOfRides());
        assertEquals(168, summary.getTotalFare());
        assertEquals(56, summary.getAverageFare()); // 168/3
    }

    // Step 5: Premium rides
    @Test
    void testNormalRideFare() {
        Ride normalRide = new Ride(new NormalRideCalculator(), 10, 5); // 10*10 + 5*1
        assertEquals(105, normalRide.calculateFareFor());
    }

    @Test
    void testPremiumRideFare() {
        Ride premiumRide = new Ride(new PremiumRideCalculator(), 10, 5); // 10*15 + 5*2
        assertEquals(160, premiumRide.calculateFareFor());
    }

    @Test
    void testNormalRide_MinimumFare() {
        Ride normalRide = new Ride(new NormalRideCalculator(), 1, 0);
        assertEquals(10, normalRide.calculateFareFor()); // min 5, actual 10
    }

    @Test
    void testPremiumRide_MinimumFare() {
        Ride premiumRide = new Ride(new PremiumRideCalculator(), 1, 0);
        assertEquals(20, premiumRide.calculateFareFor()); // min 20 > 15
    }
}
