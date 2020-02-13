/**
 * Class of Item which holds all the attributes of an item
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */
public class Item {
    /**
     * The ID of the item
     */
    private int itemID;
    /**
     * The name of the item
     */
    private String itemName;
    /**
     * The quantity of the item in stock
     */
    private int itemQuantity;
    /**
     * The price of the item
     */
    private double itemPrice;
    /**
     * If the item has already been placed for Order
     */
    private boolean alreadyOrdered = false;
    /**
     * Supplier of the Item
     */
    private Supplier theSupplier;
    /**
     * OrderLine of the item
     */
    private OrderLine orderLine = null;
    /**
     * Minimum amount of quantity of the item before an OrderLine is made
     */
    private static final int ORDERMAX = 50;

    /**
     * Constructor for the item
     * @param itemID Id of the item
     * @param itemName name of the item
     * @param itemQuantity quantity of the item
     * @param itemPrice price of the item
     * @param theSupplier supplier of the item
     */
    public Item(int itemID, String itemName, int itemQuantity, double itemPrice, Supplier theSupplier) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.theSupplier = theSupplier;
    }

    /**
     * Decreases the item quantity by 1 if greater than 0, and calls generateOrderLine
     * @return OrderLine if quantity less than 50, else null
     */
    public OrderLine decreaseItemQuantity() {

        if (this.itemQuantity > 0)
            itemQuantity -= 1;

        return  generateOrderLine();
    }

    /**
     *Generates an OrderLine if the item quantity is less than 50
     * @return OrderLine
     */
    public OrderLine generateOrderLine() {
        if (this.itemQuantity < ORDERMAX) {
            if (!alreadyOrdered) {
                orderLine = new OrderLine(itemName, ORDERMAX - itemQuantity, theSupplier.getSupplierName());
                System.out.println(orderLine);
                alreadyOrdered = true;
                return orderLine;
            }
        }

        return orderLine;
    }

    /**
     * Gets the itemID
     * @return integer of the ID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Gets the itemName
     * @return String of the item Name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets the OrderLine
     * @return OrderLine
     */
    public OrderLine getOrderLine() {
        return orderLine;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Item Id: " + String.valueOf(itemID) + ", Item Name: " + String.valueOf(itemName) + ", Item Quantity: " + String.valueOf(itemQuantity);
    }
}

