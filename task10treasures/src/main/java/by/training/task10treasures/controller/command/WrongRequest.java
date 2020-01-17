package by.training.task10treasures.controller.command;

public class WrongRequest implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        return "Wrong Request"+DELIMITER+ req[1];
    }
}
