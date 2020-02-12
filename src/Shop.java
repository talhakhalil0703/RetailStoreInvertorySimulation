public class Shop {
    private Inventory theInventory;
    private SupplierList theSuppliers;

    public Shop(Inventory theInventory, SupplierList theSuppliers){
        this.theInventory = theInventory;
        this.theSuppliers = theSuppliers;
    }

//    public Inventory getTheInventory(){
//
//    }
//
//    public void setTheInventory(Inventory theInventory) {
//
//    }

    public void listAllItems(){
        theInventory.printItems();
    }

    public String getItem(String itemName){
        Item i = theInventory.searchForItem(itemName);

        if (i == null)
            return "An Incorrect item name was entered!";
        else
            return i.toString();
    }

    public String getItem(int itemID){
        Item i = theInventory.searchForItem(itemID);

        if (i == null)
            return "An Incorrect item ID was entered!";
        else
            return i.toString();
    }

//    private String outputItem(Item item){
//
//    }

    public int getItemQuantity(String itemName){
        Item i = theInventory.searchForItem(itemName);

        if (i == null) {
            System.out.println("An Incorrect item name was entered!");
            return 0;
        }
        else
            return i.getItemQuantity();
    }
//
//    private void printOrder(){
//
//    }
    
}
