package by.training.finalproject.controller;

import by.training.finalproject.dal.ConnectionPool;
import by.training.finalproject.dal.DataObjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Servlet.class);
    private String dbHost = "localhost";
    private String dbPort = "3306";
    private String dbName = "workshopdb";
    private String dbLogin = "workshop_user";
    private String dbPass = "workshop_password";
    private int maxConnections = 1000;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init(){

        String url = "jdbc:mysql://" + dbHost + ":"+ dbPort+"/" + dbName+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC"+
                "&allowPublicKeyRetrieval=true";
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            ConnectionPool.getInstance().init(url,dbLogin,dbPass,maxConnections);
        } catch (DataObjectException | SQLException e) {
            logger.error(e);
        }
    }
}
