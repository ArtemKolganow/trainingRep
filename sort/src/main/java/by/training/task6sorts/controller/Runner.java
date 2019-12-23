package by.training.task6sorts.controller;

import by.training.task6sorts.service.*;
import by.training.task6sorts.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Sort sort = new BinaryInsertSort();
        View view = new View();
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i =0; i<10; i++){
            arr.add(random.nextInt(15));
        }
        view.showList(arr);
        sort.sort(arr);
        view.showList(arr);
    }
}
