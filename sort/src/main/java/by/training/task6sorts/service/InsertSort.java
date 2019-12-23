package by.training.task6sorts.service;

import java.util.List;

public class InsertSort implements Sort {
    public void sort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            for(int j = i;j>0;j--) {
                if (arr.get(j - 1) > arr.get(j)) {
                    Integer temp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, temp);
                }
            }
        }
    }
}
