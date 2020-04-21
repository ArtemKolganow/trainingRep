package by.training.finalproject.dal;

import by.training.finalproject.entity.User;

import java.util.List;

public interface UserDAO extends AbstractDAO<Integer, User> {
    User findEntityByLoginAndPass(String login, String pass) throws DataObjectException;
    User findEntityById(Integer id) throws DataObjectException;
}
