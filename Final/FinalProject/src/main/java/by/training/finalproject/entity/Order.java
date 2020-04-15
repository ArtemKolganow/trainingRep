package by.training.finalproject.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order implements Comparable<Order>, Entity {
    private int id;
    private Status status;
    private Date date;
    private Date deliveryDate;
    private double price;
    private List<ToSell> productList;

    public List<ToSell> getProductList() {
        return productList;
    }

    public void setProductList(List<ToSell> productList) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Double.compare(order.price, price) == 0 &&
                status == order.status &&
                Objects.equals(date, order.date) &&
                Objects.equals(deliveryDate, order.deliveryDate) &&
                Objects.equals(productList, order.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, date, deliveryDate, price, productList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", date=" + date +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", productList=" + productList +
                '}';
    }

    @Override
    public int compareTo(Order order) {
        return Integer.compare(this.id, order.id);
    }
}
