package models;

public class Product {
    private String name;
    private double price;
    private String storeName;
    private String productUrl;

    public Product(String name, double price, String storeName, String productUrl) {
        this.name = name;
        this.price = price;
        this.storeName = storeName;
        this.productUrl = productUrl;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", storeName='" + storeName + '\'' +
                ", productUrl='" + productUrl + '\'' +
                '}';
    }
}

