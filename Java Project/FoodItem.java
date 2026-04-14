
public class FoodItem {

    // item name and price
    String itemName;
    double price;

    // Constructor to set item name and price
    public FoodItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    // Returns the name of the item
    public String getItemName() {
        return itemName;
    }

    // Returns the price of the item
    public double getPrice() {
        return price;
    }
}
