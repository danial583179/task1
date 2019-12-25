package Lessons.Task3.Task1.Classes.NestedVariablesTypes;

import java.util.Objects;

public class NotLessZeroInt {
    private int value;
    public NotLessZeroInt(int value){
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        if(value <= 0 ){
            throw new IllegalArgumentException("Weight can't be null");
        } else{
            this.value = value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotLessZeroInt that = (NotLessZeroInt) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
