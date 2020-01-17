package by.training.task10payment.controller.command;

import by.training.task10payment.controller.RequestCreator;
import by.training.task10payment.entity.Payment;
import by.training.task10payment.view.View;

public class ViewPayment implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        RequestCreator creator = new RequestCreator();
        Payment payment = creator.requestToPayment(req[1]);
        View view = new View();
        view.showMessage(payment.toString());
        return "Конец." + Command.PAYMENT_DELIMITER + req[1];
    }
}
