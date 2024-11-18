public class WarehouseContext {
    private WarehouseState currentState;
    private WarehouseManagementSystem warehouseManagementSystem;
    private Client currentClient;

    public WarehouseContext(WarehouseManagementSystem warehouseManagementSystem) {
        this.warehouseManagementSystem = warehouseManagementSystem;
        this.currentState = new LoginState(this); // Start with LoginState
    }

    public void setState(WarehouseState state) {
        this.currentState = state;
    }

    public WarehouseManagementSystem getWarehouseManagementSystem() {
        return warehouseManagementSystem;
    }

    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client client) {
        this.currentClient = client;
    }

    public void handle(String input) {
        currentState.handle(input);
    }

    public WarehouseState getCurrentState() {
        return currentState;
    }
}