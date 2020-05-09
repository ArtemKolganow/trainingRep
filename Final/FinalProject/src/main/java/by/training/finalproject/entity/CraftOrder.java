package by.training.finalproject.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class CraftOrder implements Comparable<CraftOrder>, Entity, Serializable {
    private int id;
    private int userId;
    private String title;
    private String orderDescription;
    private LocalDate date;
    private State state;
    private double price;

    @Override
    public String toString() {
        return "CraftOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", date=" + date +
                ", state=" + state +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CraftOrder that = (CraftOrder) o;
        return id == that.id &&
                userId == that.userId &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(orderDescription, that.orderDescription) &&
                Objects.equals(date, that.date) &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, orderDescription, date, state, price);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(CraftOrder craftOrder) {
        return Integer.compare(this.id,craftOrder.id);
    }
}
