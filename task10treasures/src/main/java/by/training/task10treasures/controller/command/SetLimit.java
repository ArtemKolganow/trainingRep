package by.training.task10treasures.controller.command;

import by.training.task10treasures.controller.RequestCreator;
import by.training.task10treasures.entity.Backpack;
import by.training.task10treasures.entity.Treasure;

import java.util.HashSet;

public class SetLimit implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        RequestCreator creator = new RequestCreator();
        Backpack backpack = creator.requestToBackpack(req[1]);
        backpack.setPriceLimit(Integer.parseInt(req[0]));
        backpack.setTreasures(new HashSet<Treasure>());
        return "Новый лимит установлен." + Command.DELIMITER + creator.backpackToRequest(backpack);
    }
}
