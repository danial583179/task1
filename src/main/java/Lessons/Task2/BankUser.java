package Lessons.Task2;

import java.util.Objects;

abstract public class BankUser implements Cloneable {
    private Date date;
    private String name;
    public BankUser(String name,int day,int month,int year){
        this.date = new Date(day, month, year);
        this.name = name;
    }

    public BankUser(String name,String date){
        this.date  = new Date(date);
        this.name = name;
    }

    public BankUser(String name,Date date){
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("name can't be null");
        }
        this.name = name;
    }

    public void setDate(Date date){
        this.date  = date;
    }

    public Date getDate(){return date;}

    @Override
    public String toString() {
        return "BankUser{" +
                "date=" + date.toString() +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankUser bankUser = (BankUser) o;
        return Objects.equals(date, bankUser.date) &&
                Objects.equals(name, bankUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
