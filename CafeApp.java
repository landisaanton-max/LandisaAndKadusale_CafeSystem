/**
 * Main application for the Campus Cafe Ordering System.
 *
 * @author Anton Miguel Landisa
 * @version 1.0
 */
public class CafeApp {

    /**
     * Main method - starts the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // STEP 1: Create customers
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        // STEP 2: Create menu items
        Beverage latte = new Beverage(
            "Iced Latte", 95, "B-01", "L");

        Pastry ensaymada = new Pastry(
            "Ensaymada", 45, "P-01", true);

        Meal adobo = new Meal(
            "Chicken Adobo", 110, "M-01", true, 1);

        // STEP 3: Create default beverage
        Beverage chocolate = new Beverage();
        chocolate.setName("Hot Chocolate");
        chocolate.setBasePrice(80);
        chocolate.setItemCode("B-02");
        chocolate.setSize("M");

        // STEP 4: Create default pastry
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(30);
        cookie.setItemCode("P-02");

        // STEP 5: Create default meal
        Meal tapa = new Meal();
        tapa.setName("Beef Tapa");
        tapa.setBasePrice(130);
        tapa.setItemCode("M-02");
        tapa.setUpsized(false);
        tapa.setExtraSides(0);

        // STEP 6: Test invalid price
        chocolate.setBasePrice(-5);

        // STEP 7: Create first order
        Order order1 = new Order("1001", customer1);

        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);

        // Try adding a fourth item
        order1.addItem(cookie);

        // STEP 8: Print first receipt
        order1.printReceipt();

        // STEP 9: Create second order
        Order order2 = new Order("1002", customer2);

        order2.addItem(chocolate);
        order2.addItem(tapa);

        // STEP 10: Print second receipt with voucher
        order2.printReceipt(20);
    }
}
