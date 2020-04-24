package by.training.finalproject.dal;

import by.training.finalproject.entity.Order;

import java.util.List;

public interface OrderDAO extends AbstractDAO<Integer, Order> {
    Order findEntityById(Integer id) throws DataObjectException;
    List<Order> findEntityByUserId(Integer id) throws DataObjectException;
}
