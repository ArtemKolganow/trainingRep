package by.training.finalproject.controller.filter;

import by.training.finalproject.controller.Servlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "CommandFilter")
public class CommandFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(CommandFilter.class);

    private static Map<String, String> commandMap = new HashMap<>();

    static {
        commandMap.put("/login", "LOGIN");
        commandMap.put("/SignIn", "FORWARD");
        commandMap.put("/", "MAIN");
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
        logger.info(command);
        httpRequest.setAttribute("command", command);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
