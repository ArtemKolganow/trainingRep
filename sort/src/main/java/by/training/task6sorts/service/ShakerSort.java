package by.training.task6sorts.service;

import java.util.List;

public class ShakerSort implements Sort {

    public void sort(List<Integer> arr) {
        int left=0;
        int right = arr.size()-1;
        for(int i = 0; i<arr.size();i++){
            int lastSwap =0;
            for(int j=left;j<right;j++){
                if(arr.get(j+1)<arr.get(j)){
                    Integer temp = arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,temp);
                    lastSwap=j+1;
                }
            }
            right = lastSwap-1;
            for(int j=right;j>left;j--){
                if(arr.get(j-1)>arr.get(j)){
                    Integer temp = arr.get(j);
                    arr.set(j,arr.get(j-1));
                    arr.set(j-1,temp);
                    lastSwap=j-1;
                }
            }
            left = lastSwap+1;
        }
    }
}
