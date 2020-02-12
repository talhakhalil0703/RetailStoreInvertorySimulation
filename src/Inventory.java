import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> itemList;
    private Order myOrder;

    public Inventory(ArrayList<Item> itemList) {
        this.itemList = itemList;
        myOrder = new Order();
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public boolean manageItem(String itemName){
        Item I = searchForItem(itemName);
        if (I.decreaseItemQuantity() == null) {
           return false;
        }
        return true;
    }

    private boolean decreaseItem(String itemName){
        boolean ret = false;

        for (Item I: itemList){
            if(I.getItemName().equals(itemName)){
                I.decreaseItemQuantity();
                ret = true;
                break;
            }
        }

        return ret;
    }

    public Item searchForItem(String itemName){
        for (Item I: itemList){
            if(I.getItemName().equals(itemName)){
                return I;
            }
        }

        return null;
    }

    public Item searchForItem(int itemID){
        for (Item I: itemList){
            if(I.getItemID() == itemID){
                return I;
            }
        }
        return null;
    }

    public void getItemQuantity(){
        System.out.println();
        for (Item I: itemList){
            if (I.generateOrderLine() != null)
                myOrder.addOrderLines(I.getOrderLine());
        }
    }
    public void printItems(){
        System.out.println("---------------------------------");
        for (Item I: itemList){
            System.out.println(I);
        }
        System.out.println("---------------------------------");
        System.out.println("Those are all the items in the Inventory!");
        System.out.println();
    }

    public void printOrder(){
        System.out.println(myOrder);
    }

}

