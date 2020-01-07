package by.training.task07.view;

import java.util.Scanner;

public class View {
    public void showMenuEx(){
        System.out.println("Выберите задание:");
        System.out.println("1- задание 6");
        System.out.println("2- задание 16");
        System.out.println("3- задание 25");
        System.out.println("4- задание 35");
        System.out.println("5- показать матрицу");
        System.out.println("6- новая матрица");
        System.out.println("0- Выход");
    }

    public int readInt(String massage) throws InputException {
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputException("Ошибка при вводе.");
        }
    }

    public int readInt() throws InputException {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputException("Ошибка при вводе.");
        }
    }

    public String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String readString(String massage){
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void showMatrix(int[][] a){
        if(a!=null&&a.length!=0&&a[0].length!=0) {
            for (int[] ints : a) {
                for (int j = 0; j < a[0].length; j++) {
                    System.out.print(ints[j] + "  ");
                }
                System.out.println();
            }
        }else {
            System.out.println("Матрица пуста или не существует.");
        }
    }

    public void printMassage(String msg){
        System.out.println(msg);
    }

}
