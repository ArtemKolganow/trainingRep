package by.training.finalproject.service;

import by.training.finalproject.entity.Product;

import java.util.List;

public interface ProductService extends Service {
    List<Product> readAllProducts() throws ServiceException;
}
