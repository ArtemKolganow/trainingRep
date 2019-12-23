package by.training.task6sorts.service;

import java.util.List;

public class SelectionSort implements Sort {
    public void sort(List<Integer> arr){
        for(int i =0; i < arr.size()-1;i++){
            int min = i;
            for(int j = i+1;j<arr.size();j++){
                if(arr.get(j)<arr.get(min)){
                    min = j;
                }
            }
            Integer temp = arr.get(i);
            arr.set(i,arr.get(min));
            arr.set(min,temp);
        }
    }
}
