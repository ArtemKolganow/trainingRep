package by.training.task5.view;

import java.util.List;

public class View {
    public void showArray(List<Integer> arr){
        for(Integer i:arr){
            System.out.print(i+"  ");
        }
        System.out.println("||");
    }

    public void showArrayModulo(List<Integer> arr, List<Integer> res, int m, int l){
        showArray(arr);
        System.out.println("Элементы массива, остаток от деления которых на " + m + " равен "+ l);
        showArray(res);
    }

    public void showSum(int sum,int k){
        System.out.println("Сумма элементов массива, крантых " + k + " равна: " + sum);
    }

    public void showMinAxisSize(int size){
        System.out.println("Минимальная длина числовой оси равна: " + size);
    }

    public void showMaxSum(int max) {
        System.out.println("Максимальная сумма элементов массива: " + max);
    }
}
