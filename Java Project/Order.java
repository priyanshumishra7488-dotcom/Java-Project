
public class Order {

    FoodItem[] items;      // items added to the order
    int[] quantities;      // quantity of each item
    int orderCount;        // how many different items are added

    double subtotal;
    double deliveryCharge;
    double tax;
    double total;

    // Constructor - set max order size
    public Order(int maxItems) {
        items = new FoodItem[maxItems];
        quantities = new int[maxItems];
        orderCount = 0;
        subtotal = 0;
        deliveryCharge = 0;
        tax = 0;
        total = 0;
    }

    // Add a food item with quantity to the order
    public void addItem(FoodItem item, int quantity) {
        if (orderCount < items.length) {
            items[orderCount] = item;
            quantities[orderCount] = quantity;
            orderCount++;
            System.out.println(item.getItemName() + " x" + quantity + " added to order.");
        } else {
            System.out.println("Order is full! Cannot add more items.");
        }
    }

    // Calculate the total bill with tax and delivery charge
    public double calculateTotal() {
        // Step 1: Calculate subtotal
        subtotal = 0;
        for (int i = 0; i < orderCount; i++) {
            subtotal += items[i].getPrice() * quantities[i];
        }

        // Step 2: Delivery charge - free if subtotal > 500, else Rs.50
        if (subtotal > 500) {
            deliveryCharge = 0;
        } else {
            deliveryCharge = 50;
        }

        // Step 3: Apply 5% GST on subtotal
        tax = subtotal * 0.05;

        // Step 4: Add everything up
        total = subtotal + deliveryCharge + tax;

        return total;
    }

    // Print the complete order summary
    public void printOrderSummary() {
        System.out.println("\n==============================");
        System.out.println("        ORDER SUMMARY         ");
        System.out.println("==============================");

        // Print each item with quantity and cost
        for (int i = 0; i < orderCount; i++) {
            double itemTotal = items[i].getPrice() * quantities[i];
            System.out.printf("%-18s x%d  = Rs.%.2f%n",
                    items[i].getItemName(), quantities[i], itemTotal);
        }

        System.out.println("------------------------------");
        System.out.printf("Subtotal          : Rs.%.2f%n", subtotal);
        System.out.printf("Delivery Charge   : Rs.%.2f%n", deliveryCharge);
        System.out.printf("Tax (5%% GST)      : Rs.%.2f%n", tax);
        System.out.println("------------------------------");
        System.out.printf("TOTAL AMOUNT      : Rs.%.2f%n", total);
        System.out.println("==============================");

        if (deliveryCharge == 0) {
            System.out.println("** Free delivery on this order! **");
        }
    }
}
