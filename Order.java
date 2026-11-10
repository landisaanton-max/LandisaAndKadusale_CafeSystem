/**
 * Represents a customer order in the cafe.
 *
 * @author Anton Miguel Landisa
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private boolean pointsAwarded;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
        pointsAwarded = false;
    }

    public boolean addItem(MenuItem item) {

        if (item == null) {
            System.out.println("Invalid item.");
            return false;
        } else if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add "
                    + item.getDescription() + ".");
            return false;
        }

        itemCount++;
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        } else {
            return subtotal;
        }
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();

        if (voucher > 0) {
            total -= voucher;
        }

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void printReceipt() {
        printReceipt(0);
    }

    public void printReceipt(double voucher) {

        double subtotal = computeSubtotal();
        double total = computeTotal(voucher);
        double discount = 0;

        if (customer.isStudent()) {
            discount = subtotal * 0.10;
        }

        System.out.println("\nOrder #" + orderId + " — "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) {
            System.out.printf("%-35s %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%-35s %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%-35s %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (discount > 0) {
            System.out.printf("Student discount (10%%): -%.2f%n",
                    discount);
        }

        if (voucher > 0) {
            System.out.printf("Voucher: -%.2f%n", voucher);
        }

        System.out.printf("TOTAL: %.2f%n", total);

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }
}
