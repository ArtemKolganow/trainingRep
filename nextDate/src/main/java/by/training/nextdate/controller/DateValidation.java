package by.training.nextdate.controller;

import by.training.nextdate.beans.Date;
import by.training.nextdate.service.CalculateNextDate;

public class DateValidation {
    public Date nextDate(Date date) throws Exception {
        CalculateNextDate next = new CalculateNextDate(date.getDay(),date.getMonth(),date.getYear());
        if (date.getDay() > 0 && date.getDay() < 32 && date.getMonth() > 0 && date.getMonth() < 13 && date.getYear() > 0) {
            if ((!date.isHigh() && date.getMonth() == 2 && date.getDay() > 28)   ||   ((date.getMonth() == 4 ||
                    date.getMonth() == 6 || date.getMonth() == 8 ||
                    date.getMonth() == 9 || date.getMonth() == 11) &&date.getDay()>30)){ throw new Exception();}
            if (date.getDay() < 28 || (date.isHigh() && date.getMonth() == 2 && date.getDay() == 28)||
                    (date.getDay()<30&&(date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 8 ||
                            date.getMonth() == 9 || date.getMonth() == 11))||
                    (date.getDay()<31&&(date.getMonth() == 1 || date.getMonth() == 3 || date.getMonth() == 5 ||
                            date.getMonth() == 7 || date.getMonth() == 8 || date.getMonth() == 10))) {
                next.nextDate(1);
            } else if ((date.getDay() == 30 && (date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 8 ||
                    date.getMonth() == 9 || date.getMonth() == 11)) || (date.getDay() == 31 && (date.getMonth() == 1 ||
                    date.getMonth() == 3 || date.getMonth() == 5 || date.getMonth() == 7 || date.getMonth() == 8 ||
                    date.getMonth() == 10)) || (date.isHigh() && date.getMonth() == 2 && date.getDay() == 29) ||
                    (!date.isHigh() && date.getMonth() == 2 && date.getDay() == 28)) {
               next.nextDate(2);
            } else if (date.getMonth() == 12 && date.getDay() == 31) {
               next.nextDate(3);
            }
        }
        return next;
    }
}
