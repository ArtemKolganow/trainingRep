package by.training.task11.controller;


import by.training.task11.controller.command.Command;
import by.training.task11.entity.Component;

class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final String PARAM_DELIMITER = " ";

    String execute(String request, Component component) {
        String commandName;
        Command executionCommand;
        if(request.contains(PARAM_DELIMITER)) {
            commandName = request.substring(0, request.indexOf(PARAM_DELIMITER));
            request = request.substring(request.indexOf(PARAM_DELIMITER)).trim();
        }else{
            commandName = request;
            request = null;
        }
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.exec(request, component);
        return response;
    }
}
