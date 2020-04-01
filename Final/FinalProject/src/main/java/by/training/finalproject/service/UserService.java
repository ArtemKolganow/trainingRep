package by.training.finalproject.service;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.UserDAO;
import by.training.finalproject.entity.User;

import java.util.List;

public class UserService {
    public List<User> readAllUsers() throws ServiceException {
        UserDAO dao = new UserDAO();
        try {
            return dao.findAll();
        } catch (DataObjectException e) {
            throw new ServiceException(e);
        }
    }

    public User findById(int id) throws ServiceException {
        UserDAO dao = new UserDAO();
        try {
            return dao.findEntityById(id);
        } catch (DataObjectException e) {
            throw new ServiceException(e);
        }
    }
}
