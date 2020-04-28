package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToRegistrationPage implements Command {
    private static final Logger logger = LogManager.getLogger(ToRegistrationPage.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
            logger.info("in forward");
            Forward forward = new Forward(false,"WEB-INF/jsp/Registration.jsp");
            forward.forward(request,response);
    }
}
