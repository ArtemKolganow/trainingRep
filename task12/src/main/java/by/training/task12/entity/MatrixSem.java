package by.training.task12.entity;

import java.util.concurrent.Semaphore;

public class MatrixSem extends Matrix {
    Semaphore sem;
    @Override
    public void set(int i, int j, int number) throws MatrixException {

        try {
            sem.acquire();
            if(i<matrix.length&&j<matrix[0].length) {
                matrix[i][j] = number;
            }else {
                throw new MatrixException("Ошибка размера матрицы.");
            }
        } catch (InterruptedException e) {
            throw new MatrixException(e);
        } finally {
            sem.release();
        }
    }

    public MatrixSem(String[] numbers, Semaphore sem) {
        super(numbers);
        this.sem = sem;
    }
}
