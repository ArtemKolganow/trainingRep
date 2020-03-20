package by.training.task13.controller;

import by.training.task13.entity.User;
import by.training.task13.service.Service;
import by.training.task13.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;
import java.util.Set;

public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        String path = "src/main/resources/xml/xmlTest.xml";
        Service service = new Service();
        String valid = "XML has error.";
        try {
            valid = service.checkXSD("src/main/resources/xml/xmlTest.xml","src/main/resources/xml/xmlTest.xsd");
        } catch (ServiceException e) {
            logger.error(e);
        }
        logger.info(valid);
        Controller controller = new Controller();


    }

}
