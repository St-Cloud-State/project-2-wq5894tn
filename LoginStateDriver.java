import java.util.Scanner;

public class LoginStateDriver {
    public static void main(String[] args) {
        // Create test client
        Client testClient = new Client(1, "John Doe", "123 Main St", "555-1234");

        // Create test warehouse management system
        final WarehouseManagementSystem wms = new WarehouseManagementSystem();

        // Create warehouses
        Warehouse warehouse1 = new Warehouse("1", "Central Warehouse");
        Warehouse warehouse2 = new Warehouse("2", "North Warehouse");

        // Create additional test clients
        Client client1 = new Client(2, "Jane Smith", "456 High St", "555-5678");
        Client client2 = new Client(3, "Bob Johnson", "789 Oak St", "555-9012");

        wms.addClient(testClient);
        wms.addClient(client1);
        wms.addClient(client2);

        // Initialize warehouse context
        WarehouseContext context = new WarehouseContext(wms);

        // Set the state to LoginState
        context.setState(new LoginState(context));

        // Scanner for user input simulation
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        context.getCurrentState().displayOptions();


        while (true) {
            System.out.print("Enter option: ");
            String input = scanner.nextLine();
            context.getCurrentState().handle(input);
            if ("q".equals(input)) {
                break;
            }
        }

        scanner.close();
    }
}