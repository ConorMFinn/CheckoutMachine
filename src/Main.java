public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addNewProduct("00000001", "Gala Apple Each", 0.35);
        inv.addNewProduct("00000002", "Pk. Banana", 0.5);
        inv.addNewProduct("00000003", "Chocolate Bar 500g", 2.50);
        inv.addStock("00000001", 10);
        inv.addStock("00000002", 10);
        inv.addStock("00000003", 2);
        new CheckoutMachine(1, inv).run();
    }
}
