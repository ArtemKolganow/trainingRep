package by.training.task4ex2.figures;

import by.training.task4ex2.service.Service;

public class Hexagon {
    public double getHexagonArea(int side){
        if(side>0){
            Service service = new Service();
            return service.hexagonArea(side);
        } else {
            throw new IllegalArgumentException("Argument is wrong");
        }
    }
}
