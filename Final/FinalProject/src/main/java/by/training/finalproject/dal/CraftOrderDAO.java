package by.training.finalproject.dal;

import by.training.finalproject.entity.CraftOrder;

public interface CraftOrderDAO extends AbstractDAO<Integer, CraftOrder> {
    CraftOrder findEntityById(Integer id) throws DataObjectException;
}
