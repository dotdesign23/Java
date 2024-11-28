public class Product {
    private String ProductName;
    private String ProductPrice;

    public Product(String productName, String productPrice) {
        super();
        ProductName = productName;
        ProductPrice = productPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
