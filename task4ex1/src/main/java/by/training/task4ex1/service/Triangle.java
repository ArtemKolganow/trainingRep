package by.training.task4ex1.service;

import java.util.List;

public class Triangle {
    public double getAreaFromCoordinate(List<Double> firstCoordinate, List<Double> secondCoordinate,
                                     List<Double> thirdCoordinate){
        return (1./2)*Math.abs(((secondCoordinate.get(0)-firstCoordinate.get(0))*(thirdCoordinate.get(1)-firstCoordinate.get(1))) -
                ((thirdCoordinate.get(0)-firstCoordinate.get(0))*(secondCoordinate.get(1) - firstCoordinate.get(1))));
    }
}
