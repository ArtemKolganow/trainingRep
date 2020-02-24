package by.training.task12.service;

import by.training.task12.dao.DataException;
import by.training.task12.dao.DataReader;
import by.training.task12.dao.Reader;
import by.training.task12.entity.Matrix;
import by.training.task12.entity.MatrixThread;

import java.util.LinkedList;
import java.util.List;

public class Service {
    public Matrix formMatrix() throws ServiceException {
        DataReader reader = new Reader();
        try {
            String[] matrixStrings = reader.readData("matrix.txt");
            return new Matrix(matrixStrings);
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
                threads.add(new MatrixThread(matrix,Integer.parseInt(numbers[i]),numbers.length-i));
            }
            return threads;
        } catch (DataException e) {
            throw new ServiceException(e);
        }

    }
}
