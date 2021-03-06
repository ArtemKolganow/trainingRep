package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WrongRequest implements Command {
    private static final Logger logger = LogManager.getLogger(WrongRequest.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
        forward.forward(request,response);
    }
}
