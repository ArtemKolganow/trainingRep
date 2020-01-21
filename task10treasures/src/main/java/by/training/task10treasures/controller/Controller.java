package by.training.task10treasures.controller;


import by.training.task10treasures.controller.command.Command;

class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final String PARAM_DELIMITER = " ";

    String execute(String request) {
        String commandName;
        Command executionCommand;
        String delimiter;
        if (request.contains(PARAM_DELIMITER) &&request.indexOf(PARAM_DELIMITER)<request.indexOf(Command.DELIMITER)) {
            delimiter = PARAM_DELIMITER;
        } else {
            delimiter = Command.DELIMITER;
        }
        commandName = request.substring(0, request.indexOf(delimiter));
        executionCommand = provider.getCommand(commandName);
        String response;
        request = request.substring(request.indexOf(delimiter)).trim();
        response = executionCommand.exec(request);
        return response;
    }
}
