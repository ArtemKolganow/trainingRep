package by.training.nextdate.service;

import by.training.nextdate.beans.Date;

public class CalculateNextDate extends Date {

    public CalculateNextDate(int day, int month, int year) {
        super(day, month, year);
    }

    public void nextDay()
    {
        setDay(getDay()+1);
    }

    public void nextMonth(){
        setDay(1);
        setMonth(getMonth()+1);
    }

    public void nextYear() {
        setDay(1);
        setMonth(1);
        setYear(getYear() + 1);
    }
}
