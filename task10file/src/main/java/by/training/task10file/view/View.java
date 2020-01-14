package by.training.task10file.view;

import java.util.List;
import java.util.Scanner;

public class View {
    public void showMenu(){
        System.out.println("Выберите действие:");
        System.out.println("1- задать директорию");
        System.out.println("2- задать имя файла");
        System.out.println("3- создать файл");
        System.out.println("4- переименовать файл");
        System.out.println("5- показать содержимое файла");
        System.out.println("6- дополнить файл");
        System.out.println("7- удалить файл");
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

    public void showList(List<String> list){
        for (String i:list){
            System.out.println(i);
        }
    }

    public void showBool(boolean bool){
        if(bool){
            System.out.println("Действие завершено успешно.");
        }else {
            System.out.println("Действие не выполнено.");
        }
    }
}
