package by.training.task07.controller;

import by.training.task07.service.MatrixException;
import by.training.task07.service.MatrixService;
import by.training.task07.view.InputException;
import by.training.task07.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        MatrixService service = new MatrixService();
        boolean exit = false;
        int[][] matrix = service.createMatrix(5,5);
        while (!exit){
            view.showMenuEx();
            try {
                switch (view.readInt("Выберите пункт: ")){
                    case 0:{
                        exit = true;
                        break;
                    }
                    case 1:{
                        view.showMatrix(service.exerciseOne(matrix));
                        break;
                    }
                    case 2:{
                        view.showMatrix(service.exerciseTwo(view.readInt("Введите порядок матрицы: ")));
                        break;
                    }
                    case 3:{
                        view.showMatrix(service.exerciseThree(view.readInt("Введите порядок матрицы: ")));
                        break;
                    }
                    case 4:{
                        view.showMatrix(service.exerciseFour(matrix));
                        break;
                    }
                    case 5:{
                        view.showMatrix(matrix);
                        break;
                    }
                    case 6:{
                        matrix = service.createMatrix(5,5);
                        break;
                    }
                    default:{view.printMassage("Ошибка ввода.");}

                }
            } catch (InputException | MatrixException e) {
                e.printStackTrace();
            }
        }
    }
}
