
import java.util.*;
import java.io.Serializable;

public class ClientList implements Serializable {
    private static final long serialVersionUID = 2L;
    private List<Client> clientList = new ArrayList<>();

    // Method to add a new client
    public void addClient(Client client) {
        clientList.add(client);
        System.out.println("Client added: " + client.getName());
    }

    // Method to find a client by their clientID
    public Client findClientByID(int clientID) {
        for (Client client : clientList) {
            if (client.getClientID() == clientID) {
                return client;
            }
        }
        return null;  // Return null if no client is found
    }

    // Method to display all clients
    public void displayClients() {
        if (clientList.isEmpty()) {
            System.out.println("No clients available.");
        } else {
            for (Client client : clientList) {
                System.out.println(client);
            }
        }
    }

    // Method to remove a client by their clientID
    public boolean removeClientByID(int clientID) {
        Iterator<Client> iterator = clientList.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getClientID() == clientID) {
                iterator.remove();
                System.out.println("Client removed: " + client.getName());
                return true;
            }
        }
        System.out.println("Client not found.");
        return false;
    }
}
