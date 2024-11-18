import java.io.Serializable;
import java.util.Iterator;
public class Warehouse implements Serializable {
    private String location;
    private String address;
    private ProductList productList;
    private int warehouseID;
    private static final long serialVersionUID = 3L;
    
    public Warehouse(String location, String address) {
        this.location = location;
        this.address = address;
        this.productList = new ProductList();
    }

    public boolean addProduct(Product product) {
        return productList.addProduct(product);
    }

    public void displayAllProduct() {
        productList.printAllProducts();
    }

    public Iterator<Product> getProductList() {
        return productList.getProducts(); // Return an iterator of the products
    }

    public boolean removeProduct(int productID) {
        return productList.removeProduct(productID);
    }

    public int getID() {
        return warehouseID;
    }

    public Product getProductById(int productID) {
        Iterator<Product> iterator = productList.getProducts();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public void setID(int id) {
        this.warehouseID = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
