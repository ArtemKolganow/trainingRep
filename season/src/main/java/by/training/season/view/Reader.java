package by.training.season.view;

import by.training.season.controller.Seasons;
import by.training.season.service.Season;

import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seasons seasons = new Seasons();
        try {
            int num = scanner.nextInt();
            System.out.println(seasons.getSeason(num));
        }catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}
