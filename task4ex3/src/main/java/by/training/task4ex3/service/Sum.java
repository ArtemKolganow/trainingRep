package by.training.task4ex3.service;

import java.util.List;

public class Sum {
    public int getSum(List<Integer> arr, int start, int end){
        int sum = 0;
        for( int i = start; i<=end;++i){
            sum+=arr.get(i);
        }
        return sum;
    }
}
