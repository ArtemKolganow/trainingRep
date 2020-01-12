package by.training.task09.view;

import by.training.task09.entity.text.Text;

import java.util.Scanner;

public class View {
    public void showMenu(){
        System.out.println("Выберите задание:");
        System.out.println("1- задание 1");
        System.out.println("2- задание 2");
        System.out.println("0- Выход");
    }


    public void showMassage(String msg){
        System.out.println(msg);
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
        return scanner.nextLine();
    }
}
