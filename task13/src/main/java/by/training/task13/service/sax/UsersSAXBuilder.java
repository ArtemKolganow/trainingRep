package by.training.task13.service.sax;

import by.training.task13.entity.User;
import by.training.task13.service.BaseBuilder;
import by.training.task13.service.ServiceException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class UsersSAXBuilder implements BaseBuilder {
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

    @Override
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public void buildUsers(String fileName) throws ServiceException {
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            throw new ServiceException(e);
        }
        users = handler.getUsers();
    }

    @Override
    public void buildUsers(InputStream file) throws ServiceException {
        try {
            InputSource source = new InputSource();
            source.setByteStream(file);
            reader.parse(source);
        } catch (SAXException | IOException e) {
            throw new ServiceException(e);
        }
        users = handler.getUsers();
    }
}
