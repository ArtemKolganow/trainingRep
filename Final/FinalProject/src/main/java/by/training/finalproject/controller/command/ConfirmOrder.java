package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmOrder implements Command {
    private static final Logger logger = LogManager.getLogger(ConfirmOrder.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            if(user!=null) {
                if(!user.getOrder().getProductList().isEmpty()||user.getOrder().getCraftOrder()!=null){
                    OrderService orderService = (OrderService) factory.getService("Order");
                    orderService.confirmOrder(user.getOrder());
                }
                user.setOrder(null);
                ProductService productService = (ProductService) factory.getService("Product");
                request.setAttribute("productList",productService.readAllProducts());
                Forward forward = new Forward(false,"WEB-INF/jsp/index.jsp");
                forward.forward(request,response);
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
