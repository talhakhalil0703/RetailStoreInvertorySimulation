import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> itemList;
    private Order myOrder;

    public Inventory(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

//    public Item manageItem(String itemName){
//
//    }
//
//    public void placeOrder(Item item){
//
//    }
//
//    private Item decreaseItem(String itemName){
//
//    }
//
//    public int getItemQuantity(String itemName) {
//
//    }
//
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
//
//    public printOrder(String itemName){
//
//    }

    public void printItems(){
        System.out.println("---------------------------------");
        for (Item I: itemList){
            System.out.println(I);
        }
        System.out.println("---------------------------------");
        System.out.println("Those are all the items in the Inventory!");
        System.out.println();
    }


}

