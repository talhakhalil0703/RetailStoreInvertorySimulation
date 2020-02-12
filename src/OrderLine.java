public class OrderLine {

    private String itemToOrderName;
    private int quantity;
    private String itemSupplier;

    public OrderLine(String itemToOrderName, int quantity, String itemSupplier) {
        this.itemToOrderName = itemToOrderName;
        this.quantity = quantity;
        this.itemSupplier = itemSupplier;
    }

    public String getItemToOrderName() {
        return itemToOrderName;
    }

    public void setItemToOrderName(String itemToOrderName) {
        this.itemToOrderName = itemToOrderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(String itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    @Override
    public String toString(){
        String S = "Item description: " + getItemToOrderName();
        S += "\n" + "Amount ordered: " + getQuantity();
        S += "\n" + "Supplier: " + getItemSupplier();
        return S;
    }

}

