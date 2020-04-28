package by.training.finalproject.service;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.OrderDAO;
import by.training.finalproject.dal.UserDAO;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.Order;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class OrderServiceimpl implements OrderService {
    @Override
    public List<Order> readOrdersByUserId(Integer userId) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                OrderDAO dao = (OrderDAO) transaction.createDao("OrderDAO");
               List<Order> orders = dao.findEntityByUserId(userId);
               transaction.commit();
                return orders;
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }

    }
}
