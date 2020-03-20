package by.training.task13.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int orderId;
    private String status;
    private String date;
    private String deliviredate;
    private double price;
    private List<Product> productList;

    public Order() {
        productList = new LinkedList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeliviredate() {
        return deliviredate;
    }

    public void setDeliviredate(String deliviredate) {
        this.deliviredate = deliviredate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct(int i) {
        return productList.get(i);
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public int getProductSize(){
        return productList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                Objects.equals(status, order.status) &&
                Objects.equals(date, order.date) &&
                Objects.equals(deliviredate, order.deliviredate) &&
                Objects.equals(price, order.price) &&
                Objects.equals(productList, order.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, date, deliviredate, price, productList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", deliviredate='" + deliviredate + '\'' +
                ", price='" + price + '\'' +
                ", productList=" + productList +
                '}';
    }
}
