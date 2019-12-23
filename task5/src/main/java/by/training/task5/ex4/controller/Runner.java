package by.training.task5.ex4.controller;

import by.training.task5.ex4.service.ArraySum;
import by.training.task5.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        View view = new View();
        ArraySum arraySum = new ArraySum();
        Random random = new Random();
        for (int i =0; i< 10;i++){
            arr.add(random.nextInt(100));
        }
        view.showArray(arr);
        view.showMaxSum(arraySum.maxSumInArray(arr));
    }
}
