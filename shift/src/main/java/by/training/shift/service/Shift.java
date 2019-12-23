package by.training.shift.service;

import java.util.List;

public class Shift {
    public void shiftOneElement(List<Integer> arr, int index, int dist)throws IllegalArgumentException{
        if(index>=arr.size()||index+dist>arr.size()){
            throw new IllegalArgumentException("");
        }else {
            int temp = arr.get(index);
            for(int i =index; i<index+dist;i++ ) {
                arr.set(i,arr.get(i+1));
            }
            arr.set(index+dist,temp);
        }
    }

    public void shiftElements(List<Integer> arr, int index, int dist, int number)throws IllegalArgumentException{
        for(int i = index+number ; i>index;--i){
            shiftOneElement(arr,i,dist);
        }
    }

}
