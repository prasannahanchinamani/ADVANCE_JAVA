package multithreading.online_food_delivary_system.restaurant;

public class RestaurantNames {
    public static final String[] names = {" 1.Nalanda", "2.MuttannatenttHouse", "3.Udupi", "3.Swadista Ahara"};

    static void dislay() {
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " ");
        }
    }

    static String getRestaurant(int number) {
        if (number == 0 || number > names.length)
            throw new IllegalArgumentException();
        for (int i = 1; i <= names.length; i++) {
            if (i == number)
                return names[i];
        }
        return null;
    }
}
