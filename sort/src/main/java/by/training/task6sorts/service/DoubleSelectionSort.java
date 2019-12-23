package by.training.task6sorts.service;

import java.util.List;

public class DoubleSelectionSort implements Sort {
    public void sort(List<Integer> arr){
        for(int i =0; i < arr.size()/2;i++){
            int min = i;
            int max = i;
            for(int j = i+1;j<arr.size()-i;j++){
                if(arr.get(j)<arr.get(min)){
                    min = j;
                }
                if(arr.get(j)>arr.get(max)){
                    max = j;
                }
            }
            Integer temp = arr.get(min);
            Integer temp1 = arr.get(max);
            arr.set(min,arr.get(i));
            arr.set(i,temp);
            arr.set(max,arr.get(arr.size()-1-i));
            arr.set(arr.size()-1-i,temp1);
        }
    }
}
