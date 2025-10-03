package jdbc_demo.e_commerce_management;

public class OrderSummary {
    private int customerId;
    private String fullName;
    private double totalSpent;
    private int categoriesBought;

    public OrderSummary(int customerId, String fullName, double totalSpent, int categoriesBought) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.totalSpent = totalSpent;
        this.categoriesBought = categoriesBought;
    }

    // Getters
    public int getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public double getTotalSpent() { return totalSpent; }
    public int getCategoriesBought() { return categoriesBought; }
}
