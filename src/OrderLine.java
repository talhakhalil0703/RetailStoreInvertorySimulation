/**
 * OrderLine contains a single order of an item, with its name quantity and the suppliers name to which to order from
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */
public class OrderLine {

    /**
     *  Name of the item to order
     */
    private String itemToOrderName;
    /**
     * Quantity of the item to order
     */
    private int quantity;
    /**
     * Name of the supplier from whom to Order the item from
     */
    private String itemSupplier;

    /**
     * Constructor for the Orderline
     * @param itemToOrderName Name of item to order
     * @param quantity quantity of item to order
     * @param itemSupplier name of the supplier from whom to order from
     */
    public OrderLine(String itemToOrderName, int quantity, String itemSupplier) {
        this.itemToOrderName = itemToOrderName;
        this.quantity = quantity;
        this.itemSupplier = itemSupplier;
    }

    /**
     * Get item name
     * @return string of item name for the order
     */
    public String getItemToOrderName() {
        return itemToOrderName;
    }

    /**
     * Get quantity of item
     * @return integer of item quantity to order
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the name of the Supplier of the item
     * @return String of supplier name
     */
    public String getItemSupplier() {
        return itemSupplier;
    }


    /**
     *
     * {@inheritDoc}
     */

    @Override
    public String toString(){
        String S = "Item description: " + getItemToOrderName();
        S += "\n" + "Amount ordered: " + getQuantity();
        S += "\n" + "Supplier: " + getItemSupplier() + "\n";
        return S;
    }

}

