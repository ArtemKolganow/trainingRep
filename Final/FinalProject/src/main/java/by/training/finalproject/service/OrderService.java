package by.training.finalproject.service;

import by.training.finalproject.entity.Order;

import java.util.List;

public interface OrderService extends Service {
    List<Order> readOrdersByUserId(Integer userId) throws ServiceException;
    Order readCompilationOrderByUserId(Integer userId) throws ServiceException;
    void createNewOrder(Integer userId) throws ServiceException;
    void confirmOrder(Order order) throws ServiceException;
}
