import java.util.Iterator;

public class WarehouseDriver {
    public static void main(String[] args) {

        //make the warehouse and set all its values
        Warehouse warehouse = new Warehouse("New York", "1234 Broadway St");
        
        System.out.println("Initial Warehouse Details:");
        System.out.println("Location: " + warehouse.getLocation());
        System.out.println("Address: " + warehouse.getAddress());
        System.out.println("Warehouse ID: " + warehouse.getID());
        warehouse.setID(101);
        System.out.println("Updated Warehouse ID: " + warehouse.getID());

        //test the setter functions
        System.out.println("\nTesting setters...");
        warehouse.setLocation("Los Angeles");
        warehouse.setAddress("5678 Sunset Blvd");
        warehouse.setID(101);
        System.out.println("Updated Warehouse Details:");
        System.out.println("Location: " + warehouse.getLocation());
        System.out.println("Address: " + warehouse.getAddress());
        System.out.println("Warehouse ID: " + warehouse.getID());
        
        //make some products for testings
        Product product1 = new Product(1, "MacBook Air", "Apple notebook", 1199.99, 10);
        Product product2 = new Product(2, "iPhone", "Apple Smartphone", 899.99, 20);
        Product product3 = new Product(3, "Apple Watch", "Smartwatch", 399.99, 30);
        warehouse.addProduct(product1);
        warehouse.addProduct(product2);
        warehouse.addProduct(product3);

        System.out.println("\nAll products in the warehouse:");
        warehouse.displayAllProduct();

        System.out.println("\nIterating over the product list:");
        Iterator<Product> productIterator = warehouse.getProductList();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            System.out.println(product.getProductDetails());
        }


        //tests of features
        System.out.println("\nUpdating stock for MacBook Air");
        product1.updateStock(5);
        warehouse.displayAllProduct();

        System.out.println("\nRemoving iPhone from the warehouse");
        boolean removed = warehouse.removeProduct(2);
        System.out.println("Product removed: " + removed);

        System.out.println("\nProducts after removal:");
        warehouse.displayAllProduct();
        
        //final print
        System.out.println("\nWarehouse Details after changes:");
        System.out.println("Location: " + warehouse.getLocation());
        System.out.println("Address: " + warehouse.getAddress());
        System.out.println("Warehouse ID: " + warehouse.getID());
    }
}
