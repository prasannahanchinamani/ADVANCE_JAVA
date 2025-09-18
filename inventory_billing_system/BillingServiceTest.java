package inventory_billing_system;

import inventory_billing_system.discount.FixedDiscount;
import inventory_billing_system.discount.PercentageDiscount;
import inventory_billing_system.entities.Bill;
import inventory_billing_system.entities.Customer;
import inventory_billing_system.entities.Product;
import inventory_billing_system.factory.ProductFactory;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BillingServiceTest {

    private InventoryService inventory;
    private BillingService billing;//

    @BeforeEach
    void setup() {
        //singleton design
        inventory = InventoryService.getInstance();
        inventory.clearAll();//-  reset button
        billing = new BillingService(inventory);
    }

    @Test
    void testPercentageDiscount() {
        inventory.addProduct(ProductFactory.createProduct("Grocery", 1, "Rice", 100.0, 50));
        Customer customer = new Customer(1, "Prasanna");

        Bill bill = billing.generateBill(customer, Map.of(1, 2), new PercentageDiscount(10));

        assertEquals(200.0, bill.getTotalAmount(), 0.0001);//delta is how much difference is allowed
        assertEquals(20.0, bill.getDiscountApplied(), 0.0001);//dicount price
        assertEquals(180.0, bill.getFinalAmount(), 0.0001);//net amount

        Product rice = inventory.findProductById(1).orElseThrow();
        assertEquals(48, rice.getStockQuantity());//stock reduced
    }

    @Test
    void testFixedDiscount() {
        inventory.addProduct(ProductFactory.createProduct("Electronics", 2, "Headphones", 500.0, 20));
        Customer customer = new Customer(2, "Anil");

        Bill bill = billing.generateBill(customer, Map.of(2, 1), new FixedDiscount(100));//fixed discount 100

        assertEquals(500.0, bill.getTotalAmount(), 0.0001);
        assertEquals(100.0, bill.getDiscountApplied(), 0.0001);//discount amount
        assertEquals(400.0, bill.getFinalAmount(), 0.0001);
    }

    @Test
    void testOutOfStock() {
        inventory.addProduct(ProductFactory.createProduct("Clothing", 3, "Shirt", 300.0, 1));
        Customer customer = new Customer(3, "Ravi");
        //handle the execption( only 1 stock is availabale customer want 5
        Exception ex = assertThrows(RuntimeException.class, () ->
                billing.generateBill(customer, Map.of(3, 5), new PercentageDiscount(5)));


        assertTrue(ex.getMessage().toLowerCase().contains("insufficient"));
    }

    @Test
    void testSearchByCategory() {
        inventory.addProduct(ProductFactory.createProduct("Grocery", 4, "Wheat", 120.0, 10));
        inventory.addProduct(ProductFactory.createProduct("Electronics", 5, "TV", 15000.0, 5));

        List<Product> groceries = inventory.searchByCategory("Grocery");

        assertEquals(1, groceries.size());
        assertEquals("Wheat", groceries.get(0).getName());
    }

    @Test
    void testMissingProductOptional() {
        Optional<Product> product = inventory.findProductById(999);
        assertTrue(product.isEmpty());
    }
}
