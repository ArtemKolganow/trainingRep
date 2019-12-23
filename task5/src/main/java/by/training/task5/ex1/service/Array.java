package by.training.task5.ex1.service;

import java.util.List;

public class Array {
    public int getSumAliquotK(List<Integer> arr, int k){
        int sum =0;
        for(Integer i: arr){
            if(i%k==0){
                sum += i;
            }
        }
        return sum;
    }
}
