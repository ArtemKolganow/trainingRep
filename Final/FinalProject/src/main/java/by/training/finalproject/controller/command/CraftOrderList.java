package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import by.training.finalproject.service.CraftOrderService;
import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.ServiceFactory;
import by.training.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CraftOrderList implements Command{
    private static final Logger logger = LogManager.getLogger(CraftOrderList.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = new ServiceFactory();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            if (user != null) {
                CraftOrderService craftOrderService = (CraftOrderService) factory.getService("CraftOrder");
                if(user.getRole()==1) {
                    request.setAttribute("craftOrderList", craftOrderService.readAllCraftOrders());
                }else if (user.getRole()==0){
                    request.setAttribute("craftOrderList", craftOrderService.readCraftOrdersByUserId(user.getId()));
                }
                Forward forward = new Forward(false, "WEB-INF/jsp/CraftOrderList.jsp");
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
