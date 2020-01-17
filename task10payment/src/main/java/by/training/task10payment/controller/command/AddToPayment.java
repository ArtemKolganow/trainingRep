package by.training.task10payment.controller.command;

import by.training.task10payment.controller.RequestCreator;
import by.training.task10payment.entity.Payment;
import by.training.task10payment.service.PaymentService;

import java.io.IOException;

public class AddToPayment implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        if (Integer.parseInt(req[0].substring(req[0].indexOf(' ') + 1)) > 0) {
            RequestCreator creator = new RequestCreator();
            Payment payment = creator.requestToPayment(req[1]);
            PaymentService service = new PaymentService();
            try {
                service.addToPayment(payment, req[0].substring(0, req[0].indexOf(' ')), Integer.parseInt(req[0].substring(req[0].indexOf(' ') + 1)));
            } catch (IOException e) {
                return "Ошибка при чтении файла." + PAYMENT_DELIMITER + creator.paymentToRequest(payment);
            }catch (NumberFormatException e){
                return "Неверный формат числа." + PAYMENT_DELIMITER + creator.paymentToRequest(payment);
            }
            return "Добавление успешно." + PAYMENT_DELIMITER + creator.paymentToRequest(payment);
        } else {
            return "Неверное количество." + PAYMENT_DELIMITER + req[0];
        }
    }
}
