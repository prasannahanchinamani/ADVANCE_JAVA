package cab_invoice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {
    Ride[] rides;

    @BeforeEach
    void setUp() {
        Ride.resetRideCount(); // reset counter before each test

        rides = new Ride[]{
                new Ride(10, 2), // 102
                new Ride(5, 5),  // 55
                new Ride(1, 1)   // 11
        };
    }

    @Test
    void givenDistanceAndTime() {
        assertEquals(102, rides[0].calculateFare()); // 10*10 + 2*1 = 102
    }

    @Test
    void givenSmallDistance() {
        Ride fare = new Ride(1, 0);
        assertEquals(10, fare.calculateFare());  // 1*10 = 10 (>5 so valid)
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
        int totalFare = Ride.calculateTotalFare(rides);
        assertEquals(168, totalFare); // 102 + 55 + 11
    }

    @Test
    void rideCount() {
        assertEquals(3, Ride.getRideCount());
    }

    @Test
    //test with multiple invoce summary report
    public void enhancedInvoiceSummary() {
        InvoiceSummary summary = Ride.getInvoiceSummary(rides);
        InvoiceSummary expected = new InvoiceSummary(3, 168);
        assertEquals(3,expected.getNumberOfRides());
        assertEquals(168, summary.getTotalFare());
        assertEquals(56,summary.getAverageFare());
        // 168/3
    }
    //step 5 premimum users
    @Test
    void testNormalRideFare() {
        Ride normalRide = new Ride(new NormalRideCalculator(), 10, 5); // 10*10 + 5*1 = 105
        assertEquals(105, normalRide.calculateFareFor());
    }

    @Test
    void testPremiumRideFare() {
        Ride premiumRide = new Ride(new PremiumRideCalculator(), 10, 5); // 10*15 + 5*2 = 160
        assertEquals(160, premiumRide.calculateFareFor());
    }

    @Test
    void testNormalRide_MinimumFare() {
        Ride normalRide = new Ride(new NormalRideCalculator(), 1, 0); // 1*10 = 10 (>5)
        assertEquals(10, normalRide.calculateFareFor());
    }

    @Test
    void testPremiumRide_MinimumFare() {
        Ride premiumRide = new Ride(new PremiumRideCalculator(), 1, 0); // 15 < 20 → 20
        assertEquals(20, premiumRide.calculateFareFor());
    }
}
