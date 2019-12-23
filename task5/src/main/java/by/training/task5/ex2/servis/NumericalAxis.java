package by.training.task5.ex2.servis;

import java.util.ArrayList;

public class NumericalAxis {
    public int getMinAxisSize(ArrayList<Integer> arr){
        int max = arr.get(0);
        int min = arr.get(0);
        for(Integer i : arr){
            if(i>max){
                max = i;
            }else if(i<min){
                min = i;
            }
        }
        return max-min;
    }
}
