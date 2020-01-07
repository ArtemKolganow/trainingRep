package by.training.task6sorts.service;

import java.util.List;

public class BinaryInsertSort implements Sort {

    public void sort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            Integer tmp = arr.get(i);
            Integer left = 0;
            Integer right = i;
            Integer border ;
            // Ищем позицию для элемента на  i позиции.
            while (left < right) {
                border = (left + right) / 2;
                if (arr.get(border) < tmp) {
                    left = border+1;

                } else {
                    right = border;
                }
            }
            //Сдвигаем элементы, освобождая место для элемента.



            for (int j = i; j > left; j--) {
                arr.set(j , arr.get(j-1));
            }
            arr.set(left, tmp);

        }

    }
}
