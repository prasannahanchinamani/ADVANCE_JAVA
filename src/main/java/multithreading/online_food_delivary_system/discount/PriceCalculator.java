package multithreading.online_food_delivary_system.discount;

import multithreading.online_food_delivary_system.orders.Order;

import java.util.concurrent.Callable;

public class PriceCalculator implements Callable<Double> {
    private final Order order;

    public PriceCalculator(Order order) {
        this.order = order;
    }

    @Override
    public Double call() throws Exception {
        System.out.println(order.getPrice() + " On " + order.getName());
        System.out.println("Discount:" + order.getDiscount());
        Thread.sleep(2000);
        double finalPrice = order.getPrice() - (order.getPrice() * order.getDiscount() / 100);
        System.out.println("Final price of " + order.getName() + " = " + finalPrice);
        return finalPrice;
    }
}
