package by.training.task4ex4.controller;

import by.training.task4ex4.service.SimpleNumbers;
import by.training.task4ex4.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        SimpleNumbers simple = new SimpleNumbers();
        int n = view.getInt();
        view.showTwins(simple.getTwins(n));
    }
}
