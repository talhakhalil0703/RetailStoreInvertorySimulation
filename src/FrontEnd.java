import java.util.ArrayList;

import java.util.Scanner;

/**
 * The main class that runs the Front End of the program and contains the main loop to keep the menu running, is used to interact with the backend of the shop
 *
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */

public class FrontEnd {
    /**
     * An object of Shop used to call the backend functions
     */
    private Shop theShop;
    /**
     * An object of Scanner to get the user input
     */
    private Scanner scan;

    /**
     * Constructor for the FrontEnd class, reads the files items and suppliers, and then creates an object of shop
     */
    public FrontEnd() {
        FileManager FM = new FileManager();
        ArrayList<Supplier> suppliers = FM.readSuppliers();
        ArrayList<Item> items = FM.readItems();
        theShop = new Shop(new Inventory(items), new SupplierList(suppliers));
        scan = new Scanner(System.in);
    }

    /**
     * Menu for the console, through which the user interacts with, only prints out the options to choose from
     */
    private void printMenu() {
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

    /**
     * Calls the printMenu function to show the options, and then handles the input for the menu and calls the corresponding functions.
     * Has a loop which keeps interacting with the menu until the user chooses to Quit.
     */
    public void menu() {
        while (true) {
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
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

    /**
     * Prints today's Order and writes it to a file labeled Order.txt
     */
    private void printOrder() {
        theShop.printOrder();
    }

    /**
     * Prompts the user for the name of the item, and then decreases its quantity if it exists, and has more than 0, if the quantity is less than 50 creates and order for it
     */
    private void decreaseItem() {
        String itemName = this.getItemName();
        theShop.decreaseItem(itemName);
    }

    /**
     * Checks the quantity for all items in inventory to see if their stock is less than 50, if it is creates an Order for them, and displays the Orderline
     */
    private void checkItemQuantity() {
        theShop.getItemQuantity();
    }

    /**
     * Prompts the user for the Item name
     *
     * @return the item name submitted by the user
     */
    private String getItemName() {
        System.out.println();
        System.out.print("What is the name of the item? : ");
        String line = scan.nextLine();
        return line;
    }

    /**
     * Prompts the user for the Item ID
     *
     * @return the item ID submitted by the user
     */
    private int getItemID() {
        System.out.print("What is the ID of the item? : ");
        int ID = scan.nextInt();
        return ID;
    }

    /**
     * Searches for the item through inventory using the items ID
     */
    private void searchForItemByID() {
        int ID = this.getItemID();
        System.out.println(theShop.getItem(ID));
        System.out.println();
    }

    /**
     * Searches for the item through inventory using the items name
     */
    private void searchForItemByName() {
        String name = this.getItemName();
        System.out.println(theShop.getItem(name));
        System.out.println();
    }

    /**
     * The main function for the FrontEnd class, creates an object of FrontEnd and launches the menu function
     *
     * @param args Does not take any arugments from the console
     */
    public static void main(String[] args) {
        FrontEnd front = new FrontEnd();
        front.menu();
    }
}

