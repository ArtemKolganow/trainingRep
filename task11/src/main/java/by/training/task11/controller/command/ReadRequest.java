package by.training.task11.controller.command;

import by.training.task11.entity.Component;
import by.training.task11.service.Service;
import by.training.task11.service.ServiceException;

public class ReadRequest implements Command {
    @Override
    public String exec(String request, Component component) {
        String response;
        Service service= new Service();
        try {
            service.readText(request, component);
            response = "Чтение завершено успешно.";
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
