package by.training.task11.controller.command;

import by.training.task11.entity.Component;
import by.training.task11.entity.Composite;
import by.training.task11.service.ServiceException;
import by.training.task11.service.sort.SortService;

public class SortSentenceRequest implements Command {
    @Override
    public String exec(String request, Component component) {
        String response;
        String[] param = request.split(" ");
        SortService service = new SortService();
        try {
            service.sortSentence((Composite) component, Integer.parseInt(param[0]), Integer.parseInt(param[1]));
            response = "Сортировка завершена.";
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
