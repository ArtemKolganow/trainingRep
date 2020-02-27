package by.training.task12.controller;

import by.training.task12.entity.Matrix;
import by.training.task12.entity.MatrixThread;
import by.training.task12.service.Service;
import by.training.task12.service.ServiceException;
import by.training.task12.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    public void exec(View view, Service service, Matrix matrix , String msg){
        try {
            view.showMessage(msg);
            List<MatrixThread> threads = service.formThreads(matrix);
            view.showMatrix(matrix);
            for (int i = 0; i < threads.size()-1;i++) {
                threads.get(i).start();
            }
            TimeUnit.MILLISECONDS.sleep(1000);
            threads.get(threads.size()-1).setNumberOfThreads(1);
            threads.get(threads.size()-1).setSequence(1);
            threads.get(threads.size()-1).start();
            TimeUnit.MILLISECONDS.sleep(1000);
            view.showMatrix(matrix);

        } catch (ServiceException | InterruptedException e) {
            logger.trace(e.getMessage());
        }
    }

}
