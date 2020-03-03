package by.training.task12.entity;


public abstract class Matrix {
    protected int[][] matrix;


    public int get(int i, int j) throws MatrixException {

        if(i<matrix.length&&j<matrix[0].length) {
            return matrix[i][j];
        }else {
            throw new MatrixException("Ошибка размера матрицы.");
        }
    }

    public abstract void set(int i, int j, int number) throws MatrixException;

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

    }

    public Matrix() {
    }
}
