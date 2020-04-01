package by.training.finalproject.controller;


import by.training.finalproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final String PARAM_DELIMITER = " ";

    String execute(String requestStr, HttpServletRequest request, HttpServletResponse response) {
        String commandName;
        Command executionCommand;
        commandName = requestStr.substring(0, requestStr.indexOf(PARAM_DELIMITER));
        executionCommand = provider.getCommand(commandName);
        String responseStr;
        requestStr = requestStr.substring(requestStr.indexOf(PARAM_DELIMITER)).trim();
        responseStr = executionCommand.exec(requestStr, request,response );
        return responseStr;
    }
}
