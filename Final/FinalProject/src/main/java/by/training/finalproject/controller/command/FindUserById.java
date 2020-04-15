package by.training.finalproject.controller.command;

import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.UserServiceimpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindUserById implements Command {
    private static final Logger logger = LogManager.getLogger(FindUserById.class);
    @Override
    public void exec( HttpServletRequest request, HttpServletResponse response) {
        UserServiceimpl service = new UserServiceimpl();
        try {
            request.setAttribute("user",service.findById(Integer.parseInt(request.getParameter("id"))));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }
}
