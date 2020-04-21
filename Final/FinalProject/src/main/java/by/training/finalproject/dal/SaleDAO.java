package by.training.finalproject.dal;

import by.training.finalproject.entity.Sale;

public interface SaleDAO extends AbstractDAO<Integer, Sale> {
    Sale findEntityById(Integer id) throws DataObjectException;
}
