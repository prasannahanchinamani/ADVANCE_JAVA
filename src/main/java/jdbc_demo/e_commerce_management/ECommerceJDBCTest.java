package jdbc_demo.e_commerce_management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ECommerceJDBCTest {
//employee dao
    private ECommerceJDBC dao;

    @BeforeEach
    void setUp() {
        dao = new ECommerceJDBC();
    }
//search by customer eamil
    @Test
    void testSearchCustomerByEmail() {
        List<Customer> result = dao.searchCustomerByEmail("aarav@example.com");
        assertNotNull(result);
        assertFalse(result.isEmpty());

        Customer customer = result.get(0);
        assertEquals("aarav@example.com", customer.getEmail());
        assertNotNull(customer.getFullName());
        assertNotNull(customer.getPhone());
    }
//category search
    @Test
    void testGetProductsByCategory() {
        List<Product> products = dao.getProductsByCategory("Electronics");
        assertNotNull(products);
        assertFalse(products.isEmpty());

        for (Product p : products) {
            assertEquals("Electronics", p.getCategoryName());
            assertNotNull(p.getProductName());
            assertTrue(p.getStock() >= 0);
        }
    }
//check order
    @Test
    void testGetOrderDetails() {
        List<OrderDetail> orderDetails = dao.getOrderDetails();
        assertNotNull(orderDetails);
        assertFalse(orderDetails.isEmpty());

        for (OrderDetail od : orderDetails) {
            assertNotNull(od.getCustomerName());
            assertNotNull(od.getProductName());
            assertTrue(od.getQuantity() > 0);
            assertTrue(od.getPrice() > 0);
        }
    }
//test recent order
    @Test
    void testGetRecentOrders() {
        List<OrderSummary> recentOrders = dao.getRecentOrders();
        assertNotNull(recentOrders);

        for (OrderSummary o : recentOrders) {
            assertTrue(o.getTotalSpent() >= 0);
            assertTrue(o.getCategoriesBought() >= 0);
            assertNotNull(o.getFullName());
        }
    }
//customer top
    @Test
    void testGetTopCustomers() {
        List<OrderSummary> topCustomers = dao.getTopCustomers();
        assertNotNull(topCustomers);

        for (OrderSummary o : topCustomers) {
            assertTrue(o.getTotalSpent() >= 0);
            assertTrue(o.getCategoriesBought() >= 3);
            assertNotNull(o.getFullName());
        }
    }
}
