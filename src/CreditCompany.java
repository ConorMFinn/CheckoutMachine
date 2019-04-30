import java.util.Random;

/**
 * Mock representation of a credit company.
 * Denies requests 25% of the time.
 */
public class CreditCompany {
    private String name;

    public CreditCompany(String n) {
        name = n;
    }

    public boolean requestPayment(String cardNo, double amount) {
        Random r = new Random();
        if(r.nextInt(4) == 0) {
            return false;
        } else {
            return true;
        }
    }

}
