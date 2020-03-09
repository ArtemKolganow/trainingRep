package by.training.task13.service;

import by.training.task13.entity.User;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderAdapter;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class UsersSAXBuilder {
    private Set<User> users;
    private UserHandler handler;
    private XMLReader reader;

    public UsersSAXBuilder() throws ServiceException {
        handler = new UserHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            throw new ServiceException(e);
        }
    }

    public Set<User> getUsers() {
        return users;
    }
    public void buildSetStudents(String fileName) throws ServiceException {
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            throw new ServiceException(e);
        }
        users = handler.getUsers();
    }
}
