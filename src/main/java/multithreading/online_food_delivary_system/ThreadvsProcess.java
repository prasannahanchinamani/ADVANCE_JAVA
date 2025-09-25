package multithreading.online_food_delivary_system;

public class ThreadvsProcess {
    public static void main(String[] args) throws InterruptedException {
        long start, end;

        // Sample order
        Order burger = Food_Menu.getOrder(0); // Burger

        // 1️ Sequential execution
        System.out.println("=== Sequential Execution ===");
        start = System.currentTimeMillis();
        Food_Menu.showMenu(); // Make sure this method exists
        Calculating_discount.calculatingdiscount(burger);
        end = System.currentTimeMillis();
        System.out.println("Sequential execution time: " + (end - start) + " ms\n");

        // 2 Parallel execution using threads
        System.out.println("=== Parallel Execution ===");
        Thread menuThread = new Thread(Food_Menu::showMenu);
        Thread discountThread = new Thread(() -> Calculating_discount.calculatingdiscount(burger));

        start = System.currentTimeMillis();
        menuThread.start();
        discountThread.start();

        // Wait for both threads
        menuThread.join();
        discountThread.join();

        end = System.currentTimeMillis();
        System.out.println("Parallel execution time: " + (end - start) + " ms");
    }
}
