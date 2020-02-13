import javax.annotation.processing.Filer;

/**
 * The Shop class which is the backend of the Shop and takes care of the shop inventory and has a list of the suppliers
 *
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */

public class Shop {

    /**
     * Inventory holds all the items and allows for functions pretaining to an item to be called
     */
    private Inventory theInventory;
    /**
     * A list of Suppliers
     */
    private SupplierList theSuppliers;
    FileManager FM;

    /**
     * Constructor for the Shop assigns, the inventory and supplier, while also creating an object for FileManager which is used to write the Order
     *
     * @param theInventory Inventory object
     * @param theSuppliers SupplierList object
     */
    public Shop(Inventory theInventory, SupplierList theSuppliers) {
        this.theInventory = theInventory;
        this.theSuppliers = theSuppliers;
        FM = new FileManager();
    }

    /**
     * Prints all the items in the Inventory
     */
    public void listAllItems() {
        theInventory.printItems();
    }

    /**
     * Finds an item using their Name and returns the items name, ID, quantity, and supplier, in the form of a String
     * Also makes sure the item is in the inventory
     *
     * @param itemName Name of the item to find
     * @return String which has the items name, ID, quantity, and supplier
     */
    public String getItem(String itemName) {
        Item i = theInventory.searchForItem(itemName);

        if (i == null)
            return "An Incorrect item name was entered!";
        else
            return i.toString();
    }

    /**
     * Finds an item using their ID and returns the items name, ID, quantity, and supplier, in the form of a String
     * Also makes sure the item is in the inventory
     *
     * @param itemID ID of the item to find
     * @return String which has the items name, ID, quantity, and supplier
     */
    public String getItem(int itemID) {
        Item i = theInventory.searchForItem(itemID);

        if (i == null)
            return "An Incorrect item ID was entered!";
        else
            return i.toString();
    }

    /**
     * Checks the quantity for all items in inventory to see if their stock is less than 50, if it is creates an Order for them, and displays the Orderline
     */
    public void getItemQuantity() {
        theInventory.getItemQuantity();
    }

    /**
     * Decreases items quantity if it exists, and has more than 0, if the quantity is less than 50 creates and order for it
     * @return true if decreased item quantity else false
     *
     */
    public boolean decreaseItem(String itemName) {
        return theInventory.manageItem(itemName);
    }

    /**
     * Prints out the Order on the console and writes it to a File called Order
     */
    public void printOrder() {
        theInventory.printOrder();
        FM.writeOrder(theInventory.getOrder());
    }

}
