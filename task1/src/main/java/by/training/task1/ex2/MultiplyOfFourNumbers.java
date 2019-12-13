package by.training.task1.ex2;

public class MultiplyOfFourNumbers {
    public int doMultiply(int number) throws IllegalArgumentException
    {
        if(number>999&&number<10000) {
            int thousand = number / 1000;
            int hundred = (number % 1000) / 100;
            int ten = ((number % 1000) % 100) / 10;
            int one = ((number % 1000) % 100) % 10;
            return thousand * hundred * ten * one;
        } else {
            throw new IllegalArgumentException("Number must have 4 digits.");
        }
    }
}
