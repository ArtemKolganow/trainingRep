package by.training.finalproject.service;

import by.training.finalproject.dal.*;
import by.training.finalproject.dal.impl.UserDAOimpl;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServiceimpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceimpl.class);

    @Override
    public List<User> readAllUsers() throws ServiceException {

        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }

        try {
            try {
                logger.info("Come to service user.");
                Transaction transaction = factory.createTransaction();
                UserDAO dao = (UserDAO) transaction.createDao("UserDAO");
                List<User> users = dao.findAll();
                transaction.commit();
                return users;
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }

    @Override
    public User findById(int id) throws ServiceException {
        UserDAOimpl dao = new UserDAOimpl();
        try {
            return dao.findEntityById(id);
        } catch (DataObjectException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findByLoginAndPass(String login, String pass) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                logger.info("Come to service user.");
                Transaction transaction = factory.createTransaction();
                UserDAO dao = (UserDAO) transaction.createDao("UserDAO");
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(pass.getBytes());
                byte[] byteData = md.digest();
                StringBuilder hashPass = new StringBuilder();
                for (byte aByteData : byteData) {
                    String hex = Integer.toHexString(0xff & aByteData);
                    if (hex.length() == 1) hashPass.append('0');
                    hashPass.append(hex);
                }
                return dao.findEntityByLoginAndPass(login, hashPass.toString());
            } catch (DataObjectException | NoSuchAlgorithmException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
        throw new ServiceException("Error in close.",e);
    }
    }

    @Override
    public boolean addNewUser(User user) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                logger.info("Come to service user in register.");
                Transaction transaction = factory.createTransaction();
                UserDAO dao = (UserDAO) transaction.createDao("UserDAO");
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(user.getPass().getBytes());
                byte[] byteData = md.digest();
                StringBuilder hashPass = new StringBuilder();
                for (byte aByteData : byteData) {
                    String hex = Integer.toHexString(0xff & aByteData);
                    if (hex.length() == 1) hashPass.append('0');
                    hashPass.append(hex);
                }
                user.setPass(hashPass.toString());
                boolean res = dao.create(user);
                transaction.commit();
                return res;
            } catch (DataObjectException | NoSuchAlgorithmException e) {
                throw new ServiceException(e);
            }finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }
}
