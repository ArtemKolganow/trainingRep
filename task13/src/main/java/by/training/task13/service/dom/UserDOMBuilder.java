package by.training.task13.service.dom;

import by.training.task13.entity.Order;
import by.training.task13.entity.Product;
import by.training.task13.entity.User;
import by.training.task13.entity.UserInfo;
import by.training.task13.service.BaseBuilder;
import by.training.task13.service.ServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class UserDOMBuilder implements BaseBuilder {
    Set<User> users;
    private DocumentBuilder docBuilder;

    public UserDOMBuilder() throws ServiceException {
        users = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }



    @Override
    public void buildUsers(String fileName) throws ServiceException {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList userList = root.getElementsByTagName("user");
            for (int i = 0; i < userList.getLength(); i++) {
                Element userElement = (Element) userList.item(i);
                User user = buildUser(userElement);
                users.add(user);
            }
        } catch (IOException | SAXException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void buildUsers(InputStream file) throws ServiceException {
        Document doc;
        try {
            doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();
            NodeList userList = root.getElementsByTagName("user");
            for (int i = 0; i < userList.getLength(); i++) {
                Element userElement = (Element) userList.item(i);
                User user = buildUser(userElement);
                users.add(user);
            }
        } catch (IOException | SAXException e) {
            throw new ServiceException(e);
        }
    }

    private User buildUser(Element userElement){
        User user = new User();
        user.setId(Integer.parseInt(userElement.getAttribute("id")));
        user.setRole(Integer.parseInt(userElement.getAttribute("role")));
        user.setLogin(getElementTextContent(userElement, "login"));
        user.setPass(getElementTextContent(userElement, "pass"));
        user.setEmail(getElementTextContent(userElement, "email"));
        UserInfo info = new UserInfo();
        Element infoElement = (Element) userElement.getElementsByTagName("userInfo").item(0);
        info.setName(getElementTextContent(infoElement, "name"));
        info.setSurname(getElementTextContent(infoElement, "surname"));
        info.setPhoneNumber(getElementTextContent(infoElement, "phoneNumber"));
        user.setInfo(info);
        NodeList orderList = userElement.getElementsByTagName("order");
        for (int i = 0; i < orderList.getLength(); i++) {
            Element orderElement = (Element) orderList.item(i);
            Order order = buildOrder(orderElement);
            user.addOrder(order);
        }
        return user;
    }

    private Order buildOrder(Element orderElement){
        Order order = new Order();
        order.setOrderId(Integer.parseInt(orderElement.getAttribute("id")));
        order.setStatus(orderElement.getAttribute("status"));
        order.setDate(getElementTextContent(orderElement, "date"));
        order.setDeliviredate(getElementTextContent(orderElement, "deliviredate"));
        order.setPrice(Double.parseDouble(getElementTextContent(orderElement, "price")));
        NodeList productList = orderElement.getElementsByTagName("productlist");
        Element productListElement = (Element) productList.item(0);
        NodeList products = productListElement.getElementsByTagName("product");
        for(int i =0; i<products.getLength(); i++){
            Element productElement = (Element) products.item(i);
            Product product = buildProduct(productElement);
            order.addProduct(product);
        }
        return order;
    }

    private Product buildProduct(Element productElement){
        Product product = new Product();
        product.setProduct_id(Integer.parseInt(getElementTextContent(productElement, "product_id")));
        product.setQuantity(Integer.parseInt(getElementTextContent(productElement, "quantity")));
        return product;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
