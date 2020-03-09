package by.training.task13.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private int role;
    private String login;
    private String pass;
    private String email;
    private UserInfo info;
    private List<Order> orders;

    public User() {
        info = new UserInfo();
        orders = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                role == user.role &&
                Objects.equals(login, user.login) &&
                Objects.equals(pass, user.pass) &&
                Objects.equals(email, user.email) &&
                Objects.equals(info, user.info) &&
                Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, login, pass, email, info, orders);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", info=" + info +
                ", orders=" + orders +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public int getOrdersSize(){
        return orders.size();
    }
}
