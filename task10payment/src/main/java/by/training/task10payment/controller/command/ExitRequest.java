package by.training.task10payment.controller.command;

import java.util.regex.Pattern;

public class ExitRequest implements Command {
    @Override
    public String exec(String request) {
        Pattern pattern = Pattern.compile(Command.PAYMENT_DELIMITER);
        String[] req = pattern.split(request);
        return "Exit."+PAYMENT_DELIMITER + req[1];
    }
}
