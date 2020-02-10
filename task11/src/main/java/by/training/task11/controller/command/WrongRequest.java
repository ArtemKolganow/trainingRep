package by.training.task11.controller.command;

import by.training.task11.entity.Component;

public class WrongRequest implements Command {
    @Override
    public String exec(String request, Component component) {
        return "Wrong Request.";
    }
}
