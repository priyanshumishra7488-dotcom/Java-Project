
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // --- Setup Restaurant and Menu ---

        Restaurant restaurant = new Restaurant("Hungry Hub", 10);

        // Adding food items to the menu
        restaurant.addMenuItem(new FoodItem("Burger", 100));
        restaurant.addMenuItem(new FoodItem("Pizza", 300));
        restaurant.addMenuItem(new FoodItem("Pasta", 180));
        restaurant.addMenuItem(new FoodItem("French Fries", 80));
        restaurant.addMenuItem(new FoodItem("Cold Drink", 50));
        restaurant.addMenuItem(new FoodItem("Paneer Roll", 120));
        restaurant.addMenuItem(new FoodItem("Noodles", 140));
        restaurant.addMenuItem(new FoodItem("Ice Cream", 70));

        // Create an order (max 10 different items)
        Order myOrder = new Order(10);

        System.out.println("====================================");
        System.out.println("  Welcome to Online Food Delivery!  ");
        System.out.println("====================================");

        // Show the menu to the user
        restaurant.displayMenu();

        // --- Take User Input ---

        System.out.println("\nHow many different items do you want to order?");
        int numItems = sc.nextInt();

        for (int i = 0; i < numItems; i++) {
            System.out.println("\nEnter item number (1 to " + restaurant.getMenuCount() + "): ");
            int choice = sc.nextInt();

            // Validate choice
            if (choice < 1 || choice > restaurant.getMenuCount()) {
                System.out.println("Invalid choice! Skipping this item.");
                continue;
            }

            System.out.println("Enter quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("Quantity must be at least 1. Skipping.");
                continue;
            }

            // Add item to order (choice - 1 because array starts at 0)
            FoodItem selectedItem = restaurant.getMenu()[choice - 1];
            myOrder.addItem(selectedItem, qty);
        }

        // --- Calculate and Show Bill ---

        if (myOrder.orderCount == 0) {
            System.out.println("\nNo items in your order. Exiting.");
        } else {
            myOrder.calculateTotal();
            myOrder.printOrderSummary();
        }

        System.out.println("\nThank you for ordering! Have a great day :)");
        sc.close();
    }
}
