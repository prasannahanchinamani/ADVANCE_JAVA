package cab_invoice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Calculate_FareTest {
    Calculate_Fare calculatefare;

    @ParameterizedTest
    @CsvSource({
            "10,2,102",   // 10*10 + 2*1 = 102
            "5,5,55",     // 5*10 + 5*1 = 55
            "1,1,11",     // 1*10 + 1*1 = 11
            "1,0,10",     // minimum > 5
    })
    void calculateFareTest(int distance, int time, int expectedFare) {
        Calculate_Fare fare = new Calculate_Fare(distance, time);
        assertEquals(expectedFare, fare.calculateFare(distance, time));
    }

    // ❌ Invalid: 0 or negative must throw exception
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void testInvalidDistance_ShouldThrowException(int distance) {
        assertThrows(IllegalArgumentException.class, () -> new Calculate_Fare(distance, 5));
    }

}
