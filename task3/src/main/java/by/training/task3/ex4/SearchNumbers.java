package by.training.task3.ex4;

import java.util.ArrayList;
import java.util.List;

public class SearchNumbers {
    public List<Integer> searchEvenDigits(int number){
        String numString = Integer.toString(number);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i =0; i < numString.length(); i++) {
            Integer digit = Integer.parseInt(Character.toString(numString.charAt(i)));
            if(digit%2==0){
                res.add(digit);
            }
        }
        return res;
    }
}
