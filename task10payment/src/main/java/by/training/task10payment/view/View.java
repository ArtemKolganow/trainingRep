package by.training.task10payment.view;

import java.util.Scanner;

public class View {
    public void showMenu(){
        System.out.println("Выберите действие:");
        System.out.println("add name quantity  --  добавить товар к покупке");
        System.out.println("delete index  --  удалить товар из покупки");
        System.out.println("show  --  просмотр списка товаров");
        System.out.println("view  --  просмотр корзины");
        System.out.println("create name price weight  --  добавить новый товар в список");
        System.out.println("change newPath  --  изменить путь к файлу с товарами");
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
}
