package by.training.task12.view;

import by.training.task12.entity.Matrix;
import by.training.task12.entity.MatrixException;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class View implements Show {
    @Override
    public void showMenu(){

    }

    @Override
    public void showMessage(String msg){
        System.out.println(msg);
    }
    @Override
    public int readInt(String message) throws InputException {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputException("Ошибка при вводе.");
        }
    }
    @Override
    public int readInt() throws InputException {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputException("Ошибка при вводе.");
        }
    }
    @Override
    public String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    @Override
    public String readString(String massage){
        System.out.println(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showMatrix(Matrix matrix){
        for(int i = 0; i< matrix.getLength();i++){
            for(int j =0; j< matrix.getLength();j++){
                try {
                    System.out.print(matrix.get(i,j) + " ");
                } catch (MatrixException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
