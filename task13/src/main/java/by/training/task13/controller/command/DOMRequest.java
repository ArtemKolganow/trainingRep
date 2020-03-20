package by.training.task13.controller.command;

import by.training.task13.service.Director;
import by.training.task13.service.Service;
import by.training.task13.service.ServiceException;
import by.training.task13.service.dom.UserDOMBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class DOMRequest implements Command {
    private static final Logger logger = LogManager.getLogger(DOMRequest.class);
    @Override
    public String exec(String requestStr, HttpServletRequest request, HttpServletResponse response) {
        String responseStr;
        Service service = new Service();
        try {
            Part filePart = request.getPart("file");
            InputStream fileContent = filePart.getInputStream();
            request.setAttribute("list",service.usersToString(Director.createUsers(new UserDOMBuilder(), fileContent)));
            responseStr = "DOM is ready.";
        } catch (ServiceException | IOException | ServletException e) {
            logger.error(e);
            responseStr = "Error";
        }
        return responseStr;
    }
}
