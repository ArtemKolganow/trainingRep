package by.training.task10payment.controller;

import by.training.task10payment.entity.Payment;
import by.training.task10payment.entity.Product;

import java.util.List;

public class RequestCreator {
    private static final String DELIMITER = "_";

    public String paymentToRequest(Payment payment) {
        StringBuilder request = new StringBuilder(payment.getCashier() + DELIMITER + payment.getShopName() + DELIMITER + payment.getBasket().getProducts().size());

        List<Product> products = payment.getBasket().getProducts();
        List<Integer> quantity = payment.getBasket().getQuantity();
        if (!products.isEmpty()) {
            request.append(DELIMITER);
        }
        for (int i = 0; i < products.size() - 1; i++) {
            request.append(productToRequest(products.get(i))).append(DELIMITER).append(quantity.get(i)).append(DELIMITER);
        }
        if (!products.isEmpty()) {
            request.append(productToRequest(products.get(products.size() - 1))).append(DELIMITER).append(quantity.get(products.size() - 1));
        }
        return request.toString();
    }

    public Payment requestToPayment(String request) {
        String[] temp = request.split(DELIMITER);
        Payment payment = new Payment(temp[0], temp[1]);
        for (int i = 3; i < Integer.parseInt(temp[2])*4 + 3; i += 4) {
            payment.addProduct(requestToProduct(temp[i], temp[i + 1], temp[i + 2]), Integer.parseInt(temp[i + 3]));
        }
        return payment;
    }

    private String productToRequest(Product product) {
        return product.getName() + DELIMITER + product.getPrice() + DELIMITER + product.getWeight();
    }

    private Product requestToProduct(String name, String price, String weight) {
        return new Product(name, Integer.parseInt(price), Integer.parseInt(weight));
    }
}
