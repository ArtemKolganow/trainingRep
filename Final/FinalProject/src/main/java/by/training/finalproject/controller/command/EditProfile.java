package by.training.finalproject.controller.command;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditProfile implements Command {
    private static final Logger logger = LogManager.getLogger(EditProfile.class);
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            if(user!=null) {
                Forward forward = new Forward(false, "WEB-INF/jsp/EditProfile.jsp");
                forward.forward(request, response);
            }else {
                Forward forward = new Forward(false, "WEB-INF/jsp/SignIn.jsp");
                forward.forward(request, response);
            }
    }
}
