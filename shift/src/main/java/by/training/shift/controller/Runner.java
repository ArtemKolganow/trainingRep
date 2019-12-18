package by.training.shift.controller;

import by.training.shift.service.Shift;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i< 9;++i){
            arr.add(i);
        }
        for (Integer i : arr){
            System.out.print(i + "  ");
        }
        Shift shift = new Shift();
        shift.shiftElements(arr,2,3,2);
        System.out.println("");
        for (Integer i : arr){
            System.out.print(i + "  ");
        }
    }
}
