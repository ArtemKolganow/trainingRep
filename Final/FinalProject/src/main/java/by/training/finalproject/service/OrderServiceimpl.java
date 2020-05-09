package by.training.finalproject.service;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.OrderDAO;
import by.training.finalproject.dal.UserDAO;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.Order;
import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.RegisteredProduct;
import by.training.finalproject.entity.Status;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
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

    @Override
    public Order readCompilationOrderByUserId(Integer userId) throws ServiceException {
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
                Order order = dao.findCompilationOrderByUserId(userId, "compilation");
                transaction.commit();
                return order;
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }

    }

    @Override
    public void createNewOrder(Integer userId) throws ServiceException {
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
                Order order =new Order();
                order.setUserId(userId);
                order.setStatus(Status.COMPILATION);
                order.setPrice(0);
                order.setDate(LocalDate.now());
                order.setDeliveryDate(LocalDate.now());
                dao.create(order);
                transaction.commit();
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }

    @Override
    public void confirmOrder(Order order) throws ServiceException {
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
                order.setStatus(Status.CONFIRMED);
                double price = 0;
                if(!order.getProductList().isEmpty()){
                    for (RegisteredProduct product: order.getProductList()){
                        price+=product.getProduct().getPrice();
                    }
                }else{
                    price=order.getCraftOrder().getPrice();
                }
                order.setPrice(price);
                dao.update(order);
                transaction.commit();
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
