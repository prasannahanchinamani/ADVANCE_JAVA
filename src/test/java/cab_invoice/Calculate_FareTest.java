package cab_invoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calculate_FareTest {

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        Calculate_Fare fare = new Calculate_Fare(10, 5);
        assertEquals(105, fare.calculateFare());  // 10*10 + 5*1 = 105
    }

    @Test
    void givenSmallDistance_ShouldReturnMinimumFare() {
        Calculate_Fare fare = new Calculate_Fare(1 ,0);
        assertEquals(10, fare.calculateFare());  // 1*10 = 10 (>5 so valid)
    }

    @Test
    void givenZeroDistance_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Calculate_Fare(0, 5));
    }

    @Test
    void givenNegativeDistance_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Calculate_Fare(-2, 5));
    }
}
