import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ClientMenuState implements WarehouseState {
    private WarehouseContext context;

    public ClientMenuState(WarehouseContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": // Show client details
                System.out.println(context.getCurrentClient().toString());
                break;
            case "2": // Show list of products
                System.out.println("Products:");
                for (Warehouse w : context.getWarehouseManagementSystem().getAllWarehouses()) {
                    Iterator<Product> productIterator = w.getProductList();
                    while (productIterator.hasNext()) {
                        Product pd = productIterator.next();
                        System.out.println(pd.getProductDetails());
                    }
                }
                break;
            case "3": // Show client transactions
                context.getCurrentClient().viewOrders();
                break;
            case "4": // Add item to wishlist
                System.out.print("Enter product ID: ");
                int prodId = scanner.nextInt();
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                context.getWarehouseManagementSystem().addToWishlist(context.getCurrentClient(), prodId, qty);
                break;
            case "5": // Display wishlist
                context.getCurrentClient().printWishlist();
                break;
            case "6": // Place an order
                context.getCurrentClient().placeOrder(context.getWarehouseManagementSystem());
                break;
            case "7": // Logout
                context.setCurrentClient(null);
                context.setState(new LoginState(context));
                context.getCurrentState().displayOptions();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                displayOptions();
                break;
        }
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Show client details");
        System.out.println("2. Show list of products");
        System.out.println("3. Show client transactions");
        System.out.println("4. Add item to wishlist");
        System.out.println("5. Display wishlist");
        System.out.println("6. Place an order");
        System.out.println("7. Logout");
    }
}