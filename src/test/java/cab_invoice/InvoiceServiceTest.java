package cab_invoice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceServiceTest {
    InvoiceService invoiceService;

    @BeforeEach
    public void set() {
        invoiceService = new InvoiceService();
    }

    @Test
    void multipleRides_InvoiceSummary() {
        // User A rides
        Ride[] userARides = {
                new Ride(10, 2), // 102
                new Ride(5, 5)   // 55
        };
        invoiceService.addRides("UserA", userARides);
        Ride[] userBRides = {
                new Ride(3, 1),  // 31
                new Ride(2, 2),  // 22
                new Ride(1, 1)   // 11
        };
        invoiceService.addRides("UserB", userBRides);

        InvoiceSummary summaryA = invoiceService.getInVoiceSummary("UserA");
        assertEquals(2, summaryA.getNumberOfRides());
        assertEquals(157, summaryA.getTotalFare());  // 102 + 55
        assertEquals(78.5, summaryA.getAverageFare());

        InvoiceSummary summaryB = invoiceService.getInVoiceSummary("UserB");
        assertEquals(3, summaryB.getNumberOfRides());
        assertEquals(64, summaryB.getTotalFare());  // 102 + 55
        assertEquals(21.33, summaryB.getAverageFare(),0.01);
    }
}