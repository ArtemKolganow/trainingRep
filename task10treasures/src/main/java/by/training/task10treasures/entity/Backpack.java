package by.training.task10treasures.entity;

import java.util.*;

public class Backpack {
    private int priceLimit;
    private Set<Treasure> treasures;

    public Backpack(int priceLimit) {
        this.priceLimit = priceLimit;
        treasures = new HashSet<>();
    }

    public int getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(int priceLimit) {
        this.priceLimit = priceLimit;
    }

    public Set<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(Set<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void addTreasure(Treasure treasure){
        this.treasures.add(treasure);
    }

    public void removeTreasure(Treasure treasure){
        this.treasures.remove(treasure);
    }

    public int priceLeft(){
        int priceLeft = priceLimit;
        for(Treasure i: treasures){
            priceLeft -= i.getPrice();
        }
        return priceLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backpack backpack = (Backpack) o;
        return priceLimit == backpack.priceLimit &&
                Objects.equals(treasures, backpack.treasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceLimit, treasures);
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "priceLimit=" + priceLimit +
                ", treasures=" + treasures +
                '}';
    }
}
