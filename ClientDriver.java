

public class ClientDriver {
    public static void main(String[] args) {
        // Create a ClientList to manage clients
        ClientList clientList = new ClientList();

        // Create some clients
        Client client1 = new Client(1, "Phil Foden", "627 Minnesota", "Foden@gmail.com");
        Client client2 = new Client(2, "Bob Marley", "462 New York", "Bob@gmail.com");

         // Create some products
         Product product1 = new Product(1, "MacBook Air", "Apple notebook", 1199.99, 10);
         Product product2 = new Product(2, "iPhone", "Apple Smartphone", 899.99, 20);

        // Add products to the wishlist
        client1.addProductToWishlist(product1, 1);
        client1.addProductToWishlist(product2, 2);

        // View the wishlist
        client1.viewWishlist();

        // Update product quantity in the wishlist
        client1.updateProductQuantityInWishlist(1, 2);

        // Check if a product exists in the wishlist
        System.out.println("Is product 1 in wishlist? " + client1.isProductInWishlist(1));

        // Remove a product from the wishlist
        client1.removeProductFromWishlist(2);

        // View the wishlist again
        client1.viewWishlist();

        // Add clients to the client list
        clientList.addClient(client1);
        clientList.addClient(client2);

        System.out.println("All clients:");
        // Display all clients
        clientList.displayClients();
            
        // View orders for a client (should be empty)
        System.out.println("\nViewing orders for Phil Foden:");
        client1.viewOrders().forEachRemaining(System.out::println);
            
        // Create an order for Phil Foden
        client1.createOrder("Order: 2 books");
        System.out.println("\nViewing orders for Phil Foden after adding an order:");
        client1.viewOrders().forEachRemaining(System.out::println);
            
        // Remove a client by ID
        System.out.println("\nRemoving Bob from the client list:");
        clientList.removeClientByID(2);
            
        // Display all clients again after removal
        System.out.println("\nAll clients after removal:");
        clientList.displayClients();
    }
}      