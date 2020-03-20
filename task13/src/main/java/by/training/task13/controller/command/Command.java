package by.training.task13.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String exec(String requestStr, HttpServletRequest request, HttpServletResponse response);
}
