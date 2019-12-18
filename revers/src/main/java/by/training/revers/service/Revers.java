package by.training.revers.service;

import java.util.ArrayList;

public class Revers {
    public void reversArrayList(ArrayList<Integer> arr){
        for(int i =0; i <arr.size()/2;i++){
            Integer temp = arr.get(arr.size()-1-i);
            arr.set(arr.size()-1-i,arr.get(i));
            arr.set(i,temp);
        }
    }
}
