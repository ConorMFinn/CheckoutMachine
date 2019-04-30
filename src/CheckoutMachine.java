import java.util.ArrayList;
public class CheckoutMachine {
    private int machineID;
    private ArrayList<Product> items;
    private double subTotal;
    private Inventory inventory;

    public CheckoutMachine(int id) {
        machineID = id;
        items = new ArrayList<>();
    }

    public boolean scanBarcode(String barcode) {
        Product p = inventory.pullItem(barcode);
        if(p == null) {
            return false;
        }
        items.add(p);
        calculateSubTotal();
        return true;
    }

    private void calculateSubTotal() {
        double t = 0;
        for(Product p : items) {
            t += p.getPrice();
        }
        subTotal = t;
    }

    public int getMachineID() {
        return machineID;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public double getSubTotal() {
        return subTotal;
    }
}
