import java.util.ArrayList;

import java.util.Scanner;

public class FrontEnd {
    private Shop theShop;
    private Scanner scan;

    public FrontEnd() {
        FileManager FM = new FileManager();
        ArrayList<Supplier> suppliers = FM.readSuppliers();
        ArrayList<Item> items = FM.readItems();
        theShop = new Shop(new Inventory(items), new SupplierList(suppliers));
        scan = new Scanner(System.in);
    }

    private void printMenu()
    {
        System.out.println("1. List all tools");
        System.out.println("2. Search for tool by toolName");
        System.out.println("3. Search for tool by toolID");
        System.out.println("4. Check item quantities and restock");
        System.out.println("5. Decrease item quantity");
        System.out.println("6. Print today's order and write to File");
        System.out.println("7. Quit");
        System.out.println();
        System.out.print("Please enter your selection: ");
    }

    public void menu() {
        while(true) {
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    theShop.listAllItems();
                    break;
                case 2:
                    this.searchForItemByName();
                    break;
                case 3:
                    this.searchForItemByID();
                    break;
                case 4:
                    this.checkItemQuantity();
                    break;
                case 5:
                    this.decreaseItem();
                    break;
                case 6:
                    this.printOrder();
                    break;
                case 7:
                    System.out.println("Thanks for using this shop system!");
                    return;
                default:
                    System.out.println("Wrong selection!");
                    break;
            }
        }
    }

    private void printOrder() {
        theShop.printOrder();
    }

    private void decreaseItem() {
        String itemName = this.getItemName();
        theShop.decreaseItem(itemName);
    }

    private void checkItemQuantity() {
        theShop.getItemQuantity();
    }

    private String getItemName() {
        System.out.println();
        System.out.print("What is the name of the item? : ");
        String line = scan.nextLine();
        return  line;
    }

    private int getItemID() {
        System.out.print("What is the ID of the item? : ");
        int ID = scan.nextInt();
        return  ID;
    }

    private void searchForItemByID() {
        int ID = this.getItemID();
        System.out.println(theShop.getItem(ID));
        System.out.println();
    }

    private void searchForItemByName() {
        String name = this.getItemName();
        System.out.println(theShop.getItem(name));
        System.out.println();
    }

    public static void main(String[] args) {
        FrontEnd front = new FrontEnd();
        front.menu();
    }
}

