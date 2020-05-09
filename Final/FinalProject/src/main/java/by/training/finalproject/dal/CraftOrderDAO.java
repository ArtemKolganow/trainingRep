package by.training.finalproject.dal;

import by.training.finalproject.entity.CraftOrder;

import java.util.List;

public interface CraftOrderDAO extends AbstractDAO<Integer, CraftOrder> {
    CraftOrder findEntityById(Integer id) throws DataObjectException;
    List<CraftOrder> findEntityByUserId(Integer id) throws DataObjectException;
}
