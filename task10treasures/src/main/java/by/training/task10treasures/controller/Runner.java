package by.training.task10treasures.controller;

import by.training.task10treasures.controller.command.Command;
import by.training.task10treasures.entity.Backpack;
import by.training.task10treasures.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Backpack backpack = new Backpack(0);
        boolean isExit = false;
        Controller controller = new Controller();
        RequestCreator creator = new RequestCreator();
        while (!isExit){
            view.showMenu();
            String response = controller.execute(view.readString()+ Command.DELIMITER + creator.backpackToRequest(backpack));
            String[] res = response.split(Command.DELIMITER);
            backpack = creator.requestToBackpack(res[1]);
            view.showMessage(res[0]);
            if(res[0].equals("Exit.")){
                isExit = true;
            }
        }
    }
}
