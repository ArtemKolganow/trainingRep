package by.training.finalproject.service;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.ProductDAO;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductServiceimpl implements ProductService {
    private static final Logger logger = LogManager.getLogger(ProductServiceimpl.class);
    @Override
    public List<Product> readAllProducts() throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory = new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.", e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                ProductDAO productDAO = (ProductDAO) transaction.createDao("ProductDAO");
                List<Product> list = productDAO.findAll();
                transaction.commit();
                return list;
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.", e);
        }
    }

    @Override
    public Product readByID(Integer id) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory = new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.", e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                ProductDAO productDAO = (ProductDAO) transaction.createDao("ProductDAO");
                Product product = productDAO.findEntityById(id);
                transaction.commit();
                return product;
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.", e);
        }
    }
}
