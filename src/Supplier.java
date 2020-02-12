import java.util.ArrayList;

public class Supplier {
    private ArrayList<Item> itemList = new ArrayList<Item>();

    private int supplierID;
    private String supplierName;
    private String address;
    private String salesContact;

    public Supplier(int supplierID, String supplierName, String address, String salesContact) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.salesContact = salesContact;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

}
