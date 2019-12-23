package by.training.task5.ex3.service;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
    public List<Integer> getModuloM(ArrayList<Integer> arr, int m, int l) throws IllegalAccessException {
        if(l<m&&l>0) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for (Integer i : arr) {
                if (i % m == l) {
                    res.add(i);
                }
            }
            return res;
        }else {
            throw new IllegalAccessException("L is incorrect.");
        }
    }
}
