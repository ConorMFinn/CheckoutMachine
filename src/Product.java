public class Product {
    private String barcode;
    private String name;
    private double price;

    public Product(String b, String n, double p) {
        barcode = b;
        name = n;
        price = p;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
