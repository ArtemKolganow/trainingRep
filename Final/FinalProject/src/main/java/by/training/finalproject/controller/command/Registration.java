package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.ServiceFactory;
import by.training.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements Command {
    private static final Logger logger = LogManager.getLogger(Registration.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
        ServiceFactory factory = new ServiceFactory();
        UserService service = (UserService) factory.getService("User");
        String login = request.getParameter("login");
        logger.info(login);
        String pass = request.getParameter("password");
        logger.info(pass);
        String email = request.getParameter("email");
        String pass2 = request.getParameter("confirmPassword");
        if(pass.equals(pass2)){
            User user = new User();
            user.setLogin(login);
            user.setEmail(email);
            user.setPass(pass);
            user.setRole(0);
            if(service.addNewUser(user)){
                Forward forward = new Forward(false,"WEB-INF/jsp/SignIn.jsp");
                forward.forward(request,response);
            }else {
                Forward forward = new Forward(false,"WEB-INF/jsp/Registration.jsp");
                forward.forward(request,response);
            }
        }else{
            Forward forward = new Forward(false,"WEB-INF/jsp/Registration.jsp");
            forward.forward(request,response);
        }
        } catch (ServiceException e) {
            Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
            forward.forward(request,response);
            logger.error(e);
        }
    }
}
