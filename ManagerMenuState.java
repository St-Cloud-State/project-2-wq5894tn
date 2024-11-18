import java.util.Scanner;

public class ManagerMenuState implements WarehouseState {
    private WarehouseContext context;

    public ManagerMenuState(WarehouseContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": // Add a product
                // Display available warehouses
                System.out.println("Available Warehouses:");
                for (Warehouse w : context.getWarehouseManagementSystem().getAllWarehouses()) {
                    System.out.println("ID: " + w.getID() + ", Location: " + w.getLocation());
                }


                System.out.print("Enter Warehouse ID: ");
                int warehouseID = scanner.nextInt();
                Warehouse warehouse = context.getWarehouseManagementSystem().getWarehouseById(warehouseID);
                if (warehouse != null) {
                    System.out.print("Enter Product ID: ");
                    int productID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Description: ");
                    String productDescription = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stockQuantity = scanner.nextInt();
                    Product product = new Product(productID, productName, productDescription, productPrice, stockQuantity);
                    context.getWarehouseManagementSystem().addProduct(warehouse, product);
                    System.out.println("Product added to warehouse.");
                } else {
                    System.out.println("Warehouse not found.");
                }
                break;

            case "2": // Display the waitlist for a product
                System.out.print("Enter Product ID: ");
                int productId = scanner.nextInt();
                Product product = context.getWarehouseManagementSystem().getProductById(productId);
                if (product != null) {
                    product.printWaitlist();
                } else {
                    System.out.println("Product not found.");
                }
                break;

            case "3": // Receive a shipment
                System.out.print("Enter Product ID: ");
                int shipmentId = scanner.nextInt();
                Product shipmentProduct = context.getWarehouseManagementSystem().getProductById(shipmentId);
                if (shipmentProduct != null) {
                    System.out.print("Enter amount of product: ");
                    int amount = scanner.nextInt();
                    shipmentProduct.updateStock(amount);
                    System.out.println("Shipment received.");
                } else {
                    System.out.println("Product not found.");
                }
                break;

            case "4": // Become a Clerk
                context.setState(new ClerkMenuState(context));
                context.getCurrentState().displayOptions();
                break;

            case "5": // Logout
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
        System.out.println("1. Add a product");
        System.out.println("2. Display the waitlist for a product");
        System.out.println("3. Receive a shipment");
        System.out.println("4. Become a Clerk");
        System.out.println("5. Logout");
    }
}