package by.training.finalproject.dal;

import by.training.finalproject.entity.RegisteredProduct;

import java.util.List;

public interface RegisteredProductDAO extends AbstractDAO<Integer, RegisteredProduct> {
    List<RegisteredProduct> findEntityById(Integer id) throws DataObjectException;
    boolean deleteByOrderId(int id)throws DataObjectException;
}
