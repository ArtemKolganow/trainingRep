package by.training.task13.controller;

import by.training.task13.service.ServiceException;
import by.training.task13.service.UsersSAXBuilder;

public class Runner {
    public static void main(String[] args) {
        try {
            UsersSAXBuilder builder = new UsersSAXBuilder();
            builder.buildSetStudents("src/main/resources/xml/xmlTest.xml");
            System.out.println(builder.getUsers());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

}
