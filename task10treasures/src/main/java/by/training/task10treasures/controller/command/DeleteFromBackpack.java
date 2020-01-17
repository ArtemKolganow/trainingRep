package by.training.task10treasures.controller.command;

import by.training.task10treasures.controller.RequestCreator;
import by.training.task10treasures.entity.Backpack;
import by.training.task10treasures.entity.Treasure;
import by.training.task10treasures.service.TreasureService;

import java.util.List;
import java.util.Set;

public class DeleteFromBackpack implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        RequestCreator creator = new RequestCreator();
        Backpack backpack = creator.requestToBackpack(req[1]);
        Treasure toDelete = findTreasure(backpack,req[0]);
        if(toDelete!=null){
            backpack.removeTreasure(toDelete);
            return "Сокровище удалено." + Command.DELIMITER + creator.backpackToRequest(backpack);
        }else {
            return "Такого сокровища в рюкзаке нет." + Command.DELIMITER + req[1];
        }
    }

    private Treasure findTreasure(Backpack backpack , String name){
        Set<Treasure> treasures = backpack.getTreasures();
        for(Treasure i:treasures){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
}
