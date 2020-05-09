package by.training.finalproject.service;

import by.training.finalproject.dal.CraftOrderDAO;
import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.UserDAO;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.CraftOrder;
import by.training.finalproject.entity.User;

import java.util.List;

public class CraftOrderServiceimpl implements CraftOrderService {
    @Override
    public List<CraftOrder> readAllCraftOrders() throws ServiceException {

        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }

        try {
            try {
                Transaction transaction = factory.createTransaction();
                CraftOrderDAO dao = (CraftOrderDAO) transaction.createDao("CraftOrderDAO");
                List<CraftOrder> craftOrders = dao.findAll();
                transaction.commit();
                return craftOrders;
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
    public List<CraftOrder> readCraftOrdersByUserId(Integer id) throws ServiceException {

        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }

        try {
            try {
                Transaction transaction = factory.createTransaction();
                CraftOrderDAO dao = (CraftOrderDAO) transaction.createDao("CraftOrderDAO");
                List<CraftOrder> craftOrders = dao.findEntityByUserId(id);
                transaction.commit();
                return craftOrders;
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
