package by.training.task4ex3.controller;

import by.training.task4ex3.service.Sum;
import by.training.task4ex3.view.View;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Sum sum = new Sum();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i =0;i<10;i++){
            arr.add(i);
        }
        View view = new View();
        for(int i = 0; i< 7;++i){
            int res = sum.getSum(arr,i,i+2);
            view.showSum(res);
        }

    }
}
