package by.training.task12.entity;

import by.training.task12.controller.Runner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private int[][] matrix;
    private ReentrantLock locker;

    public int get(int i, int j) throws MatrixException {

        if(i<matrix.length&&j<matrix[0].length) {
            return matrix[i][j];
        }else {
            throw new MatrixException("Ошибка размера матрицы.");
        }
    }

    public void set(int i , int j , int number) throws MatrixException {
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

    public int getLength(){
        return matrix.length;
    }

    public Matrix(String[] numbers) {
        matrix = new int[numbers.length][];
        for(int i = 0; i<numbers.length; i++){
            String[] number = numbers[i].split(" ");
            matrix[i] = new int[number.length];
            for(int j = 0; j<number.length; j++){
                matrix[i][j] = Integer.parseInt(number[j]);
            }
        }
        locker = new ReentrantLock();
    }

    public Matrix() {
    }
}
