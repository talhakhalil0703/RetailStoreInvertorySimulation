import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileManager {

    ArrayList<Supplier> suppliers;

    public ArrayList<Item> readItems(){
        ArrayList<Item> items = new ArrayList<Item>();

        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/items.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while((line = br.readLine()) != null){
                String [] temp =  line.split(";");
                int supplierID = Integer.parseInt(temp[4]);

                Supplier theSupplier = findSupplier(supplierID);
                if(theSupplier != null){
                    Item myItem = new Item(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3]), theSupplier);
                    items.add(myItem);
                    theSupplier.getItemList().add(myItem);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return items;
    }

    private Supplier findSupplier(int ID){
        Supplier theSupplier = null;
        for (Supplier s: suppliers){
            if(s.getSupplierID() == ID){
                theSupplier = s;
                break;
            }
        }
        return theSupplier;
    }

    public ArrayList<Supplier> readSuppliers(){
       suppliers = new ArrayList<Supplier>();

        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/suppliers.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while((line = br.readLine()) != null){
                String [] temp =  line.split(";");
                suppliers.add(new Supplier(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return suppliers;
    }

}
