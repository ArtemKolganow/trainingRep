package by.training.task13.service.stax;

import by.training.task13.entity.Order;
import by.training.task13.entity.Product;
import by.training.task13.entity.User;
import by.training.task13.entity.UserInfo;
import by.training.task13.service.BaseBuilder;
import by.training.task13.service.ServiceException;
import by.training.task13.service.sax.UserEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UserStAXBuilder implements BaseBuilder {
    private static final Logger logger = LogManager.getLogger(UserStAXBuilder.class);
    private Set<User> users;
    private XMLInputFactory inputFactory;
    public UserStAXBuilder() {
        users = new HashSet<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildUsers(String fileName) throws ServiceException {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.USER) {
                        User user = buildUser(reader);
                        users.add(user);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException ex) {
            throw new ServiceException(ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new ServiceException(e);
            }

        }
    }

    @Override
    public void buildUsers(InputStream file) throws ServiceException {
        try(FileInputStream inputStream = (FileInputStream) file) {
            XMLStreamReader reader = null;
            String name;
            try {
                reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
                while (reader.hasNext()) {
                    int type = reader.next();
                    if (type == XMLStreamConstants.START_ELEMENT) {
                        name = reader.getLocalName();
                        if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.USER) {
                            User user = buildUser(reader);
                            users.add(user);
                        }
                    }
                }
            } catch (XMLStreamException ex) {
                throw new ServiceException(ex);
            }
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    private User buildUser(XMLStreamReader reader) throws ServiceException {
        User user = new User();
        user.setId(Integer.parseInt(reader.getAttributeValue(null, UserEnum.ID.getValue())));
        user.setRole(Integer.parseInt(reader.getAttributeValue(null,UserEnum.ROLE.getValue()))); // проверить на null
        String name;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (UserEnum.valueOf(name.toUpperCase())) {
                            case LOGIN:
                                user.setLogin(getXMLText(reader));
                                break;
                            case PASS:
                                user.setPass(getXMLText(reader));
                                break;
                            case EMAIL:
                                user.setEmail(getXMLText(reader));
                                break;
                            case USERINFO:
                                user.setInfo(getXMLInfo(reader));
                                break;
                            case ORDER:
                                user.addOrder(getXMLOrder(reader));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.USER) {
                            return user;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            throw new ServiceException(e);
        }
        throw new ServiceException("Unknown element in tag Student");

    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    private Order getXMLOrder(XMLStreamReader reader) throws ServiceException {
        Order order = new Order();
        int type;
        String name;
        order.setOrderId(Integer.parseInt(reader.getAttributeValue(null, UserEnum.ID.getValue())));
        order.setStatus(reader.getAttributeValue(null,UserEnum.STATUS.getValue()));
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (UserEnum.valueOf(name.toUpperCase())) {
                            case DATE:
                                order.setDate(getXMLText(reader));
                                break;
                            case DELIVIREDATE:
                                order.setDeliviredate(getXMLText(reader));
                                break;
                            case PRICE:
                                order.setPrice(Double.parseDouble(getXMLText(reader)));
                                break;
                            case PRODUCTLIST:
                                List<Product> products = getXMLProductList(reader);
                                for (Product i: products) {
                                    order.addProduct(i);
                                }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.ORDER) {
                            return order;
                        }
                        break;
                }
            }
            throw new XMLStreamException("Unknown element in tag Address");
        } catch (XMLStreamException e) {
            throw new ServiceException(e);
        }
    }

    private List<Product> getXMLProductList(XMLStreamReader reader) throws ServiceException{
        List<Product> products = new LinkedList<>();
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        products.add(getXMLProduct(reader));

                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.PRODUCTLIST) {
                            return products;
                        }
                        break;
                }
            }
            throw new XMLStreamException("Unknown element in tag Address");
        } catch (XMLStreamException e) {
            throw new ServiceException(e);
        }
    }

    private Product getXMLProduct(XMLStreamReader reader) throws ServiceException{
        Product product = new Product();
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (UserEnum.valueOf(name.toUpperCase())) {
                            case PRODUCT_ID:
                                product.setProduct_id(Integer.parseInt(getXMLText(reader)));
                                break;
                            case QUANTITY:
                                product.setQuantity(Integer.parseInt(getXMLText(reader)));
                                break;
                        }


                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.PRODUCT) {
                            return product;
                        }
                        break;
                }
            }
            throw new XMLStreamException("Unknown element in tag Address");
        } catch (XMLStreamException e) {
            throw new ServiceException(e);
        }
    }

    private UserInfo getXMLInfo(XMLStreamReader reader) throws ServiceException {
        UserInfo info = new UserInfo();
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        logger.info(name);
                        switch (UserEnum.valueOf(name.toUpperCase())) {
                            case NAME:
                                info.setName(getXMLText(reader));
                                break;
                            case SURNAME:
                                info.setSurname(getXMLText(reader));
                                break;
                            case PHONENUMBER:
                                info.setPhoneNumber(getXMLText(reader));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.USERINFO) {
                            return info;
                        }
                        break;
                }
            }
                throw new XMLStreamException("Unknown element in tag Address");
            } catch (XMLStreamException e) {
            throw new ServiceException(e);
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
