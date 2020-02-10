package by.training.task11.controller.command;

import by.training.task11.entity.Component;
import by.training.task11.entity.Composite;
import by.training.task11.service.ServiceException;
import by.training.task11.service.sort.SortService;

public class SortParagraphRequest implements Command {
    @Override
    public String exec(String request, Component component) {
        String response;
        SortService service = new SortService();
        try {
            service.sortParagraph((Composite) component);
            response = "Сортировка завершена.";
        } catch (ServiceException e) {
            response = "Ошибка: " + e.getMessage();
        }
        return response;
    }
}
