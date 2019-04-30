import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> productList;
    private HashMap<String, Integer> inventory;

    public Inventory() {
        productList = new HashMap<>();
        inventory = new HashMap<>();
    }

    public boolean addNewProduct(String barcode, String name, double price) {
        if (productList.containsKey(barcode)) {
            return false;
        }
        productList.put(barcode, new Product(barcode, name, price));
        inventory.put(barcode, 0);
        return true;
    }

    public boolean removeProduct(String barcode) {
        if (productList.containsKey(barcode)) {
            productList.remove(barcode);
            inventory.remove(barcode);
            return true;
        } else {
            return false;
        }
    }

    public void addStock(String barcode, int amount) {
        inventory.replace(barcode, inventory.get(barcode) + amount);
    }

    public void removeStock(String barcode, int amount) {
        int inInv = inventory.get(barcode);
        if(amount > inInv) {
            System.err.println("Item with barcode " +barcode+ "has sold more than was in the inventory. Do stock check.");
            inventory.replace(barcode, 0);
        } else {
            inventory.replace(barcode, inInv - amount);
        }
    }
}
