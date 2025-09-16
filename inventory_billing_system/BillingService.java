package inventory_billing_system;

import inventory_billing_system.discount.DiscountStrategy;
import inventory_billing_system.entities.Bill;
import inventory_billing_system.entities.Customer;
import inventory_billing_system.entities.Product;
import inventory_billing_system.exceptions.InsufficientStockException;
import inventory_billing_system.exceptions.ProductNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class BillingService {
    private final InventoryService inventoryService;

    public BillingService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Bill generateBill(Customer customer, Map<Integer, Integer> productIdToQty, DiscountStrategy discountStrategy) {
        Map<Product, Integer> items = new LinkedHashMap<>();
        double total = 0.0;
        for (Map.Entry<Integer, Integer> entry : productIdToQty.entrySet()) {
            int pid = entry.getKey();
            int qty = entry.getValue();
            Optional<Product> opt = inventoryService.findProductById(pid);
            if (!opt.isPresent()) throw new ProductNotFoundException("Product id " + pid + " not found");
            Product product = opt.get();
            if (product.getStockQuantity() < qty)
                throw new InsufficientStockException("Product id " + pid + " insufficient stock");
            items.put(product, qty);
            total += product.getPrice() * qty;
        }
        double discount = 0.0;
        if (discountStrategy != null) {
            discount = discountStrategy.apply(total);
            if (discount < 0) discount = 0.0;
            if (discount > total) discount = total;
        }
        double finalAmount = total - discount;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) entry.getKey().reduceStock(entry.getValue());
        return new Bill(customer, items, total, discount, finalAmount);
    }
}
