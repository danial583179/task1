package Lessons.Task2;

import java.util.Objects;

public class Date implements Cloneable{
    private int
                day,
                year;
    private Months month;
    {
        day = 1;
        month = Months.JANUARY;
        year = 0;
    }

    public Date(int day, int month, int year) {
        setDate(day,month,year);
    }

    public Date(String date){
        setDateFromString(date);
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month.ordinal() + 1;
    }

    public Months getEnumMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = Months.values()[month - 1];
    }

    public void setEnumMoth(Months month){
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int day,int month,int year){
        if(day < 1 || day > Months.getMonthFromInt(month).numberOfDays){
            throw new IllegalArgumentException("illegal day");
        }
        this.day = day;
        this.month = Months.getMonthFromInt(month);
        this.year = year;
    }

    public void setDateFromString(String date){
        int[] tmpDate = new int[3];
        String[] tmpDateString = date.split("\\D");
        if(tmpDateString.length != 3){
            throw new IllegalArgumentException("String is out of format dd \\D mm \\D yy");
        }
        for(int i = 0;i < 3;++i){
            tmpDate[i] = Integer.parseInt(tmpDateString[i]);
        }
        setDate(tmpDate[0],tmpDate[1],tmpDate[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return day +
                ":" + (month.ordinal() + 1) +
                ":" + year;
    }
}
