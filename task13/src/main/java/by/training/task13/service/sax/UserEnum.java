package by.training.task13.service.sax;

public enum UserEnum {
    USERS("users"),
    USER("user"),
    USERINFO("userInfo"),
    ID("id"),
    ROLE("role"),
    ORDERID("orderId"),
    STATUS("status"),
    PRODUCT("product"),
    LOGIN("login"),
    PASS("pass"),
    EMAIL("email"),
    NAME("name"),
    SURNAME("surname"),
    PHONENUMBER("phoneNumber"),
    DATE("date"),
    DELIVIREDATE("deliviredate"),
    PRICE("price"),
    PRODUCT_ID("product_id"),
    QUANTITY("quantity"),

    PRODUCTLIST("productList"),
    INFO("info"),
    ORDER("order");



    private String value;
    UserEnum(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
