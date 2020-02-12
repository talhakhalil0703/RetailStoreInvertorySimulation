import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private ArrayList<OrderLine> orderLines;
    private String dateOrdered;
    private double orderID;

    public Order(){
        orderLines = new ArrayList<OrderLine>();
        dateOrdered = String.valueOf(Calendar.DAY_OF_MONTH) +"/" + String.valueOf(Calendar.MONTH) + "/"+ String.valueOf(Calendar.YEAR);
        orderID = Math.random()*99999;
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
        String S = "Order ID: " + String.valueOf(orderID) + "\n";
        S += "Date Ordered: " + dateOrdered + "\n";
        for(OrderLine itemOrder : orderLines){
            S += itemOrder;
        }
        return S;
    }
}
