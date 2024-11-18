import java.io.Serializable;
import java.util.LinkedList;
import java.util.Iterator;

public class Product implements Serializable {
    private static final long serialVersionUID = 2L;
    private int productID;
    private String productName;
    private String description;
    private double price;
    private int stockQuantity;
    private LinkedList<Waitlist> waitlist;

    public Product(int productID, String productName, String description, double price, int stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.waitlist = new LinkedList<>();
    }

    // Check if enough stock is available
    public boolean isAvailable(int quantity) {
        return stockQuantity >= quantity;
    }

    // Reduce stock quantity and return success status
    public boolean reduceStock(int quantity) {
        if (isAvailable(quantity)) {
            stockQuantity -= quantity; // Reduce stock
            return true; // Successful reduction
        } else {
            System.out.println("Not enough stock for " + productName + ". Requested: " + quantity + ", Available: " + stockQuantity);
            return false; // Not enough stock
        }
    }

    // Add an order to the waitlist
    public void addToWaitlist(Client client, int quantity) {
        int clientID = client.getClientID();
        waitlist.add(new Waitlist(clientID, quantity));
        System.out.println("Added to waitlist: Client " + client.getName() + ", Product " + productName + ", Quantity: " + quantity);
    }

    // Generate invoice details
    public String generateInvoiceString(int quantity) {
        double cost = quantity * price;
        return "Product: " + productName + ", Quantity: " + quantity + ", Unit Price: $" + price + ", Total Cost: $" + cost;
    }

    // Stock update method that also processes the waitlist
    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
        System.out.println("Stock updated for " + productName + ". New stock: " + stockQuantity);
        //processWaitlist();
    }

    // Getter methods
    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice(){
        return price;
    }

    public LinkedList<Waitlist> getWaitlist(){
        return waitlist;
    }

    public void printWaitlist() {
        if (waitlist.isEmpty()) {
            System.out.println("The waitlist for " + productName + " is currently empty.");
            return;
        }
    
        System.out.println("Waitlist for product: " + productName);
        for (Waitlist entry : waitlist) {
            System.out.println("Client ID: " + entry.getClientID() + ", Quantity: " + entry.getQuantity());
        }
    }

    public String getProductDetails() {
        return "Product ID: " + productID +
               " Product Name: " + productName +
               " Description: " + description +
               " Price: $" + price +
               " Stock Quantity: " + stockQuantity + "\n";
    }
}
