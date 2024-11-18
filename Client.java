import java.util.*;
import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private int clientID;
    private String name;
    private String address;
    private String contact;
    private List<Order> orders = new LinkedList<>();         // Save Order with String
    private List<String> transactions = new LinkedList<>();   // Save Transaction with String
    private Wishlist wishlist; // Wishlist for the client
    private double creditAccount; // Credit account balance
    private double debitAccount;  // Debit account balance

    // Constructor
    public Client(int clientID, String name, String address, String contact) {
        this.clientID = clientID;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.wishlist = new Wishlist(String.valueOf(clientID)); // Initialize wishlist with clientID
        this.creditAccount = 0.0; // Default balance
        this.debitAccount = 0.0;  // Default balance
    }

    // Getter and Setter for creditAccount
    public double getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(double creditAccount) {
        this.creditAccount = creditAccount;
    }

    // Getter and Setter for debitAccount
    public double getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(double debitAccount) {
        this.debitAccount = debitAccount;
    }

    // Method to create a new order for the client
    public void createOrder(Order orderDetails) {
        orders.add(orderDetails);
    }

    // Method to view all orders placed by the client
    public void viewOrders() {
        System.out.println("Orders placed by the client:");
        if (orders.isEmpty()) {
        System.out.println("No orders found.");
        } else {
            for (Order order : orders) {
                System.out.println(order.toString()); // Calls the toString method for each order
            }
        }
    }

    // Method to create a new transaction for the client
    public void createTransaction(String transactionDetails) {
        transactions.add(transactionDetails);  // Add transaction details as a string
    }

    // Method to view transaction history for the client
    public Iterator<String> viewTransactions() {
        return transactions.iterator();  // Returns the transactions as strings
    }

    // Wishlist interaction methods

    // Add product to wishlist
    public boolean addProductToWishlist(int productID, int quantity) {
        return wishlist.addProduct(productID, quantity);
    }

    // Remove product from wishlist
    public boolean removeProductFromWishlist(int productID) {
        return wishlist.removeProduct(productID);
    }

    // Check if a product exists in the wishlist
    public void printWishlist() {
         wishlist.printWishlist();
    }

    // Update product quantity in the wishlist
    public boolean updateProductQuantityInWishlist(int productID, int quantity) {
        return wishlist.updateProductQuantity(productID, quantity);
    }

    // Print all products in the wishlist
    public void viewWishlist() {
        wishlist.printWishlist();
    }

    // Getters for client attributes
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public int getClientID() {
        return clientID;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Wishlist getWishlist(){
        return wishlist;
    }

    // Setters for client attributes
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void clearWishlist() {
        wishlist.clearWishlist(); // Calls the clear method in Wishlist
    }

    @Override
    public String toString() {
        return "ClientID: " + clientID + ", Name: " + name + ", Address: " + address + ", Contact: " + contact +
               ", Credit Account: " + creditAccount + ", Debit Account: " + debitAccount;
    }
}
