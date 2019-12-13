package by.training.nextdate.service;

import by.training.nextdate.beans.Date;

public class CalculateNextDate extends Date {

    public CalculateNextDate(int day, int month, int year) {
        super(day, month, year);
    }

    public void nextDate(int type)
    {
        switch (type) {
            case 1: {
                setDay(getDay()+1);
                break;
            }
            case 2: {
                setDay(1);
                setMonth(getMonth()+1);
                break;
            }
            case 3: {
                setDay(1);
                setMonth(1);
                setYear(getYear()+1);
                break;
            }
        }
    }
}
