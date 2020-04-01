package by.training.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrongRequest implements Command {
    @Override
    public String exec(String requestStr, HttpServletRequest request, HttpServletResponse response) {
        return "Wrong Request";
    }
}
