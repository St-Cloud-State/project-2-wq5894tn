import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private int orderID; // Unique identifier for the order
    private int clientID; // ID of the client who placed the order
    private HashMap<Integer, Integer> orderItems; // Map of productID to quantity

    public Order(int orderID, int clientID, HashMap<Integer, Integer> orderItems) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.orderItems = orderItems;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public HashMap<Integer, Integer> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Client ID: " + clientID + ", Items: " + orderItems.toString() + "\n";
    }
}
