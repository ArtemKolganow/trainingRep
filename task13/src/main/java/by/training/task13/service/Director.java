package by.training.task13.service;

import by.training.task13.entity.User;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Director {

    public static Set<User> createUsers(BaseBuilder builder, String path) throws ServiceException {
        try {
            builder.buildUsers(path);
            return builder.getUsers();
        } catch (ServiceException e) {
            throw new ServiceException(e);
        }
    }

    public static Set<User> createUsers(BaseBuilder builder, InputStream stream) throws ServiceException {
        try {
            builder.buildUsers(stream);
            return builder.getUsers();
        } catch (ServiceException e) {
            throw new ServiceException(e);
        }
    }
}
