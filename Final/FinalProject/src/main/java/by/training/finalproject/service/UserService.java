package by.training.finalproject.service;

import by.training.finalproject.entity.User;

import java.util.List;

public interface UserService extends Service {
    List<User> readAllUsers() throws ServiceException;
    User findById(int id) throws ServiceException;
    User findByLoginAndPass(String login, String pass) throws ServiceException;
    boolean addNewUser(User user) throws ServiceException;
}
