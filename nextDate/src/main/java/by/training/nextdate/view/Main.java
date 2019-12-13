package by.training.nextdate.view;

import by.training.nextdate.beans.Date;
import by.training.nextdate.controller.DateValidation;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ex = false;
        while (!ex) {
            System.out.println("Input date: ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            DateValidation validation = new DateValidation();
            try {
               Date now = new Date(day,month,year);
               Date next = validation.nextDate(now);
                System.out.println("Next date :" + next.toString());
            }catch (Exception ignored){}

            System.out.println("0 to exit");
            if(scanner.next().equals("0"))
            {
                ex = true;
            }
        }
    }


}
