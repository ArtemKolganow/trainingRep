package by.training.task10payment.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {
    private String cashier;
    private String shopName;
    private Basket basket;
    public static class Basket {
        private List<Product> products;
        private List<Integer> quantity;

        Basket() {
            this.products = new ArrayList<>();
            this.quantity = new ArrayList<>();
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<Integer> getQuantity() {
            return quantity;
        }

        public void setQuantity(List<Integer> quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Basket basket = (Basket) o;
            return Objects.equals(products, basket.products) &&
                    Objects.equals(quantity, basket.quantity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(products, quantity);
        }

        @Override
        public String toString() {
            return "Basket{" +
                    "products=" + products +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    public Payment(String cashier, String shopName) {
        this.cashier = cashier;
        this.shopName = shopName;
        this.basket = new Basket();
    }

    public Payment() {
        this.basket = new Basket();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void addProduct(Product product , int quantity){
        this.basket.products.add(product);
        this.basket.quantity.add(quantity);
    }

    public void removeProduct(int number) throws IndexOutOfBoundsException, NumberFormatException{
        this.basket.products.remove(number);
        this.basket.quantity.remove(number);
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(cashier, payment.cashier) &&
                Objects.equals(shopName, payment.shopName) &&
                Objects.equals(basket, payment.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashier, shopName, basket);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "cashier='" + cashier + '\'' +
                ", shopName='" + shopName + '\'' +
                ", basket=" + basket +
                '}';
    }
}
