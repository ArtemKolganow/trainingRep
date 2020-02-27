package by.training.task12.controller;

import by.training.task12.entity.Matrix;
import by.training.task12.service.Service;
import by.training.task12.service.ServiceException;
import by.training.task12.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {
        Service service = new Service();
        View view = new View();
        Controller controller = new Controller();
        try {
            Matrix matrix = service.formMatrixLock();
            controller.exec(view,service,matrix, "Lock: ");
            matrix = service.formMatrixSem();
            controller.exec(view,service,matrix, "Sem: ");
            matrix = service.formMatrixCountDown();
            controller.exec(view,service,matrix, "CountDown: ");
        } catch (ServiceException e) {
            logger.trace(e.getMessage());
        }


    }


}
