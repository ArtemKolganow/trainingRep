package by.training.finalproject.service;

import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.RegisteredProduct;

import java.util.List;

public interface RegisteredProductService extends Service {
    RegisteredProduct addNewRegisteredProduct(Product product, Integer orderId,  Integer quantity) throws ServiceException;
    void editQuantity(RegisteredProduct registeredProduct) throws ServiceException;
    void deleteRegisteredProduct(RegisteredProduct registeredProduct) throws ServiceException;
    List<RegisteredProduct> readByOrderId(Integer orderId) throws ServiceException;
}
