package by.training.task4ex1.controller;

import by.training.task4ex1.service.Triangle;
import by.training.task4ex1.view.View;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        List<Double> firstCoordinate = view.getCoordinate();
        List<Double> secondCoordinate = view.getCoordinate();
        List<Double> thirdCoordinate = view.getCoordinate();
        Triangle triangle = new Triangle();
        view.showArea(triangle.getAreaFromCoordinate(firstCoordinate,secondCoordinate,thirdCoordinate));
    }
}
