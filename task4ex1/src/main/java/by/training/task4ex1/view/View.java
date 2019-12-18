package by.training.task4ex1.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public List<Double> getCoordinate(){
        List<Double> coordinate = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты точки: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        coordinate.add(x);
        coordinate.add(y);
        return coordinate;
    }

    public void showArea(double area){
        System.out.println("Площадь тругольника равна: " + area);
    }
}
