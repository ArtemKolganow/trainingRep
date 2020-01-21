package by.training.task10treasures.controller.command;

import by.training.task10treasures.service.ServiceException;
import by.training.task10treasures.service.TreasureService;
import by.training.task10treasures.view.View;

public class ShowListOfTreasure implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        TreasureService service = new TreasureService();
        View view = new View();
        try {
            view.showList(service.readAllTreasures());
        } catch (ServiceException e) {
            return e.getMessage() + Command.DELIMITER + req[1];
        }
        return " " + Command.DELIMITER + req[1];
    }
}
