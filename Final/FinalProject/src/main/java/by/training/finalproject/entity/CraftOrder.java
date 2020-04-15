package by.training.finalproject.entity;

import java.util.Objects;

public class CraftOrder implements ToSell, Comparable<CraftOrder>, Entity{
    private int id;
    private String title;
    private String orderDescription;
    private String Date;
    private State state;
    private double price;

    @Override
    public String toString() {
        return "CraftOrder{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", Date='" + Date + '\'' +
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
                Double.compare(that.price, price) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(orderDescription, that.orderDescription) &&
                Objects.equals(Date, that.Date) &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, orderDescription, Date, state, price);
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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
