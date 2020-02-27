package by.training.task12.entity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MatrixCountDown extends Matrix {
    private CountDownLatch countDown;
    @Override
    public void set(int i, int j, int number) throws MatrixException {
        try {
            if(i<matrix.length&&j<matrix[0].length) {
                matrix[i][j] = number;
            }else {
                throw new MatrixException("Ошибка размера матрицы.");
            }
            countDown.await(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new MatrixException(e);
        }
    }

    public MatrixCountDown(String[] numbers, CountDownLatch countDown) {
        super(numbers);
        this.countDown = countDown;
    }

}
