package by.training.finalproject.controller.command;

import by.training.finalproject.controller.CommandProvider;
import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Command {
    private static final Logger logger = LogManager.getLogger(Login.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            UserService service = (UserService) factory.getService("User");
            String login = request.getParameter("login");
            logger.info(login);
            String pass = request.getParameter("password");
            logger.info(pass);
            User user = service.findByLoginAndPass(login,pass);
            Forward forward = new Forward();
            if(user.getLogin()!=null){
                OrderService orderService = (OrderService) factory.getService("Order");
                user.setOrder(orderService.readCompilationOrderByUserId(user.getId()));
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                ProductService productService = (ProductService) factory.getService("Product");
                request.setAttribute("productList",productService.readAllProducts());
                forward.setRedirect(false);
                forward.setUrl("WEB-INF/jsp/index.jsp");
                forward.forward(request, response);
            }else{
                forward.setRedirect(false);
                forward.setUrl("WEB-INF/jsp/SignIn.jsp");
                forward.forward(request, response);
            }
        } catch (ServiceException e) {
            Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
            forward.forward(request,response);
            logger.error(e);
        }
    }
}
