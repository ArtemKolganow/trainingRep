package by.training.task5.ex4.service;

import java.util.List;

public class ArraySum {
    public int maxSumInArray(List<Integer> arr){
        int max = arr.get(0)+arr.get(arr.size()-1);
        for(int i=1;i<arr.size()/2;i++){
            if(arr.get(i)+arr.get(arr.size()-i-1)>max){
                max = arr.get(i)+arr.get(arr.size()-1-i);
            }
        }
        return max;
    }
}
