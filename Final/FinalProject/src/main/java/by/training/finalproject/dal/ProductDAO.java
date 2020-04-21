package by.training.finalproject.dal;

import by.training.finalproject.entity.Product;

public interface ProductDAO extends AbstractDAO<Integer, Product> {
    Product findEntityById(Integer id) throws DataObjectException;
}
