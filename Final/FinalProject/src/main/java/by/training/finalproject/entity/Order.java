package by.training.finalproject.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order implements Comparable<Order>, Entity, Serializable {
    private int id;
    private int userId;
    private Status status;
    private LocalDate date;
    private LocalDate deliveryDate;
    private double price;
    private List<RegisteredProduct> productList = new ArrayList<>();
    private CraftOrder craftOrder;

    public void addProductToOrder(RegisteredProduct registeredProduct){
        productList.add(registeredProduct);
    }

    public List<RegisteredProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<RegisteredProduct> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CraftOrder getCraftOrder() {
        return craftOrder;
    }

    public void setCraftOrder(CraftOrder craftOrder) {
        this.craftOrder = craftOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                Double.compare(order.price, price) == 0 &&
                status == order.status &&
                Objects.equals(date, order.date) &&
                Objects.equals(deliveryDate, order.deliveryDate) &&
                Objects.equals(productList, order.productList) &&
                Objects.equals(craftOrder, order.craftOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, date, deliveryDate, price, productList, craftOrder);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                ", date=" + date +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", productList=" + productList +
                ", craftOrder=" + craftOrder +
                '}';
    }

    @Override
    public int compareTo(Order order) {
        return Integer.compare(this.id, order.id);
    }
}
