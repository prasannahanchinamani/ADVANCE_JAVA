package jdbc_demo.e_commerce_management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ECommerceJDBCTest {

    private ECommerceJDBC dao;

    @BeforeEach
    void setUp() {
        dao = new ECommerceJDBC();
    }

    @Test
    void testSearchCustomerByEmail() {
        List<Customer> result = dao.searchCustomerByEmail("aarav@example.com");
        assertNotNull(result, "Result should not be null");
        assertFalse(result.isEmpty(), "No customer found with this email");

        Customer customer = result.get(0);
        assertEquals("aarav@example.com", customer.getEmail());
        assertNotNull(customer.getFullName());
        assertNotNull(customer.getPhone());
    }

    @Test
    void testGetProductsByCategory() {
        List<Product> products = dao.getProductsByCategory("Electronics");
        assertNotNull(products, "Result should not be null");
        assertFalse(products.isEmpty(), "No products found in this category");

        for (Product p : products) {
            assertEquals("Electronics", p.getCategoryName());
            assertNotNull(p.getProductName());
            assertTrue(p.getStock() >= 0);
        }
    }

    @Test
    void testGetOrderDetails() {
        List<OrderDetail> orderDetails = dao.getOrderDetails();
        assertNotNull(orderDetails, "Order details should not be null");
        assertFalse(orderDetails.isEmpty(), "No order details found");

        for (OrderDetail od : orderDetails) {
            assertNotNull(od.getCustomerName());
            assertNotNull(od.getProductName());
            assertTrue(od.getQuantity() > 0);
            assertTrue(od.getPrice() > 0);
        }
    }

    @Test
    void testGetRecentOrders() {
        List<OrderSummary> recentOrders = dao.getRecentOrders();
        assertNotNull(recentOrders, "Recent orders should not be null");

        for (OrderSummary o : recentOrders) {
            assertTrue(o.getTotalSpent() >= 0);
            assertTrue(o.getCategoriesBought() >= 0);
            assertNotNull(o.getFullName());
        }
    }

    @Test
    void testGetTopCustomers() {
        List<OrderSummary> topCustomers = dao.getTopCustomers();
        assertNotNull(topCustomers, "Top customers should not be null");

        for (OrderSummary o : topCustomers) {
            assertTrue(o.getTotalSpent() >= 0);
            assertTrue(o.getCategoriesBought() >= 3, "Customer should have bought from at least 3 categories");
            assertNotNull(o.getFullName());
        }
    }
}
