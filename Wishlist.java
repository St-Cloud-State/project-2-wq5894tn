import java.io.Serializable;
import java.util.HashMap;

public class Wishlist implements Serializable {
    private static final long serialVersionUID = 5L;
    private String clientID; // ID of the client who owns this wishlist
    private HashMap<Integer, Integer> wishlistItems; // Map of productID to desired quantity

    public Wishlist(String clientID) {
        this.clientID = clientID;
        this.wishlistItems = new HashMap<>();
    }

    // Add a product to the wishlist with the specified quantity
    public boolean addProduct(int productID, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return false;
        }

        // Update the quantity if the product already exists in the wishlist
        wishlistItems.put(productID, wishlistItems.getOrDefault(productID, 0) + quantity);
        System.out.println("Product added/updated in wishlist.");
        return true;
    }

    // Remove a product from the wishlist by product ID
    public boolean removeProduct(int productID) {
        if (wishlistItems.remove(productID) != null) {
            System.out.println("Product removed from wishlist.");
            return true;
        }
        System.out.println("Product not found in wishlist.");
        return false;
    }

    // Update product quantity in the wishlist
    public boolean updateProductQuantity(int productID, int quantity) {
        if (!wishlistItems.containsKey(productID)) {
            System.out.println("Product not found in wishlist.");
            return false;
        }
        wishlistItems.put(productID, quantity);
        System.out.println("Product quantity updated in wishlist.");
        return true;
    }

    // Print all products in the wishlist with their quantities
    public void printWishlist() {
        System.out.println("Wishlist for client ID: " + clientID);
        if (wishlistItems.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } else {
            for (var entry : wishlistItems.entrySet()) {
                System.out.println("Product ID: " + entry.getKey() + ", Desired Quantity: " + entry.getValue());
            }
        }
    }

    // Get total number of unique products in the wishlist
    public int getTotalProducts() {
        return wishlistItems.size();
    }

    // Getter for clientID
    public String getClientID() {
        return clientID;
    }

    public HashMap<Integer, Integer> getWishlistItems(){
        return wishlistItems;
    }

    public void clearWishlist() {
        wishlistItems.clear(); // Clear the HashMap
        System.out.println("Wishlist has been cleared.");
    }
}
