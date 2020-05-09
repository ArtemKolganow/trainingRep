package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.OrderService;
import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.ServiceFactory;
import by.training.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserList implements Command {
    private static final Logger logger = LogManager.getLogger(UserList.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            if (user != null) {
                UserService userService = (UserService) factory.getService("User");
                request.setAttribute("userList", userService.readAllUsers());
                Forward forward = new Forward(false, "WEB-INF/jsp/UserList.jsp");
                forward.forward(request, response);
            } else {
                Forward forward = new Forward(false, "WEB-INF/jsp/SignIn.jsp");
                forward.forward(request, response);
            }
        } catch (ServiceException e) {
            Forward forward = new Forward(false, "WEB-INF/jsp/error.jsp");
            forward.forward(request, response);
            logger.error(e);
        }
    }
}
