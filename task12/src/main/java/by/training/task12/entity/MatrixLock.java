package by.training.task12.entity;

import java.util.concurrent.locks.ReentrantLock;

public class MatrixLock extends Matrix {
    private ReentrantLock locker;
    public void set(int i, int j, int number) throws MatrixException {
        locker.lock();
        try {
            if(i<matrix.length&&j<matrix[0].length) {
                matrix[i][j] = number;
            }else {
                throw new MatrixException("Ошибка размера матрицы.");
            }
        } finally {
            locker.unlock();
        }

    }

    public MatrixLock(String[] numbers) {
        super(numbers);
        locker = new ReentrantLock();
    }
}
