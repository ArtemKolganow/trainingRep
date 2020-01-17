package by.training.task10payment.controller;

import by.training.task10payment.controller.command.Command;
import by.training.task10payment.entity.Payment;
import by.training.task10payment.service.PaymentService;
import by.training.task10payment.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Payment payment = new Payment(view.readString("Введите имя кассира: "), view.readString("Введите название магазина: "));
        boolean isExit = false;
        Controller controller = new Controller();
        RequestCreator creator = new RequestCreator();
        while (!isExit){
            view.showMenu();
            String response = controller.execute(view.readString()+ Command.PAYMENT_DELIMITER + creator.paymentToRequest(payment));
            String[] res = response.split(Command.PAYMENT_DELIMITER);
            payment = creator.requestToPayment(res[1]);
            view.showMessage(res[0]);
            if(res[0].equals("Exit.")){
                isExit = true;
            }
        }
    }
}
