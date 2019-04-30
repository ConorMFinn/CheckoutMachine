import java.util.HashMap;

public class Inventory {    // TODO singleton pattern application. getInstance() etc.
    private HashMap<String, Product> productList;
    private HashMap<String, Integer> inventory;


    /**
     * Constructor for Inventory objects.
     */
    public Inventory() {
        productList = new HashMap<>();
        inventory = new HashMap<>();
    }

    /**
     * Add a new product to the system.
     * @param barcode product barcode.
     * @param name product name
     * @param price product price in pounds.
     * @return true if successful.
     */
    public boolean addNewProduct(String barcode, String name, double price) {
        if (productList.containsKey(barcode)) {
            return false;
        }
        productList.put(barcode, new Product(barcode, name, price));
        inventory.put(barcode, 0);
        return true;
    }

    /**
     * Remove a product from the system.
     * @param barcode of product.
     * @return true if successful.
     */
    public boolean removeProduct(String barcode) {
        if (productList.containsKey(barcode)) {
            productList.remove(barcode);
            inventory.remove(barcode);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add stock to the inventory.
     * @param barcode Barcode of product.
     * @param amount Amount to add.
     */
    public void addStock(String barcode, int amount) {
        inventory.replace(barcode, inventory.get(barcode) + amount);
    }

    /**
     * Remove stock from inventory.
     * @param barcode barcode of product.
     * @param amount Amount to remove.
     */
    private void removeStock(String barcode, int amount) {
        int inInv = inventory.get(barcode);
        if(amount > inInv) {
            System.err.println("Item with barcode " +barcode+ "has sold more than was in the inventory. Do stock check.");
            inventory.replace(barcode, 0);
        } else {
            inventory.replace(barcode, inInv - amount);
        }
    }

    Product pullItem(String barcode) {
        Product p = productList.get(barcode);
        if(p == null) { return null; }
        else {
            removeStock(barcode, 1);
            return p;
        }
    }
}
