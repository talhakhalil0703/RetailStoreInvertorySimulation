import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private ArrayList<OrderLine> orderLines;
    private String dateOrdered;
    private int orderID;

    public Order(){
        orderLines = new ArrayList<OrderLine>();
        dateOrdered = String.valueOf(Calendar.DAY_OF_MONTH) +"/" + String.valueOf(Calendar.MONTH) + "/"+ String.valueOf(Calendar.YEAR);
        orderID = (int)(Math.random()*99999);
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void addOrderLines(OrderLine orderLines) {
        this.orderLines.add(orderLines);
    }
    public String getDateOrdered() {
        return dateOrdered;
    }

    public double getOrderID() {
        return orderID;
    }

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
