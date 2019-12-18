package by.training.task4ex2.controller;

import by.training.task4ex2.figures.Hexagon;
import by.training.task4ex2.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Hexagon hexagon = new Hexagon();
        int side = view.getSide();
        double area = hexagon.getHexagonArea(side);
        view.viewArea(area);

    }
}
