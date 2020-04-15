package by.training.finalproject.controller;


import by.training.finalproject.controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private final CommandProvider provider = new CommandProvider();

    void execute(String requestStr, HttpServletRequest request, HttpServletResponse response) {
        Command executionCommand;
        logger.info("in controller");
        executionCommand = provider.getCommand(requestStr);
        executionCommand.exec( request,response );
    }
}
