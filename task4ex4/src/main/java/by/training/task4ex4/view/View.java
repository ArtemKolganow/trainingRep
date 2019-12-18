package by.training.task4ex4.view;

import java.util.List;
import java.util.Scanner;

public class View {
    public void showTwins(List<Integer> twins){
        for(int i =0; i< twins.size()/2;i+=2) {
            System.out.println("Близнецы: " + twins.get(i) + " и " + twins.get(i+1));
        }
    }

    public int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        return scanner.nextInt();
    }
}
