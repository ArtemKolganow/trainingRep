package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.Order;
import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToOrder implements Command {
    private static final Logger logger = LogManager.getLogger(ToOrder.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            OrderService orderService = (OrderService) factory.getService("Order");
            ProductService productService = (ProductService) factory.getService("Product");
            Integer productId = Integer.parseInt(request.getParameter("id"));
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            if(user!=null){
                if(user.getOrder()==null) {
                    Order order = orderService.readCompilationOrderByUserId(user.getId());
                    if(order==null){
                        orderService.createNewOrder(user.getId());
                        order = orderService.readCompilationOrderByUserId(user.getId());
                    }
                    user.setOrder(order);
                }

                Product product = productService.readByID(productId);
                RegisteredProductService registeredProductService = (RegisteredProductService) factory.getService("RegisteredProduct");
                user.getOrder().addProductToOrder(registeredProductService.addNewRegisteredProduct(product,user.getOrder().getId(),quantity));
            }else{
                Cookie cookie = new Cookie("Basket",productId + " " + quantity);
            }
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
