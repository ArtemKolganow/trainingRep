package by.training.task10treasures.controller.command;

import by.training.task10treasures.service.TreasureService;
import by.training.task10treasures.view.View;

import java.io.IOException;

public class ShowMaxPrice implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        TreasureService service = new TreasureService();
        View view = new View();
        try {
            view.showMessage(service.findHighestPrice().toString());
        } catch (IOException e) {
            return "Ошибка при чтении файла." + Command.DELIMITER + req[1];
        }
        return " " + Command.DELIMITER + req[1];
    }
}
