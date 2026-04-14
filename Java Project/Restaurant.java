
public class Restaurant {

    String name;
    FoodItem[] menu;
    int menuCount; // tracks how many items are in the menu

    // Constructor - creates a restaurant with a name and max menu size
    public Restaurant(String name, int maxItems) {
        this.name = name;
        this.menu = new FoodItem[maxItems];
        this.menuCount = 0;
    }

    // Adds a food item to the menu
    public void addMenuItem(FoodItem item) {
        if (menuCount < menu.length) {
            menu[menuCount] = item;
            menuCount++;
        } else {
            System.out.println("Menu is full! Cannot add more items.");
        }
    }

    // Returns restaurant name
    public String getName() {
        return name;
    }

    // Returns the menu array
    public FoodItem[] getMenu() {
        return menu;
    }

    // Returns how many items are in the menu
    public int getMenuCount() {
        return menuCount;
    }

    // Displays all menu items with index numbers and prices
    public void displayMenu() {
        System.out.println("\n=============================");
        System.out.println("  Restaurant: " + name);
        System.out.println("=============================");
        System.out.println("No.  Item Name          Price");
        System.out.println("-----------------------------");
        for (int i = 0; i < menuCount; i++) {
            // Print item number, name and price nicely
            System.out.printf("%-4d %-18s Rs.%.2f%n", (i + 1), menu[i].getItemName(), menu[i].getPrice());
        }
        System.out.println("=============================");
    }
}
