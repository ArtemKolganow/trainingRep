package by.training.task1.ex3;

import java.util.ArrayList;
import java.util.List;

public class QuadraticEquation {
    public List<Double> getRoots(double a, double b, double c)
    {
        double d = b * b - 4 * a * c;
        double x1 = (-b+Math.sqrt(d))/2/a;
        double x2 = (-b-Math.sqrt(d))/2/a;
        ArrayList<Double> roots = new ArrayList<Double>();
        roots.add(x1);
        roots.add(x2);
        return roots;
    }
}
