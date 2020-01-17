package by.training.task10treasures.entity;

import java.util.Objects;

public class Treasure {
    private String name;
    private int price;
    private int weight;

    public Treasure(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Treasure() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return price == treasure.price &&
                weight == treasure.weight &&
                Objects.equals(name, treasure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
