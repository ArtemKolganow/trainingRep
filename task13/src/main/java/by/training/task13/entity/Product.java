package by.training.task13.entity;

import java.util.Objects;

public class Product {
    private int product_id;
    private int quantity;

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return product_id == product.product_id &&
                quantity == product.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
