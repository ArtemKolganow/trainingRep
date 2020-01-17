package by.training.task10payment.controller.command;

import by.training.task10payment.service.PaymentService;

public class ChangePath implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        PaymentService.changePath(req[0]);
        return "Путь изменен."+PAYMENT_DELIMITER + req[1];
    }
}
