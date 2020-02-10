package by.training.task11.controller.command;

import by.training.task11.entity.Component;

public class ExitRequest implements Command {
    @Override
    public String exec(String request, Component component) {
        return "Exit.";
    }
}
