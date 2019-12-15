package by.training.task2.ex2;

public class Plane {
    public char getQuarter(int x, int y)
    {
        if(x == 0)
            return 'y';
        else if(y == 0)
            return 'x';
        else if(x>0 && y>0)
            return '1';
        else if (x<0&&y>0)
            return '2';
        else if(x<0&&y<0)
            return '3';
        else return '4';
    }
}
