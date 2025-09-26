package multithreading.online_food_delivary_system.discount;

import multithreading.online_food_delivary_system.orders.Order;

public class Calculating_discount {
    public static Double calculatingdiscount(Order order) {
        System.out.println("Calculating discount for " + order.getName());
        System.out.println("Original Price: " + order.getPrice());
        System.out.println("Discount: " + order.getDiscount() + "%");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        double discountedPrice = order.getPrice() - (order.getPrice() * order.getDiscount() / 100);
        System.out.println("Final Price after discount: " + discountedPrice);
        System.out.println("Thank You! Visit again");
        return discountedPrice;
    }
}
