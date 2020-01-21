package by.training.task10treasures.controller.command;

import by.training.task10treasures.service.ServiceException;
import by.training.task10treasures.service.TreasureService;

public class GenerateNewFile implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        try {
            TreasureService.generateNewTreasures(req[0]);
        } catch (ServiceException e) {
            return e.getMessage() + Command.DELIMITER + req[1];
        }
        return "Генерация прошла успешно." + Command.DELIMITER + req[1];
    }
}
