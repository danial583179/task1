package Lessons.Task3.Task1.Classes.NestedVariablesTypes;

import java.util.Objects;

public class NotNullOrEmptyString {
    private String value;

    public NotNullOrEmptyString(String value){
        setValue(value);
    }

    public void setValue(String value){
        if(value == null || value.equals("")){
            throw new IllegalArgumentException("String can't be null");
        } else {
            this.value = value;
        }
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotNullOrEmptyString that = (NotNullOrEmptyString) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
