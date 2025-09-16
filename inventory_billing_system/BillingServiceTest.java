package inventory_billing_system;

import static org.junit.jupiter.api.Assertions.*;
import inventory_billing_system.discount.FixedDiscount;
import inventory_billing_system.discount.PercentageDiscount;
import inventory_billing_system.entities.Bill;
import inventory_billing_system.entities.Customer;
import inventory_billing_system.factory.ProductFactory;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BillingServiceTest {

    private InventoryService inventory;
    private BillingService billing;

    @BeforeEach
    public void setup() {
        inventory = InventoryService.getInstance();
        inventory.clearAll(); // reset inventory for each test
        billing = new BillingService(inventory);
    }

    @Test
    public void testPurchaseWithPercentageDiscount() {
        inventory.addProduct(ProductFactory.createProduct("Grocery", 1, "Rice", 100.0, 50));

        Customer c = new Customer(1, "Prasanna");
        Bill bill = billing.generateBill(c, Map.of(1, 2), new PercentageDiscount(10));

        assertEquals(200.0, bill.getTotalAmount(), 0.0001);
        assertEquals(20.0, bill.getDiscountApplied(), 0.0001);
        assertEquals(180.0, bill.getFinalAmount(), 0.0001);

        // stock should reduce
        Optional.of(inventory.findProductById(1).orElseThrow())
                .ifPresent(p -> assertEquals(48, p.getStockQuantity()));
    }

    @Test
    public void testPurchaseWithFixedDiscount() {
        inventory.addProduct(ProductFactory.createProduct("Electronics", 2, "Headphones", 500.0, 20));

        Customer c = new Customer(2, "Anil");
        Bill bill = billing.generateBill(c, Map.of(2, 1), new FixedDiscount(100));

        assertEquals(500.0, bill.getTotalAmount(), 0.0001);
        assertEquals(100.0, bill.getDiscountApplied(), 0.0001);
        assertEquals(400.0, bill.getFinalAmount(), 0.0001);
    }

    @Test
    public void testOutOfStockThrowsException() {
        inventory.addProduct(ProductFactory.createProduct("Clothing", 3, "Shirt", 300.0, 1));

        Customer c = new Customer(3, "Ravi");

        Exception ex = assertThrows(RuntimeException.class,
                () -> billing.generateBill(c, Map.of(3, 5), new PercentageDiscount(5)));

        assertTrue(ex.getMessage().toLowerCase().contains("insufficient"));
    }

    @Test
    public void testSearchProductByCategoryUsingStream() {
        inventory.addProduct(ProductFactory.createProduct("Grocery", 4, "Wheat", 120.0, 10));
        inventory.addProduct(ProductFactory.createProduct("Electronics", 5, "TV", 15000.0, 5));

        List<inventory_billing_system.entities.Product> groceries = inventory.searchByCategory("Grocery");

        assertEquals(1, groceries.size());
        assertEquals("Wheat", groceries.get(0).getName());
    }

    @Test
    public void testOptionalForMissingProduct() {
        Optional<inventory_billing_system.entities.Product> product = inventory.findProductById(999);
        assertTrue(product.isEmpty());
    }
}