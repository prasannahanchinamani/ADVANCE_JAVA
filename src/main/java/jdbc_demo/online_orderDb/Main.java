package jdbc_demo.online_orderDb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OnlineOrderOp orderOp = new OnlineOrderOp();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Online Order System Menu ===");
            System.out.println("1. Insert New Order");
            System.out.println("2. Fetch Order History");
            System.out.println("3. Show Top 3 Customers");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Customer ID: ");
                    int customerId = sc.nextInt();
                    System.out.print("Order Amount: ");
                    double amount = sc.nextDouble();
                    orderOp.insertOrder(customerId, amount);
                }
                case 2 -> {
                    System.out.print("Customer ID to fetch history: ");
                    int customerId = sc.nextInt();
                    orderOp.fetctchHistroy(customerId);
                }
                case 3 -> orderOp.topThre();
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
