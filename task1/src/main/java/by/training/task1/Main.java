package by.training.task1;

import java.util.Scanner;

public class Main {

    private static final int SMALL_MILK = 80;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        {
            System.out.println("-------------01------------");
            System.out.println("Введите количество малых бидонов: ");

            int smallNum = scanner.nextInt();
            int bigCapacity = smallNum / SMALL_MILK + 12;
            System.out.println("Введите количество больших бидонов: ");
            int bigNum = scanner.nextInt();
            int bigMilk = bigCapacity * bigNum;
            System.out.println("В больших бидонах " + Integer.toString(bigMilk) + " литров молока.");
        }
        {
            System.out.println("-------------02------------");
            System.out.println("Введите четырехзначное число: ");
            int startNum = scanner.nextInt();
            int thousand = startNum / 1000;
            int hundred = (startNum % 1000) / 100;
            int ten = ((startNum % 1000) % 100) / 10;
            int one = ((startNum % 1000) % 100) % 10;
            int res = thousand * hundred * ten * one;
            System.out.println("Результат произведения: " + res);
        }
        {
            System.out.println("-------------03------------");
            System.out.println("Введите коэффициенты: ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            double d = b * b - 4 * a * c;
            double x1 = (-b+Math.sqrt(d))/2/a;
            double x2 = (-b-Math.sqrt(d))/2/a;
            System.out.println("Корни уравнения :" + x1 + ", "+x2);
        }
        {
            System.out.println("-------------04------------");
            System.out.println("Введите числа: ");
            double m = scanner.nextDouble();
            double n = scanner.nextDouble();
            double number = m/n;
            String num = Double.toString(number);
            int dotPosition = num.indexOf(".");
            char left = num.charAt(dotPosition-1);
            char right = num.charAt(dotPosition+1);
            System.out.println("Последняя цифра целой части: " + left);
            System.out.println("Первая цифра дробной части: " + right);
        }
    }
}
