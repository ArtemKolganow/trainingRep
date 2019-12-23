package by.training.task5.ex3.controller;

import by.training.task5.ex1.service.Array;
import by.training.task5.ex3.service.Modulo;
import by.training.task5.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        View view = new View();
        Modulo modulo = new Modulo();
        Random random = new Random();
        for (int i =0; i< 10;i++){
            arr.add(random.nextInt(100));
        }
        int m =5;
        int l = 2;
        try {
            view.showArrayModulo(arr,modulo.getModuloM(arr,m,l),m,l);
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }

    }
}
