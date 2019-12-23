package by.training.task6sorts.view;

import java.util.List;

public class View {
    public void showList(List<Integer> list){
        for(Integer i: list){
            System.out.print(i + " ");
        }
        System.out.println("||");
    }
}
