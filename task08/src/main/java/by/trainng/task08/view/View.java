package by.trainng.task08.view;

import by.trainng.task08.entity.House;

import java.util.Scanner;

public class View {
    public void showHouse(House house) {
        System.out.println(house.toString());
    }

    public void menu() {
        System.out.println("1- Добавить новые элементы.");
        System.out.println("2- Просмотр всех элементов.");
        System.out.println("3- Список квартир, имеющих заданное число комнат.");
        System.out.println("4- Список квартир, имеющих заданное число комнат и находящихся на этажах, заданных промежутком.");
        System.out.println("5- Список квартир, имеющих пощадь, превосходящую заданную.");
        System.out.println("6- Список квартир, имеющих пощадь, превосходящую заданную и заданный тип здания.");
        System.out.println("0- выход.");
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

    public House readHouse() throws InputException {
        int id = readInt("Введите ID:");
        int area = readInt("Введите площадь:");
        int floor = readInt("Введите этаж:");
        int numberOfRooms = readInt("Введите количество комнат:");
        String type = readString("Выберите тип здания:");
        int lifetime = readInt("Введите срок эксплуатации: ");
        String flatAddress = readString("Введите адрес: ");
        int flatNumber = readInt("Введите номер квартиры: ");
        return new House(id,area,floor,numberOfRooms,type,lifetime,flatAddress,flatNumber);
    }
}
