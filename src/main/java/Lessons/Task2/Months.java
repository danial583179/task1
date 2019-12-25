package Lessons.Task2;

public enum Months {
    //мне влом писать код для февраля
    JANUARY(31), FEBRUARY(28),MARCH(31),
    APRIL(30),MAY(31),JUNE(30),
    JULE(31),AUGUST(31),SEPTEMBER(30),
    OCTOBER(31),NOVEMBER(30),DECEMBER(31);

    final int numberOfDays;

    Months(int numberOfDays){
        this.numberOfDays = numberOfDays;
    }

    public final int getMountNumber(){
        return this.ordinal() + 1;
    }

    public final int getNumberOfDays(){
        return numberOfDays;
    }

    public static final Months getMonthFromInt(int index){
        return Months.values()[index - 1];
    }

    public static final Months getMonthFromString(String month){
        return Months.valueOf(month);
    }


}
