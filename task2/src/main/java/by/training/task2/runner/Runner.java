package by.training.task2.runner;

import by.training.task2.ex1.Max;
import by.training.task2.ex2.Plane;
import by.training.task2.ex3.FireDetector;
import by.training.task2.ex4.Date;

public class Runner {
    public static void main(String[] args) {
        System.out.println("----------1-----------");
        Max max = new Max();
        System.out.print("Большше число :");
        System.out.println(max.getMax(10,15));
        System.out.println("----------2-----------");
        Plane plane = new Plane();
        char position = plane.getQuarter(-8,5);
        if(position=='y'||position=='x'){
            System.out.println("Точка находится на оси " + position);
            }else {
                System.out.println("Точка находится в " + position + " четверти.");
            }
        System.out.println("----------3-----------");
        FireDetector fireDetector = new FireDetector();
        String res = fireDetector.newTemperature(68);
        System.out.println(res);
        System.out.println("----------4-----------");
        Date date = new Date();
        System.out.println(date.getTextDate(355));

    }
}
