import java.util.Scanner;

public class ManagerMenuStateDriver {
    public static void main(String[] args) {
        // Create test client
        Client testClient = new Client(1, "John Doe", "123 Main St", "555-1234");

        // Create test warehouse management system
        final WarehouseManagementSystem wms = new WarehouseManagementSystem();

        // Create warehouses
        int wId = 0;
        Warehouse warehouse1 = new Warehouse("1", "Central Warehouse");
        warehouse1.setID(wId++);
        Warehouse warehouse2 = new Warehouse("2", "North Warehouse");
        warehouse2.setID(wId++);

        // Add some dummy products to the warehouses
        Product product1 = new Product(1001, "Product 1", "ocelot",10, 50);
        Product product2 = new Product(1002, "Product 2", "moose",15, 75);
        Product product3 = new Product(1003, "Product 3", "bear",20, 100);

        warehouse1.addProduct(product1);
        warehouse1.addProduct(product2);
        warehouse2.addProduct(product3);

        // Add warehouses to the warehouse management system
        wms.addWarehouse(warehouse1);
        wms.addWarehouse(warehouse2);

        // Create additional test clients
        Client client1 = new Client(2, "Jane Smith", "456 High St", "555-5678");
        Client client2 = new Client(3, "Bob Johnson", "789 Oak St", "555-9012");

        wms.addClient(testClient);
        wms.addClient(client1);
        wms.addClient(client2);

        // Initialize warehouse context
        WarehouseContext context = new WarehouseContext(wms);

        // Set the state to ManagerMenuState
        context.setState(new ManagerMenuState(context));

        // Scanner for user input simulation
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        context.getCurrentState().displayOptions();

        // Example input simulation
        while (true) {
            System.out.print("Enter option: ");
            String input = scanner.nextLine();
            context.getCurrentState().handle(input);
            if ("7".equals(input)) { // Option to logout
                context.getCurrentState().displayOptions(); // Show login options after logout
            }
        }
    }
}