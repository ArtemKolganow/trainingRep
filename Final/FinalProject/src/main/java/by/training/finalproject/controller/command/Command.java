package by.training.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    void exec(HttpServletRequest request, HttpServletResponse response);
}
