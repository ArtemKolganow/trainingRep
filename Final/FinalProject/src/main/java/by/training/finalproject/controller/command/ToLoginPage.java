package by.training.finalproject.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToLoginPage implements Command {
    private static final Logger logger = LogManager.getLogger(ToLoginPage.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("in forward");
            request.getRequestDispatcher("WEB-INF/jsp/SignIn.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
           logger.error(e);
        }
    }
}
