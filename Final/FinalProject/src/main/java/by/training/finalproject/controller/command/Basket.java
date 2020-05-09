package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.RegisteredProductService;
import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Basket implements Command {
    private static final Logger logger = LogManager.getLogger(Basket.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            RegisteredProductService productService = (RegisteredProductService) factory.getService("RegisteredProduct");
            request.setAttribute("productList",productService.readByOrderId(user.getOrder().getId()));
            Forward forward = new Forward(false,"WEB-INF/jsp/Basket.jsp");
            forward.forward(request,response);
        } catch (ServiceException e) {
            Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
            forward.forward(request,response);
            logger.error(e);
        }
    }
}
