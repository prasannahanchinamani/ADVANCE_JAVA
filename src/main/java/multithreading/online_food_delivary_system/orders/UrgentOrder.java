package multithreading.online_food_delivary_system.orders;

import java.util.Scanner;

public class UrgentOrder {
    public static boolean checkUrgency(Order order, Scanner sc) {
        String input = sc.next();
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }
}
