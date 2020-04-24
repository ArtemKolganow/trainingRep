package by.training.finalproject.entity;

import java.util.Objects;

public class RegisteredProduct implements Entity {
    private int orderId;
    private ToSell product;
    private int quantity;

    @Override
    public String toString() {
        return "RegistredProduct{" +
                "order_id=" + orderId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredProduct that = (RegisteredProduct) o;
        return orderId == that.orderId &&
                quantity == that.quantity &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, product, quantity);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ToSell getProduct() {
        return product;
    }

    public void setProduct(ToSell product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
