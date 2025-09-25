package multithreading.online_food_delivary_system;

import java.util.ArrayList;
import java.util.List;

public class Food_Menu {
    private static final List<Order> menu = new ArrayList<>();

    static {
        menu.add(new Order("Burger", 100, 10));
        menu.add(new Order("Pizza", 250, 20));
        menu.add(new Order("Pasta", 150, 15));
        menu.add(new Order("Sandwich", 80, 5));
        menu.add(new Order("Salad", 50, 0));
    }

    public static void showMenu() {
        System.out.println("=== Food Menu ===");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public static Order getOrder(int index) {
        if (index >= 0 && index < menu.size()) {
            return menu.get(index);
        }
        return null;
    }

    public static List<Order> getMenu() {
        return menu;
    }
}
