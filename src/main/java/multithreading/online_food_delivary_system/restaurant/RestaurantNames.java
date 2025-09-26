package multithreading.online_food_delivary_system.restaurant;

public class RestaurantNames {
    public static final String[] names = {"Nalanda", "MuttannatenttHouse", "Udupi", "Swadista Ahara"};

    static void dislay() {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
    }

    static String getRestaurant(int number) {
        if (number < 0 || number >= names.length) {
            throw new IllegalArgumentException("Invalid restaurant number: " + (number + 1));
        }
        return names[number];
    }
}
