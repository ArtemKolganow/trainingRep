package by.training.task11.controller.command;

import by.training.task11.entity.Component;
import by.training.task11.entity.Composite;
import by.training.task11.service.ServiceException;
import by.training.task11.service.sort.SortService;

public class SortLexemeRequest implements Command {
    @Override
    public String exec(String request, Component component) {
        Character character = request.charAt(0);
        String response;
        SortService service = new SortService();
        try {
            response = service.sortLexeme((Composite) component,character);
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
