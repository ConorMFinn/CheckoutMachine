import java.util.ArrayList;
import java.util.Scanner;

public class CheckoutMachine {
    private int machineID;
    private ArrayList<Product> items;
    private double subTotal;
    private Inventory inventory;
    private Scanner scan = new Scanner(System.in);

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

    private void completePurchase() {
        System.out.println("Scan card.");
        String[] cardData = scan.next().split(" ");
        boolean response = new CreditCompany(cardData[1]).requestPayment(cardData[0], subTotal);
        if(response) {
            System.out.println("Payment Accepted. Please take your items.");
        } else {
            System.out.println("Payment Error. Please try again.");
            completePurchase();
        }
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
