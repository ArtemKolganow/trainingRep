package by.training.task10payment.service;

import by.training.task10payment.dal.Reader;
import by.training.task10payment.entity.Payment;
import by.training.task10payment.entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PaymentService {
    private static String path = "product.txt";
    private static final  String REG = "_";

    public void addToPayment(Payment payment,String name , int quantity) throws IOException, NumberFormatException {
        List<Product> products = getListOfProducts();
        for(Product i: products){
            if(i.getName().equals(name)){
                payment.addProduct(i , quantity);
                break;
            }
        }
    }

    public List<Product> getListOfProducts() throws IOException {
        Reader reader = new Reader(path);
        Pattern pattern = Pattern.compile(REG);
        List<Product> res = new ArrayList<>();
        List<String> data = reader.readData();
        for(String i : data){
            String[] temp = pattern.split(i);
            Product product = new Product(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
            res.add(product);
        }
        return res;
    }

    public void addToFile(String name, int price, int weight) throws IOException, NumberFormatException {
        String toFile = name +"_" +price + "_" +weight;
        Reader reader = new Reader(path);
        reader.writeData(toFile);
    }

    public static void changePath(String newPath){
        PaymentService.path = newPath;
    }
}
