package by.training.task5.ex2.controller;

import by.training.task5.ex2.servis.NumericalAxis;
import by.training.task5.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        NumericalAxis axis = new NumericalAxis();
        View view = new View();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random random = new Random();
        for (int i =0; i< 10;i++){
            arr.add(random.nextInt(100));
        }
        view.showArray(arr);
        view.showMinAxisSize(axis.getMinAxisSize(arr));
    }
}
