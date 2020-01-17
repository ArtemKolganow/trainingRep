package by.training.task10treasures.controller.command;

public interface Command {
    String DELIMITER = "delimiter";
    String exec(String request);
}
