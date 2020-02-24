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

public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {
        Service service = new Service();
        View view = new View();
        try {
            Matrix matrix = service.formMatrix();
            List<MatrixThread> threads = service.formThreads(matrix);
            view.showMatrix(matrix);
            for (MatrixThread i: threads) {
                i.start();
                i.join();
            }
            TimeUnit.MILLISECONDS.sleep(1000);
            view.showMatrix(matrix);
        } catch (ServiceException | InterruptedException e) {
            logger.trace(e.getMessage());
        }
    }
}
