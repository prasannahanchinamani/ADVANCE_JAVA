package jdbc_demo.e_commerce_management;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int stock;
    private String categoryName;

    public Product(int productId, String productName, double price, int stock, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.categoryName = categoryName;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoryName() {
        return categoryName;
    }
}