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
import java.io.IOException;

public class Main implements Command {
    private static final Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            logger.info("in main");
            ProductService productService = (ProductService) factory.getService("Product");
            request.setAttribute("productList",productService.readAllProducts());
            Forward forward = new Forward(false,"WEB-INF/jsp/index.jsp");
            forward.forward(request,response);
        } catch (ServiceException e) {
            Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
            forward.forward(request,response);
            logger.error(e);
        }
    }
}
