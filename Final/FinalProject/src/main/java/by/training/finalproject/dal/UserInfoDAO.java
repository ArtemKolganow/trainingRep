package by.training.finalproject.dal;

import by.training.finalproject.entity.UserInfo;

public interface UserInfoDAO extends AbstractDAO<Integer, UserInfo> {
    UserInfo findEntityById(Integer id) throws DataObjectException;
}
