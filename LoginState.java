import java.util.Scanner;

public class LoginState implements WarehouseState {
    private WarehouseContext context;

    public LoginState(WarehouseContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": // Client
                for(Client cl : context.getWarehouseManagementSystem().getAllClients()){
                    System.out.println(cl);
                }

                System.out.print("Enter Client ID: ");
                int clientId = scanner.nextInt();
                Client client = context.getWarehouseManagementSystem().getClientById(clientId);
                if (client != null) {
                    context.setCurrentClient(client);
                    context.setState(new ClientMenuState(context));
                    context.getCurrentState().displayOptions();
                } else {
                    System.out.println("Client not found.");
                }
                break;

            case "2": // Clerk
                context.setState(new ClerkMenuState(context));
                context.getCurrentState().displayOptions();
                break;

            case "3": // Manager
                context.setState(new ManagerMenuState(context));
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
        System.out.println("1. Login as Client");
        System.out.println("2. Login as Clerk");
        System.out.println("3. Login as Manager");
    }
}