package by.training.task4ex2.view;

import java.util.Scanner;

public class View {
    public int getSide(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону шестиугольника: ");
        return scanner.nextInt();
    }
    public void viewArea(double area){
        System.out.println("Площадь шестиугольника равна: " + area);
    }

}
