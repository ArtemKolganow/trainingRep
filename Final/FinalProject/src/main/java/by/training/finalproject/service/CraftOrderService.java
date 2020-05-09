package by.training.finalproject.service;

import by.training.finalproject.entity.CraftOrder;

import java.util.List;

public interface CraftOrderService extends Service {
    List<CraftOrder> readAllCraftOrders() throws ServiceException;
    List<CraftOrder> readCraftOrdersByUserId(Integer id) throws ServiceException;
}
