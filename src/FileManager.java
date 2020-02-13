import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The FileManager class handles reading and writing to files
 *
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */

public class FileManager {

    /**
     * List of all the suppliers in which the read text of suppliers is compiled to
     */
    ArrayList<Supplier> suppliers;

    /**
     * Reads the items text and returns an ArrayList of items, which is stored into Inventory
     *
     * @return ArrayList of Item
     */
    public ArrayList<Item> readItems() {
        ArrayList<Item> items = new ArrayList<Item>();

        try {
            FileReader fileread = new FileReader(System.getProperty("user.dir") + "/items.txt");
            BufferedReader buffer = new BufferedReader(fileread);

            String line = "";
            while ((line = buffer.readLine()) != null) {
                String[] ss = line.split(";");
                int supplierID = Integer.parseInt(ss[4]);

                Supplier theSupplier = findSupplier(supplierID);
                if (theSupplier != null) {
                    int itemID = Integer.parseInt(ss[0]);
                    String name = ss[1];
                    int itemQuantity = Integer.parseInt(ss[2]);
                    double itemPrice = Double.parseDouble(ss[3]);

                    Item myItem = new Item(itemID, name, itemQuantity, itemPrice, theSupplier);
                    items.add(myItem);
                    theSupplier.getItemList().add(myItem);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    /**
     * Finds the Supplier object having the SupplierId, ID
     *
     * @param ID The ID of the Supplier object to find
     * @return The Supplier Object if a matching ID is found, else null
     */
    private Supplier findSupplier(int ID) {
        Supplier theSupplier = null;
        for (Supplier s : suppliers) {
            if (s.getSupplierID() == ID) {
                theSupplier = s;
                break;
            }
        }
        return theSupplier;
    }

    /**
     * Reads the suppliers text and returns an ArrayList of Supplier, which is assigned to suppliers
     *
     * @return ArrayList of Supplier which is stored in Shop
     */

    public ArrayList<Supplier> readSuppliers() {
        suppliers = new ArrayList<Supplier>();

        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "/suppliers.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                suppliers.add(new Supplier(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return suppliers;
    }

    /**
     * Writes the ORDER into a file called Order
     *
     * @param order The Order to which to write to the file
     */
    public void writeOrder(Order order) {
        if (order == null)
            return;

        try {
            File fileToWrite = new File("Order.txt");
            if (fileToWrite.createNewFile())
                System.out.println("Order text file created!");
            else
                System.out.println("Order text file already exists!");
        } catch (IOException e) {
            System.out.println("An error occured while trying to create Order file!");
        }

        try {
            FileWriter writeToFile = new FileWriter("Order.txt");
            writeToFile.write(order.toString());
            writeToFile.close();
        } catch (IOException e) {
            System.out.println("Could not write to Order file");
        }

    }
}
