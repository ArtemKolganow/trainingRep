package by.training.finalproject.controller.filter;

import by.training.finalproject.controller.Forward;
import by.training.finalproject.controller.Servlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "CommandFilter")
public class CommandFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(CommandFilter.class);

    private static Map<String, String> commandMap = new HashMap<>();

    static {
        commandMap.put("/login", "LOGIN");
        commandMap.put("/SignIn", "TO_LOGIN_PAGE");
        commandMap.put("/", "MAIN");
        commandMap.put("/LogOut","LOGOUT");
        commandMap.put("/ToRegistration","TO_REGISTRATION_PAGE");
        commandMap.put("/registration","REGISTRATION");
        commandMap.put("/profile","PROFILE");
        commandMap.put("/toOrderList","ORDER_LIST");
        commandMap.put("/toUserList","USER_LIST");
        commandMap.put("/toCraftOrderList","CRAFT_ORDER_LIST");
        commandMap.put("/EditProfile","EDIT_PROFILE");
        commandMap.put("/ToOrder","TO_ORDER");
        commandMap.put("/Basket","BASKET");
        commandMap.put("/ConfirmOrder","CONFIRM_ORDER");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest)req;
        String contextPath = httpRequest.getContextPath();
        String uri = httpRequest.getRequestURI();
        int beginCommand = contextPath.length();
        int endCommand = uri.lastIndexOf('.');
        String commandName;
        if(endCommand >= 0) {
            commandName = uri.substring(beginCommand, endCommand);
        } else {
            commandName = uri.substring(beginCommand);
        }
        logger.info(commandName);
        String command = commandMap.get(commandName);
        if(command==null){
            Forward forward = new Forward(false,"WEB-INF/jsp/error.jsp");
            forward.forward((HttpServletRequest) req, (HttpServletResponse) resp);
        }
        logger.info(command);
        httpRequest.setAttribute("command", command);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
