package by.training.task4ex2.service;

public class Service {
    public double triangleArea(int side){
        return side * side * (Math.sqrt(3)/2);
    }

    public double hexagonArea(int side){
        return triangleArea(side) * 6;
    }
}
