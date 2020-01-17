package by.training.task10treasures.controller.command;

import by.training.task10treasures.controller.RequestCreator;
import by.training.task10treasures.entity.Backpack;
import by.training.task10treasures.entity.Treasure;
import by.training.task10treasures.service.TreasureService;

import java.io.IOException;

public class AddToBackpack implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        RequestCreator creator = new RequestCreator();
        TreasureService service = new TreasureService();
        Backpack backpack = creator.requestToBackpack(req[1]);
        try {
            Treasure treasure = service.findTreasure(req[0]);
            if(treasure!=null){
                if(backpack.priceLeft()>=treasure.getPrice()) {
                    backpack.addTreasure(treasure);
                    return "Сокровище добавлено." + Command.DELIMITER + creator.backpackToRequest(backpack);
                }else {
                    return "Сокровище не подходит по лимиту." +Command.DELIMITER+ req[1];
                }
            }else{
                return "Такого сокровища нет." +Command.DELIMITER+ req[1];
            }
        } catch (IOException e) {
            return "Ошибка файла." + Command.DELIMITER + req[1];
        }

    }
}
