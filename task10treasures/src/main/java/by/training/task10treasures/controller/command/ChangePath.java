package by.training.task10treasures.controller.command;

import by.training.task10treasures.service.TreasureService;

public class ChangePath  implements Command {
    @Override
    public String exec(String request) {
        String[] req = request.split(Command.DELIMITER);
        TreasureService.changePath(req[0]);
        return "Путь изменен." + Command.DELIMITER+ req[1];
    }
}
