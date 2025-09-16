package inventory_billing_system;

import inventory_billing_system.entities.Product;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InventoryService {
    private static InventoryService instance;
    private final Map<Integer, Product> products = new ConcurrentHashMap<>();

    private InventoryService() {
    }

    public static synchronized InventoryService getInstance() {
        if (instance == null) instance = new InventoryService();
        return instance;
    }

    public synchronized void clearAll() {
        products.clear();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void removeProduct(int productId) {
        products.remove(productId);
    }

    public Optional<Product> findProductById(int id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> searchByName(String namePart) {
        return products.values().stream()
                .filter(p -> p.getName().toLowerCase().contains(namePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> searchByCategory(String category) {
        return products.values().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Collection<Product> allProducts() {
        return Collections.unmodifiableCollection(products.values());
    }
}
