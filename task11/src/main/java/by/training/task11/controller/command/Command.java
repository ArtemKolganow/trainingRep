package by.training.task11.controller.command;

import by.training.task11.entity.Component;

public interface Command {
    String exec(String request, Component component);
}
