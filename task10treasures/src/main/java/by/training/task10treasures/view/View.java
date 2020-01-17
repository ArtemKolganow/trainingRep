package by.training.task10treasures.view;

import by.training.task10treasures.entity.Treasure;

import java.util.List;
import java.util.Scanner;

public class View {
    public void showMenu(){
        System.out.println("Выберите действие:");
        System.out.println("show  --  показать все сокровища");
        System.out.println("max  --  показать самое дорогое сокровище");
        System.out.println("limit number  --  задать сумму стоимости сокровищь");
        System.out.println("add name  --  добавить сокровище в рюкзак");
        System.out.println("delete name  --  удалить сокровище из рюкзака");
        System.out.println("check  --  показать содержимое рюкзака");
        System.out.println("change newPath  --  изменить путь к файлу с сокровищами");
        System.out.println("generate path  --  создать новый файл с сокровищами по заданному пути");
        System.out.println("exit  --  Выход");
    }


    public void showMessage(String msg){
        System.out.println(msg);
    }

    public int readInt(String message) throws InputException {
        System.out.print(message);
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
        return scanner.nextLine();
    }

    public String readString(String massage){
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showList(List<Treasure> list){
        for (Treasure i:list){
            System.out.println(i.toString());
        }
    }
}
