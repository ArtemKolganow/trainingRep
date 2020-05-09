package by.training.finalproject.service;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.RegisteredProductDAO;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.RegisteredProduct;

import java.util.List;

public class RegisteredProductServiceimpl implements RegisteredProductService {

    @Override
    public RegisteredProduct addNewRegisteredProduct(Product product, Integer orderId, Integer quantity) throws ServiceException {
        RegisteredProduct registeredProduct = new RegisteredProduct();
        registeredProduct.setQuantity(quantity);
        registeredProduct.setProduct(product);
        registeredProduct.setOrderId(orderId);
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                RegisteredProductDAO dao = (RegisteredProductDAO) transaction.createDao("RegisteredProductDAO");
                if(!dao.create(registeredProduct)){
                    registeredProduct = null;
                }
                transaction.commit();
                return registeredProduct;
            } catch (DataObjectException  e) {
                throw new ServiceException(e);
            }finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }

    @Override
    public void editQuantity(RegisteredProduct registeredProduct) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                RegisteredProductDAO dao = (RegisteredProductDAO) transaction.createDao("RegisteredProductDAO");
                dao.update(registeredProduct);
                transaction.commit();
            } catch (DataObjectException  e) {
                throw new ServiceException(e);
            }finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }

    @Override
    public void deleteRegisteredProduct(RegisteredProduct registeredProduct) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                RegisteredProductDAO dao = (RegisteredProductDAO) transaction.createDao("RegisteredProductDAO");
                dao.delete(registeredProduct);
                transaction.commit();
            } catch (DataObjectException  e) {
                throw new ServiceException(e);
            }finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }

    @Override
    public List<RegisteredProduct> readByOrderId(Integer orderId) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                RegisteredProductDAO dao = (RegisteredProductDAO) transaction.createDao("RegisteredProductDAO");
                List<RegisteredProduct> list = dao.findEntityById(orderId);
                transaction.commit();
                return list;
            } catch (DataObjectException  e) {
                throw new ServiceException(e);
            }finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }
}
