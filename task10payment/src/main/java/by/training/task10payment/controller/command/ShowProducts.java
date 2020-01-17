package by.training.task10payment.controller.command;

import by.training.task10payment.entity.Product;
import by.training.task10payment.service.PaymentService;
import by.training.task10payment.view.View;

import java.io.IOException;
import java.util.List;

public class ShowProducts implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.PAYMENT_DELIMITER);
        View view = new View();
        PaymentService service = new PaymentService();
        try {
            List<Product> list = service.getListOfProducts();
            for(Product i: list){
                view.showMessage(i.toString());
            }
        } catch (IOException e) {
           return "Ошибка чтения из файла."+PAYMENT_DELIMITER + req[1];
        }
        return "Чтение завершено."+PAYMENT_DELIMITER + req[1];
    }
}
