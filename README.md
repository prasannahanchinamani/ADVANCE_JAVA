# 🚗 Car Invoice System — TDD with Java & JUnit

## 📌 Overview
This backend project calculates car ride invoices using **Java**, **OOP**, and **Test-Driven Development (TDD)** with **JUnit**. It supports both **normal** and **premium** ride types, generates invoice summaries, and includes robust unit tests for multiple scenarios.

## 🧩 Modules

| Class Name                 | Description                                                             |
|---------------------------|-------------------------------------------------------------------------|
| `Ride.java`               | Represents a ride with distance, time, and type                         |
| `RideCalculator.java`     | Interface for fare calculation logic                                    |
| `NormalRideCalculator.java` | Calculates fare for normal rides (`₹10/km + ₹1/min`)                   |
| `PremiumRideCalculator.java`| Calculates fare for premium rides (`₹15/km + ₹2/min`)                  |
| `InvoiceSummary.java`     | Stores total fare, ride count, and average fare                         |
| `InvoiceService.java`     | Generates invoice summaries from ride data                              |
| `RideRepository.java`     | Stores and retrieves rides by user ID                                   |

## ✅ Test Scenarios (JUnit)

- Single normal ride
- Multiple normal rides
- Single premium ride
- Multiple premium rides
- Mixed ride types
- Zero distance/time edge cases
- Null or empty ride arrays
- User-specific ride history

## 🧪 Sample Test Case

```java
@Test
public void givenMultipleNormalRides_shouldReturnCorrectInvoiceSummary() {
    Ride[] rides = {
        new Ride(2.0, 5, RideType.NORMAL),
        new Ride(0.1, 1, RideType.NORMAL)
    };
    InvoiceSummary summary = invoiceService.calculateInvoice(rides);
    assertEquals(new InvoiceSummary(2, 26.0), summary);
}
