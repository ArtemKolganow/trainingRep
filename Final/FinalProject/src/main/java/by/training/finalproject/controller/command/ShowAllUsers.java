package by.training.finalproject.controller.command;

import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllUsers implements Command {
    private static final Logger logger = LogManager.getLogger(ShowAllUsers.class);
    @Override
    public String exec(String requestStr, HttpServletRequest request, HttpServletResponse response) {
        UserService service = new UserService();
        try {
            request.setAttribute("list",service.readAllUsers());
        } catch (ServiceException e) {
            logger.error(e);
        }
        return null;
    }
}
