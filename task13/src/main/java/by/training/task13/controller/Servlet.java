package by.training.task13.controller;

import by.training.task13.entity.User;
import by.training.task13.service.Service;
import by.training.task13.service.ServiceException;
import by.training.task13.service.UsersSAXBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Servlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {
            UsersSAXBuilder builder = new UsersSAXBuilder();
            builder.buildSetStudents("E:\\epam\\task13\\out\\artifacts\\task13_war_exploded\\WEB-INF\\classes\\xml\\xmlTest.xml");
            response.setContentType("text/html");
            Service service = new Service();
            request.setAttribute("list", service.usersToString(builder.getUsers()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/parser.jsp").forward(request,response);
    }
}
