/**
 * Abstract parent class for all cafe menu items.
 *
 * @author Anton Miguel Landisa
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    public MenuItem(String name, double basePrice,
                    String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            System.out.println(
                "Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        }
    }
}
