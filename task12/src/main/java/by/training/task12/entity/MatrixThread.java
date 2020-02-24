package by.training.task12.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixThread extends Thread {
    Matrix matrix;
    int number;
    int sequence;
    public MatrixThread(Matrix matrix, int number, int sequence){
        this.matrix = matrix;
        this.number= number;
        this.sequence = sequence;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < matrix.getLength();i+=sequence){
                if(matrix.get(i,i)==0)
                    matrix.set(i,i,number);
            }
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }
}
