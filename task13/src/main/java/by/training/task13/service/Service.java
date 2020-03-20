package by.training.task13.service;

import by.training.task13.entity.User;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Service {
    public List<String> usersToString(Set<User> users){
        List<String> strings = new LinkedList<>();
        for (User i: users) {
            strings.add(i.toString());
        }
        return strings;
    }

    public String checkXSD(String xml, String xsd) throws ServiceException {
        String response;
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File(xsd);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xml);
            validator.validate(source);
            response = "XML is valid";
        } catch (SAXException | IOException e) {
           throw new ServiceException(e);
        }
        return response;
    }
    public String checkXSD(InputStream stream, String xsd) throws ServiceException {
        String response;
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File(xsd);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(stream);
            validator.validate(source);
            response = "XML is valid";
        } catch (SAXException | IOException e) {
            throw new ServiceException(e);
        }
        return response;
    }
}
