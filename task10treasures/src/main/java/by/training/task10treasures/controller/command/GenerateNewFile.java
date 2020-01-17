package by.training.task10treasures.controller.command;

import by.training.task10treasures.service.TreasureGenerator;
import by.training.task10treasures.service.TreasureService;

import java.io.IOException;

public class GenerateNewFile implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        try {
            TreasureService.generateNewTreasures(req[0]);
        } catch (IOException e) {
            return "Ошибка при работе с файлом." + Command.DELIMITER + req[1];
        }
        return "Генерация прошла успешно." + Command.DELIMITER + req[1];
    }
}
