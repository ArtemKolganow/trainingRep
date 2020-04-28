package by.training.finalproject.service;

import by.training.finalproject.entity.UserInfo;

public interface UserInfoService extends Service {
    UserInfo readUserInfo(Integer id) throws ServiceException;
}
