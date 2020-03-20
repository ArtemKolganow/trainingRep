package by.training.task13.service;


import by.training.task13.entity.User;

import java.io.InputStream;
import java.util.Set;

public interface BaseBuilder {
    void buildUsers(String fileName) throws ServiceException;
    void buildUsers(InputStream file) throws ServiceException;
    Set<User> getUsers();
}
