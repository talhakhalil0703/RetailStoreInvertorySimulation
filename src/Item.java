public class Item {
    private int itemID;
    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private boolean alreadyOrdered;
    private Supplier theSupplier;
    private static final int ORDERMAX = 40;
    private static final int MINIMUMORDER = 20;

    public Item(int itemID, String itemName, int itemQuantity, double itemPrice, Supplier theSupplier){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.theSupplier = theSupplier;
    }

//    public boolean decreaseItemQuantity(){
//        return false;
//    }
//
//    public OrderLine generateOrderLine(){
//
//    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString(){
        return "Item Id: " +  String.valueOf(itemID)  + ", Item Name: " + String.valueOf(itemName) + ", Item Quantity: " + String.valueOf(itemQuantity);
    }


}

