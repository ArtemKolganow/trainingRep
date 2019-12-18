package by.training.task4ex4.service;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumbers {
    public List<Integer> getTwins(int n){
        if(n<2){throw new IllegalArgumentException("Argument most be higher then 2.");}
        ArrayList<Integer> twins = new ArrayList<Integer>();
        for(int i = n; i < n*2-2;i++){
            if(isSimple(i)&&isSimple(i+2)){
                twins.add(i);
                twins.add(i+2);
            }
        }
        return twins;
    }

    public boolean isSimple(int number){
        for(int i = 2; i<number;i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
