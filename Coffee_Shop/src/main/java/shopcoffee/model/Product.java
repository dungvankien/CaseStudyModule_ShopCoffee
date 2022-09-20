package shopcoffee.model;

import java.util.Objects;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int amount;
    private String image;

    public Product() {
    }

    public Product(String nameProduct, double price, int amount, String image) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.image = image;
    }

    public Product(int idProduct, String nameProduct, double price, int amount, String image) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.image = image;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && Double.compare(product.price, price) == 0 && amount == product.amount && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, price, amount, image);
    }
}
