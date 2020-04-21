package by.training.finalproject.entity;

import java.util.Objects;

public class Sale implements Entity {
    private Double saleValue;
    private int id;


    public Sale() {
    }

    @Override
    public String toString() {
        return "Sale{" +
                "sale=" + saleValue +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale1 = (Sale) o;
        return id == sale1.id &&
                Objects.equals(saleValue, sale1.saleValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleValue, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sale(Double saleValue, int id) {
        this.saleValue = saleValue;
        this.id = id;
    }

    public Double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Double saleValue) {
        this.saleValue = saleValue;
    }
}
