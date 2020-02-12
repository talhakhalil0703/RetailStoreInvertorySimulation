public class Item {
    private int itemID;
    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private boolean alreadyOrdered = false;
    private Supplier theSupplier;
    private OrderLine orderLine = null;
    private static final int ORDERMAX = 50;

    public Item(int itemID, String itemName, int itemQuantity, double itemPrice, Supplier theSupplier) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.theSupplier = theSupplier;
    }

    public OrderLine decreaseItemQuantity() {

        if (this.itemQuantity > 0)
            itemQuantity -= 1;

        return  generateOrderLine();
    }

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

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        generateOrderLine();
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    @Override
    public String toString() {
        return "Item Id: " + String.valueOf(itemID) + ", Item Name: " + String.valueOf(itemName) + ", Item Quantity: " + String.valueOf(itemQuantity);
    }


}

