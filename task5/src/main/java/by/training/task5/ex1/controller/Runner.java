package by.training.task5.ex1.controller;

import by.training.task5.ex1.service.Array;
import by.training.task5.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Array array = new Array();
        View view = new View();
        Random random = new Random();
        for (int i =0; i< 10;i++){
            arr.add(random.nextInt(100));
        }
        int k = 4;
        view.showArray(arr);
        view.showSum(array.getSumAliquotK(arr,k),k);

    }
}
