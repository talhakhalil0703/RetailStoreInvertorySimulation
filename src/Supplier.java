import java.util.ArrayList;

/**
 * Class of Supplier which contains all the atrributes pretaining to a Supplier
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */
public class Supplier {

    /**
     * List of items the Supplier distributes
     */
    private ArrayList<Item> itemList = new ArrayList<Item>();

    /**
     * Id of the Supplier
     */
    private int supplierID;
    /**
     * The name of the Supplier
     */
    private String supplierName;
    /**
     * The Address of the Supplier
     */
    private String address;
    /**
     * The name of the sales Contact person for the supplier
     */
    private String salesContact;

    /**
     * Constructor for the supplier
     * @param supplierID Id of the Supplier
     * @param supplierName Name of the Supplier
     * @param address Address of the Supplier
     * @param salesContact Name of the sales contact person for the supplier
     */
    public Supplier(int supplierID, String supplierName, String address, String salesContact) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.salesContact = salesContact;
    }

    /**
     * Gets the ItemList
     * @return ArrayList of Item
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * Gets the Supplier ID
     * @return integer of the supplier ID
     */
    public int getSupplierID() {
        return supplierID;
    }

    /**
     * Gets the name of the supplier
     * @return String name of the supplier
     */
    public String getSupplierName() {
        return supplierName;
    }

}
