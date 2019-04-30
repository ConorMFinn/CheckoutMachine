import java.util.ArrayList;
public class CheckoutMachine {
    private int machineID;
    private ArrayList<Product> items;
    private int subTotal;
    private Inventory inventory;

    public CheckoutMachine(int id) {
        machineID = id;
        items = new ArrayList<>();
    }

    public boolean scanBarcode(String barcode) {

    }

    public int getMachineID() {
        return machineID;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public int getSubTotal() {
        return subTotal;
    }
}
