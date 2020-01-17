package by.training.task10treasures.controller.command;

import by.training.task10treasures.controller.RequestCreator;
import by.training.task10treasures.entity.Treasure;
import by.training.task10treasures.view.View;

import java.util.ArrayList;

public class CheckBackpack implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        RequestCreator creator = new RequestCreator();
        ArrayList<Treasure> treasures = new ArrayList<>(creator.requestToBackpack(req[1]).getTreasures());
        View view = new View();
        view.showList(treasures);
        return " " + Command.DELIMITER + req[1];
    }
}
