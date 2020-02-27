package by.training.task12.entity;

public class MatrixThread extends Thread {
    private Matrix matrix;
    private int number;
    private int sequence;
    private int numberOfThreads;
    public MatrixThread(Matrix matrix, int number, int sequence, int numberOfThreads){
        this.matrix = matrix;
        this.number= number;
        this.sequence = sequence;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run() {
        try {
            for(int i = sequence; i < matrix.getLength(); i+=numberOfThreads){
                if(matrix.get(i,i)==0)
                    matrix.set(i,i,number);
            }
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }
}
