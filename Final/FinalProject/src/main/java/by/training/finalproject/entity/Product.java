package by.training.finalproject.entity;

import java.util.List;
import java.util.Objects;

public class Product implements ToSell, Comparable<Product>, Entity {
    private int id;
    private String name;
    private String type;
    private double price;
    private double weight;
    private String image;
    private List<String> materials;
    private double sale;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", image='" + image + '\'' +
                ", materials=" + materials +
                ", sale=" + sale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Double.compare(product.weight, weight) == 0 &&
                Double.compare(product.sale, sale) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(type, product.type) &&
                Objects.equals(image, product.image) &&
                Objects.equals(materials, product.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, weight, image, materials, sale);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(this.id, product.id);
    }
}
