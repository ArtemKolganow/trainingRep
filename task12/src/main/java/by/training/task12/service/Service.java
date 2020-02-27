package by.training.task12.service;

import by.training.task12.dao.DataException;
import by.training.task12.dao.DataReader;
import by.training.task12.dao.Reader;
import by.training.task12.entity.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Service {
    public MatrixLock formMatrixLock() throws ServiceException {
        DataReader reader = new Reader();
        try {
            String[] matrixStrings = reader.readData("matrix.txt");
            return new MatrixLock(matrixStrings);
        } catch (DataException e) {
            throw new ServiceException(e);
        }

    }

    public MatrixSem formMatrixSem() throws ServiceException {
        DataReader reader = new Reader();
        try {
            String[] matrixStrings = reader.readData("matrix.txt");
            return new MatrixSem(matrixStrings,new Semaphore(readThreadsSize()-1));
        } catch (DataException e) {
            throw new ServiceException(e);
        }

    }

    public MatrixCountDown formMatrixCountDown() throws ServiceException {
        DataReader reader = new Reader();
        try {
            String[] matrixStrings = reader.readData("matrix.txt");
            return new MatrixCountDown(matrixStrings,new CountDownLatch(readThreadsSize()-1));
        } catch (DataException e) {
            throw new ServiceException(e);
        }

    }

    public List<MatrixThread> formThreads(Matrix matrix) throws ServiceException {
        DataReader reader = new Reader();
        try {
            String[] matrixStrings = reader.readData("threads.txt");
            String[] numbers = matrixStrings[0].split(" ");
            List<MatrixThread> threads = new LinkedList<>();
            for (int i = 0; i < numbers.length; i++) {
                threads.add(new MatrixThread(matrix,Integer.parseInt(numbers[i]),i,numbers.length-1));
            }
            return threads;
        } catch (DataException e) {
            throw new ServiceException(e);
        }

    }

    public int readThreadsSize()throws ServiceException {
        DataReader reader = new Reader();
        try {
            String[] matrixStrings = reader.readData("threads.txt");
            String[] numbers = matrixStrings[0].split(" ");
            return numbers.length;
        } catch (DataException e) {
            throw new ServiceException(e);
        }
    }
}
