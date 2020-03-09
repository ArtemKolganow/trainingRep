package by.training.task13.service;
import by.training.task13.entity.Order;
import by.training.task13.entity.Product;
import by.training.task13.entity.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class UserHandler extends DefaultHandler {
    private Set<User> users;
    private User currentUser = null;
    private Order currentOrder = null;
    private Product currentProduct = null;
    private UserEnum currentEnum = null;
    private EnumSet<UserEnum> withText;

    public UserHandler() {
        users = new HashSet<>();
        withText = EnumSet.range(UserEnum.LOGIN, UserEnum.QUANTITY);
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("user".equals(localName)) {
            currentUser = new User();
            currentUser.setId(Integer.parseInt(attributes.getValue(0)));
            currentUser.setRole(Integer.parseInt(attributes.getValue(1)));

        } else if("order".equals(localName)){
            currentOrder = new Order();
            currentOrder.setOrderId(Integer.parseInt(attributes.getValue(0)));
            currentOrder.setStatus(attributes.getValue(1));
        }else if("product".equals(localName)){
            currentProduct= new Product();
        }
        else {
            UserEnum temp = UserEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("user".equals(localName)) {
            users.add(currentUser);
            currentUser = null;
        } else if("order".equals(localName)){
            currentUser.addOrder(currentOrder);
            currentOrder = null;
        }else if("product".equals(localName)){
            currentOrder.addProduct(currentProduct);
            currentProduct = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case LOGIN:
                    currentUser.setLogin(s);
                    break;
                case PASS:
                    currentUser.setPass(s);
                    break;
                case EMAIL:
                    currentUser.setEmail(s);
                    break;
                case NAME:
                    currentUser.getInfo().setName(s);
                    break;
                case SURNAME:
                    currentUser.getInfo().setSurname(s);
                    break;
                case PHONENUMBER:
                    currentUser.getInfo().setPhoneNumber(s);
                    break;
                case DATE:
                    currentOrder.setDate(s);
                    break;
                case DELIVIREDATE:
                    currentOrder.setDeliviredate(s);
                    break;
                case PRICE:
                    currentOrder.setPrice(s);
                    break;
                case PRODUCT_ID:
                    currentProduct.setProduct_id(Integer.parseInt(s));
                    break;
                case QUANTITY:
                    currentProduct.setQuantity(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
            currentEnum = null;
        }
    }
}
