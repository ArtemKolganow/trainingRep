package by.training.task13.service;

import by.training.task13.entity.User;

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
}
