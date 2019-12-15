package by.training.task3.view;

import by.training.task3.ex1and2.Sum;
import by.training.task3.ex3.Factorial;
import by.training.task3.ex4.SearchNumbers;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("---------1---------");
        Sum sum = new Sum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        System.out.println("Сумма чисел от 1 до " + number + " равна " + sum.sumTo(number));
        System.out.println("---------2---------");
        System.out.println("Ответ заданного выражения: " + sum.sumWithMultiply());
        System.out.println("---------3---------");
        Factorial f = new Factorial();
        System.out.println("Введите число, факториал которого необходимо высчитать: ");
        int numToFactorial = scanner.nextInt();
        System.out.println("Факториал равен: " + f.calculate(numToFactorial));
        System.out.println("---------4---------");
        SearchNumbers searchNumbers = new SearchNumbers();
        System.out.println("Количество четных цифр в числе: " + searchNumbers.searchEvenDigits(6381).size());
    }
}
