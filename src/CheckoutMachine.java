import java.util.ArrayList;
import java.util.Scanner;

class CheckoutMachine {
    private int machineID;
    private ArrayList<Product> items;
    private double subTotal;
    private Inventory inventory;
    private Scanner scan = new Scanner(System.in);

    CheckoutMachine(int id, Inventory i) {
        machineID = id;
        items = new ArrayList<>();
        inventory = i;
    }

    void run() {
        boolean running = true;
        while(running) {
            System.out.println("Please scan an item.");
            String item = scan.nextLine();
            if (item.equals("MAKE_PAYMENT")) {
                if(items.size() == 0) { System.out.println("No items scanned."); }
                else { completePurchase(); }
            } else if (item.equals("EXIT_SYS")) {
                running = false;
            } else {
                if(scanBarcode(item)) {
                    printItems();
                } else {
                    System.out.println("Product not scanned. Please try again.");
                }
            }
        }
    }

    private boolean scanBarcode(String barcode) {
        Product p = inventory.pullItem(barcode);
        if(p == null) {
            return false;
        }
        items.add(p);
        calculateSubTotal();
        return true;
    }

    private void printItems() {
        for(Product p : items) {
            System.out.println(p.getName() + " : " + p.getPrice());
        }
        System.out.println("Subtotal: £" + subTotal);
    }

    private void completePurchase() {
        System.out.println("Scan card.");
        String[] cardData = scan.nextLine().split(" ");
        boolean response = new CreditCompany(cardData[1]).requestPayment(cardData[0], subTotal);
        if(response) {
            System.out.println("Payment Accepted. Please take your items.");
            subTotal = 0;
            items = new ArrayList<>();
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
}
