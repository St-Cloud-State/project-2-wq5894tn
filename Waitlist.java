import java.io.Serializable;

public class Waitlist implements Serializable {
    private static final long serialVersionUID = 7L;
    private int clientID;
    private int quantity;

    public Waitlist(int clientID, int quantity) {
        this.clientID = clientID;
        this.quantity = quantity;
    }

    public int getClientID() {
        return clientID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
