package by.training.task13.controller;

import by.training.task13.service.Service;
import by.training.task13.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
public class Servlet extends javax.servlet.http.HttpServlet {
    private static final Logger logger = LogManager.getLogger(Servlet.class);
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String appPath = request.getServletContext().getRealPath("");
        String pathXSD = appPath + "\\WEB-INF\\classes\\xml\\xmlTest.xsd";
        Service service = new Service();
        try {
            Part filePart = request.getPart("file");
            InputStream fileContent = filePart.getInputStream();
            service.checkXSD(fileContent,pathXSD);
            logger.info("XML is valid");
            Controller controller = new Controller();
            response.setContentType("text/html");
            String parser = request.getParameter("parser");
            String language = request.getParameter("language");
            if(parser == null||language==null){
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }else {
                controller.execute(parser + " ", request, response);
                request.setAttribute("name", parser);
                request.setAttribute("language", language);

                getServletContext().getRequestDispatcher("/parser.jsp").forward(request, response);
            }
        }catch (ServiceException e) {
            logger.error(e);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
