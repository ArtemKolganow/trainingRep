package by.training.task1.ex4;

import java.util.ArrayList;
import java.util.List;

public class DigitsFromDouble {
    public List<Character> getDigits(double m, double n){
        double number = m/n;
        String num = Double.toString(number);
        int dotPosition = num.indexOf('.');
        char left = num.charAt(dotPosition-1);
        char right = num.charAt(dotPosition+1);
        List<Character> result = new ArrayList<Character>();
        result.add(left);
        result.add(right);
        return  result;
        }
    }

