package by.training.task3.ex3;

public class Factorial {
    public int calculate(int number){
        int res = 1;
        for (int i = 1; i <= number; i++){
            res *= i;
        }
        return res;
    }
}
