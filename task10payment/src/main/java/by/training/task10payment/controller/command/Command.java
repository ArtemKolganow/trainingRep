package by.training.task10payment.controller.command;

public interface Command {
    String PAYMENT_DELIMITER = "delimiter";
    String exec(String request);
}
