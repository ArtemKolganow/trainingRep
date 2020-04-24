package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut implements Command {
    private static final Logger logger = LogManager.getLogger(LogOut.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        Forward forward = new Forward(false,"WEB-INF/jsp/index.jsp");
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("authorizedUser");
            ProductService productService = (ProductService) factory.getService("Product");
            request.setAttribute("productList",productService.readAllProducts());
            forward.forward(request,response);
        } catch (ServletException | IOException | ServiceException e) {
           logger.error(e);
        }
    }
}
