import java.util.Iterator;
import java.util.Scanner;

public class ClerkMenuState implements WarehouseState {
    private WarehouseContext context;

    public ClerkMenuState(WarehouseContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": // Add a client
                System.out.print("Enter client name: ");
                String clientName = scanner.nextLine();
                System.out.print("Enter client ID: ");
                int clientId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter client address: ");
                String clientAddress = scanner.nextLine();
                System.out.print("Enter client contact: ");
                String clientContact = scanner.nextLine();
                Client newClient = new Client(clientId, clientName, clientAddress, clientContact);
                context.getWarehouseManagementSystem().addClient(newClient);
                System.out.println("Client added.");
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

            case "3": // Show list of clients
                System.out.println("Clients:");
                for (Client c : context.getWarehouseManagementSystem().getAllClients()) {
                    System.out.println(c);
                }
                break;

            case "4": // Show list of clients with outstanding balance
                System.out.println("Clients with outstanding balance:");
                for (Client c : context.getWarehouseManagementSystem().getAllClients()) {
                    if (c.hasOutstandingBalance()) {
                        System.out.println(c);
                    }
                }
                break;

            case "5": // Record payment from a client
                System.out.print("Enter client ID: ");
                int paymentClientID = scanner.nextInt();
                System.out.print("Enter payment amount: ");
                double paymentAmount = scanner.nextDouble();
                Client chargeClient = context.getWarehouseManagementSystem().getClientById(paymentClientID);
                if (chargeClient.getCreditAccount() > 0 && chargeClient.getCreditAccount() >= paymentAmount) {
                    chargeClient.setCreditAccount(chargeClient.getCreditAccount() - paymentAmount);
                } else if (chargeClient.getCreditAccount() > 0 && chargeClient.getCreditAccount() < paymentAmount) {
                    paymentAmount = paymentAmount - chargeClient.getCreditAccount();
                    chargeClient.setCreditAccount(0);
                    chargeClient.setDebitAccount(paymentAmount + chargeClient.getDebitAccount());
                } else {
                    chargeClient.setDebitAccount(paymentAmount + chargeClient.getDebitAccount());
                }
                System.out.println("Payment recorded.");
                break;

            case "6": // Become a client
                for(Client cl : context.getWarehouseManagementSystem().getAllClients()){
                    System.out.println(cl);
                }
                System.out.print("Enter Client ID: ");
                int becomeClientId = scanner.nextInt();
                Client client = context.getWarehouseManagementSystem().getClientById(becomeClientId);
                if (client != null) {
                    context.setCurrentClient(client);
                    context.setState(new ClientMenuState(context));
                    new ClientMenuState(context).displayOptions();
                } else {
                    System.out.println("Client not found.");
                }
                break;

            case "7": // Logout
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
        System.out.println("1. Add a client");
        System.out.println("2. Show list of products (with available quantity and price)");
        System.out.println("3. Show list of clients");
        System.out.println("4. Show list of clients with outstanding balance");
        System.out.println("5. Record payment from a client");
        System.out.println("6. Become a client");
        System.out.println("7. Logout");
    }
}

