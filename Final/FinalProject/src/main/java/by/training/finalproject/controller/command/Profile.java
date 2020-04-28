package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profile implements Command {
    private static final Logger logger = LogManager.getLogger(Profile.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            if(user!=null) {
                UserInfoService userInfoService = (UserInfoService) factory.getService("UserInfo");
                user.setUserInfo(userInfoService.readUserInfo(user.getId()));
                Forward forward = new Forward(false, "WEB-INF/jsp/Profile.jsp");
                forward.forward(request, response);
            }else {
                Forward forward = new Forward(false, "WEB-INF/jsp/SignIn.jsp");
                forward.forward(request, response);
            }
        } catch (ServiceException e) {
            Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
            forward.forward(request,response);
            logger.error(e);
        }
    }
}
