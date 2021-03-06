package by.training.task09.controller;

import by.training.task09.view.InputException;
import by.training.task09.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();

        boolean exit = false;
        while (!exit){
            view.showMenu();
            try {
                switch (view.readInt("Выберите пункт: ")){
                    case 0:{
                        exit = true;
                        break;
                    }
                    case 1:{
                        TextController controller = new TextController();
                        controller.exerciseOne();
                        break;
                    }
                    case 2:{
                        BankController controller = new BankController();
                        controller.exerciseTwo();
                        break;
                    }
                    default:{
                        view.showMassage("Некорректный ввод.");
                    }
                }
            } catch (InputException e) {
                view.showMassage(e.getMessage());
            }
        }
    }
}
