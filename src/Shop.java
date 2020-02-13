import javax.annotation.processing.Filer;

public class Shop {


    private Inventory theInventory;
    private SupplierList theSuppliers;
    FileManager FM;

    public Shop(Inventory theInventory, SupplierList theSuppliers) {
        this.theInventory = theInventory;
        this.theSuppliers = theSuppliers;
        FM = new FileManager();
    }

    public void listAllItems() {
        theInventory.printItems();
    }

    public String getItem(String itemName) {
        Item i = theInventory.searchForItem(itemName);

        if (i == null)
            return "An Incorrect item name was entered!";
        else
            return i.toString();
    }

    public String getItem(int itemID) {
        Item i = theInventory.searchForItem(itemID);

        if (i == null)
            return "An Incorrect item ID was entered!";
        else
            return i.toString();
    }

    public void getItemQuantity() {
      theInventory.getItemQuantity();
    }

    public boolean decreaseItem(String itemName) {
        return theInventory.manageItem(itemName);
    }

    public void printOrder(){
        theInventory.printOrder();
        FM.writeOrder(theInventory.getOrder());
    }

}
