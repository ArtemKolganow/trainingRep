package by.training.task10treasures.controller.command;

public class ExitRequest implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        return "Exit."+DELIMITER + req[1];
    }
}
