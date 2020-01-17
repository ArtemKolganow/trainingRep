package by.training.task10payment.controller.command;

import by.training.task10payment.service.PaymentService;

import java.io.IOException;
import java.security.SecureRandom;

public class CreateNewProduct implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        PaymentService service = new PaymentService();
        String[] data = req[0].split(" ");
        try {
            service.addToFile(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        } catch (IOException e) {
            return "Ошибка добавления."+PAYMENT_DELIMITER + req[1];
        }catch (NumberFormatException e){
            return "Неверный формат числа."+PAYMENT_DELIMITER + req[1];
        }
        return "Товар добавлен."+PAYMENT_DELIMITER +req[1];
    }
}
