package by.training.task10payment.controller.command;

import by.training.task10payment.controller.RequestCreator;
import by.training.task10payment.entity.Payment;

public class DeleteFromPayment implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        RequestCreator creator = new RequestCreator();
        Payment payment = creator.requestToPayment(req[1]);
        try {
            payment.removeProduct(Integer.parseInt(req[0]));
        }catch (IndexOutOfBoundsException e){
            return "Неверный индекс."+PAYMENT_DELIMITER + creator.paymentToRequest(payment);
        } catch (NumberFormatException e){
            return "Неверный формат числа." + PAYMENT_DELIMITER + creator.paymentToRequest(payment);
        }
        return "Товар удален."+PAYMENT_DELIMITER + creator.paymentToRequest(payment);
    }
}
