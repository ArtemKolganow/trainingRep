package by.training.revers.controller;

import by.training.revers.service.Revers;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i< 9;++i){
            arr.add(random.nextInt());
        }
        for (Integer i : arr){
            System.out.println(i);
        }
        Revers revers = new Revers();
        revers.reversArrayList(arr);
        for (Integer i : arr){
            System.out.println(i);
        }
    }
}
