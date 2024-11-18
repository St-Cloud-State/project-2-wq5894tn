public class ProductDriver {
    public static void main(String[] args) {
        // create a ProductList
        ProductList productList = new ProductList();
        
        // create some products
        Product product1 = new Product(1, "MacBook Air", "Apple notebook", 1199.99, 10);
        Product product2 = new Product(2, "iPhone", "Apple Smartphone", 899.99, 20);
        
        // add products to the list
        boolean addedProduct1 = productList.addProduct(product1);
        boolean addedProduct2 = productList.addProduct(product2);
        
        // display if products were added successfully
        System.out.println("Product 1 added: " + addedProduct1);
        System.out.println("Product 2 added: " + addedProduct2);
        
        // print all products
        productList.printAllProducts();
        
        // update stock quantity
        product1.updateStock(5);
        
        // print details after stock update
        System.out.println("After stock update:");
        productList.printAllProducts();
        
        // remove a product
        boolean removedProduct = productList.removeProduct(1);
        System.out.println("Product 1 removed: " + removedProduct);
        
        // print all products after removal
        System.out.println("After product removal:");
        productList.printAllProducts();
    }
}
