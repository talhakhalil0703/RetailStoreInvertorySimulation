import java.util.ArrayList;

/**
 * Inventory holds all the items and allows for functions pretaining to an item to be called
 *
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */

public class Inventory {

    /**
     * List of all the items in Inventory
     */
    private ArrayList<Item> itemList;
    /**
     * Order for items which have a quantity of less than 50
     */
    private Order myOrder;

    /**
     * Constructor for the Inventory, however to have an inventory an itemList must exist
     * @param itemList List of all items
     */
    public Inventory(ArrayList<Item> itemList) {
        this.itemList = itemList;
        myOrder = new Order();
    }

    /**
     * Returns the ArrayList of Items
     * @return ArrayList of Items
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * Sets the ArrayList of Items
     * @param itemList ArraList of Items
     */
    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     * Decreases item quantity by 1 if the name of the item can be found in inventory. If quantity is 0 or less, does not decrease, and orders more
     * If the quantity is less than 50 creates an Order for the Item
     * @param itemName Name of the item to decrease quantity of
     * @return True if the item quantity was decrease, false otherwise
     */
    public boolean manageItem(String itemName){
        Item I = searchForItem(itemName);

        if (I == null) {
            System.out.println("The item you searched for was not found! ");
            return false;
        }
        if (I.decreaseItemQuantity() == null )
            return false;

        return true;
    }

    /**
     * Search for an item given its name
     * @param itemName the name of the item to search for
     * @return an object of Item if found, else null
     */
    public Item searchForItem(String itemName){
        for (Item I: itemList){
            if(I.getItemName().equals(itemName)){
                return I;
            }
        }
        return null;
    }

    /**
     * Search for an item given its ID
     * @param itemID the id of the item to search for
     * @return an object of the Item if found, else null
     */
    public Item searchForItem(int itemID){
        for (Item I: itemList){
            if(I.getItemID() == itemID){
                return I;
            }
        }
        return null;
    }

    /**
     * Checks the quantity for all items in inventory to see if their stock is less than 50, if it is creates an Order for them, and displays the Orderline
     */
    public void getItemQuantity(){
        System.out.println();
        for (Item I: itemList){
            System.out.println("The following items have a quantity of less than 50, and need to be ordered:\n");
            if (I.generateOrderLine() != null)
                myOrder.addOrderLines(I.getOrderLine());
        }
    }

    /**
     * Prints out all the items in Inventory and their information
     */
    public void printItems(){
        System.out.println("---------------------------------");
        for (Item I: itemList){
            System.out.println(I);
        }
        System.out.println("---------------------------------");
        System.out.println("Those are all the items in the Inventory!");
        System.out.println();
    }

    /**
     * Prints the ORDER
     */
    public void printOrder(){
        System.out.println(myOrder);
    }

    /**
     * Gets the Order, which is to be used to write a text file of Order
     * @return Order
     */
    public Order getOrder(){
        return this.myOrder;
    }

}

