package by.training.task10payment.controller.command;

public class WrongRequest implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        return "Wrong Request"+PAYMENT_DELIMITER+ req[1];
    }
}
