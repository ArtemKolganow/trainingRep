package by.training.task10payment.controller.command;

import java.util.regex.Pattern;

public class ExitRequest implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        return "Exit."+PAYMENT_DELIMITER + req[1];
    }
}
