package by.training.task1.ex1;

public class Milk {
    private static final int SMALL_MILK = 80;

    public int getMilkInBig(int smallNum, int bigNum){
        int bigCapacity = smallNum / SMALL_MILK + 12;
        return  bigCapacity * bigNum;

    }
}
