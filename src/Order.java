import java.util.ArrayList;
import java.util.Date;

/**
 * Order holds all the OrderLines and has the current date stored
 * @author Talha Khalil
 * @version 1
 * @since February 12, 2020
 */
public class Order {
    /**
     * ArrayList of orderLines
     */

    private ArrayList<OrderLine> orderLines;
    /**
     * The date at which the Order is to be placed
     */
    private String dateOrdered;
    /**
     * Randomly generated orderID
     */
    private int orderID;

    /**
     * Constructor for Order which sets the Date, assigns the OrderLine list and creates a random OrderID
     */
    public Order(){
        orderLines = new ArrayList<OrderLine>();
        Date date =  new Date();
        dateOrdered = date.toString().substring(0,10);
        orderID = (int)(Math.random()*99999);
    }

    /**
     * Gets the OrderLines ArrayList
     * @return ArrayLisy of OrderLines
     */
    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Sets the OrderLines ArrayList
     * @param orderLines ArrayList of OrderLines
     */
    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    /**
     * Adds an OrderLine to OrderLines ArrayList
     * @param orderLines Orderline
     */
    public void addOrderLines(OrderLine orderLines) {
        this.orderLines.add(orderLines);
    }

    /**
     * Gets the Date the Order was placed
     * @return String of the Date
     */
    public String getDateOrdered() {
        return dateOrdered;
    }

    /**
     * Gets the Order ID
     * @return the integer value of the OrderID
     */
    public double getOrderID() {
        return orderID;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        if (orderLines.isEmpty()) {
            return "There is nothing to order as of right now, please check quantites";
        }
        String S = "**********************************************\n";
        S += "\nOrder ID: " + String.valueOf(orderID) + "\n";
        S += "Date Ordered: " + dateOrdered + "\n\n";
        for(OrderLine itemOrder : orderLines){
            S += itemOrder + "\n";
        }
        S += "**********************************************\n";
        return S;
    }
}
