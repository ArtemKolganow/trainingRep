package by.training.task3.ex1and2;

public class Sum {
    public int sumTo(int number){//first
        int res = 0;
        for(int i =1;i<=number;i++){
            res += i;
        }
        return res;
    }

    public int sumWithMultiply(){//second
        int res = 1;
        for (int i =2; i<=10;i++)
        {
            res *= sumTo(i);
        }
        return res;
    }
}
