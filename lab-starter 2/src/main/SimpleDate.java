package main;

public class SimpleDate {
    int month;
    int day;
    int year;
    public SimpleDate(int month, int day, int year) {
        if(!rangesOK(month, day, year))
            throw new IllegalArgumentException("Invalid Date");
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day; }
    public void setDay(int day) {
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public boolean rangesOK(int month, int day, int year) {
        boolean dateOK = true;
        dateOK &= (year > 1841) && (year < 2043); // Year OK?
        dateOK &= (month > 0) && (month < 13); // Month OK?
        dateOK &= (day > 0) && (
                ((month == 1 || month == 3 || month == 5 || month == 7
                        || month == 8
                        || month == 10 || month == 12) && day < 32)
                        || ((month == 4 || month == 6 || month == 9 ||
                        month == 11) && day < 31)
                        || ((month == 2 && isLeap(year)) && day < 30)
                        || ((month == 2 && !isLeap(year)) && day < 29));
        return dateOK;
    }
    public boolean isLeap(int year) {
        boolean isLeapYear = true;
        if(year % 4 != 0)
            isLeapYear = false;
        else if(year % 100 != 0)
            isLeapYear = true;
        else if(year % 400 != 0)
            isLeapYear = false;
        return isLeapYear;
    }
    public boolean isLeap() {
        return isLeap(year);
    }
    @Override
    public boolean equals(Object obj) {
        boolean areEqual = false;
        if(obj instanceof SimpleDate simpleDate) {
            areEqual = simpleDate.getDay() == getDay() &&
                    simpleDate.getMonth() == getMonth() &&
                    simpleDate.getYear() == getYear();
        }
        return areEqual;
    }
}