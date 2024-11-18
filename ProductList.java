import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductList {
    // list to store all the products
    private List<Product> products;

    // constructor
    public ProductList() {
        products = new ArrayList<>();
    }

    // add a product to the list
    public boolean addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            return true; // if product was added successfully
        }
        return false; // if product already exists (or addition failed)
    }

    // remove a product by its ID
    public boolean removeProduct(int productID) {
        return products.removeIf(product -> product.getProductID() == productID);
    }

    // get a product by its ID
    public Product getProductByID(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null; // return null if not found
    }

    // print all products with their details using iterator of Products
    public void printAllProducts() {
        Iterator<Product> iterator = this.getProducts();
        while (iterator.hasNext()) {
            Product product = iterator.next();

            System.out.println(product.getProductDetails());
            System.out.println(); // newline
        }
    }

    // return an iterator for the list of products
    public Iterator<Product> getProducts() {
        return products.iterator();
    }
}