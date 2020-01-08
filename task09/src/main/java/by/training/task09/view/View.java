package by.training.task09.view;

import by.training.task09.entity.Text;

import java.util.Scanner;

public class View {
    public void showMenu(){
        System.out.println("Выберите задание:");
        System.out.println("1- задание 1");
        System.out.println("2- задание 2");
        System.out.println("0- Выход");
    }

    public void showMenuOne(){
        System.out.println("Задание 1: ");
        System.out.println("1- Добавить предложение");
        System.out.println("2- Показать текст");
        System.out.println("3- Показать заголовок текста");
        System.out.println("0- Выход");
    }

    public void showText(Text text){
        System.out.println(text.toString());
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
