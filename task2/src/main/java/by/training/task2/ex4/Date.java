package by.training.task2.ex4;

public class Date {
    public String getTextDate(int day){
        while(true) {
            if (day <= 31) {
                return day + " Декабря";
            } else {
                day -= 31;
                if (day <= 28) {
                    return day + " Февраля";
                } else {
                    day -= 28;
                    if (day <= 31) {
                        return day + " Марта";
                    } else {
                        day -= 31;
                        if (day <= 30) {
                            return day + "Апреля";
                        } else {
                            day -= 30;
                            if (day <= 31) {
                                return day + " Мая";
                            } else {
                                day -= 31;
                                if (day <= 30) {
                                    return day + " Июня";
                                } else {
                                    day -= 30;
                                    if (day <= 31) {
                                        return day + " Июля";
                                    } else {
                                        day -= 31;
                                        if (day <= 31) {
                                            return day + " Августа";
                                        } else {
                                            day -= 31;
                                            if (day <= 30) {
                                                return day + " Сентября";
                                            } else {
                                                day -= 30;
                                                if (day <= 31) {
                                                    return day + " Октября";
                                                } else {
                                                    day -= 31;
                                                    if (day <= 30) {
                                                        return day + " Ноября";
                                                    } else {
                                                        day -= 30;
                                                        if (day <= 31) {
                                                            return day + " Декабря";
                                                        }else day -=31;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
