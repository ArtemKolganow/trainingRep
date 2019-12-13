package by.training.task1.Runner;

import by.training.task1.ex1.Milk;
import by.training.task1.ex2.MultiplyOfFourNumbers;
import by.training.task1.ex3.QuadraticEquation;
import by.training.task1.ex4.DigitsFromDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        System.out.println("-------------02------------");
        Milk milk = new Milk();
        System.out.println("Молока в больших бидонах: " + milk.getMilkInBig(3,5));
        System.out.println("-------------02------------");
        MultiplyOfFourNumbers multiply = new MultiplyOfFourNumbers();
        try {
            System.out.println("Произведение четырех цыфр числа: " + multiply.doMultiply(3412));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        System.out.println("-------------03------------");
        QuadraticEquation equation = new QuadraticEquation();
        List<Double> roots = equation.getRoots(1,5,6);
        System.out.println("Корни уравнения: " + roots.get(0) + ", " + roots.get(1));

            System.out.println("-------------04------------");
        DigitsFromDouble digitsFromDouble = new DigitsFromDouble();
        List<Character> digits = digitsFromDouble.getDigits(12,5);
        System.out.println("Последняя цифра целой части и первая цифра дробной части: " + digits.get(0) + ", " + digits.get(1));
    }
}
