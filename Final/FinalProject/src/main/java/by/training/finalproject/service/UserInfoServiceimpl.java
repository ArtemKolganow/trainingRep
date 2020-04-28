package by.training.finalproject.service;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.UserInfoDAO;
import by.training.finalproject.dal.transaction.Transaction;
import by.training.finalproject.dal.transaction.TransactionFactory;
import by.training.finalproject.dal.transaction.TrasactionFactoryimpl;
import by.training.finalproject.entity.UserInfo;

public class UserInfoServiceimpl implements UserInfoService {
    @Override
    public UserInfo readUserInfo(Integer id) throws ServiceException {
        TransactionFactory factory = null;
        try {
            factory =  new TrasactionFactoryimpl();
        } catch (DataObjectException e) {
            throw new ServiceException("Error in Transaction factory init.",e);
        }
        try {
            try {
                Transaction transaction = factory.createTransaction();
                UserInfoDAO dao = (UserInfoDAO) transaction.createDao("UserInfoDAO");
                UserInfo userInfo = dao.findEntityById(id);
                transaction.commit();
                return userInfo;
            } catch (DataObjectException e) {
                throw new ServiceException(e);
            } finally {
                factory.close();
            }
        } catch (DataObjectException e) {
            throw new ServiceException("Error in close.",e);
        }
    }
}
