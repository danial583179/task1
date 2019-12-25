package Lessons.Task2;

import java.util.Objects;

public class Payment extends BankUser implements Cloneable{
    private int payment;

    public Payment(String name, int day, int month, int year, int payment) {
        super(name, day, month, year);
        this.payment = payment;
    }

    public Payment(String name, String date, int payment) {
        super(name, date);
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public Date getDate(){
        return super.getDate();
    }

    @Override
    public String toString() {
        return String.format("Плательщик: %s ,дата: %d.%d.%d сумма %d рублей %02d копеек",super.getName(),super.getDate().getDay(),
                super.getDate().getMonth(),super.getDate().getYear(),payment/100,payment%100);
        /*
        return "Payment{" +
                "payment=" + payment +
                "}, " + super.toString();*/
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Payment newPayment = (Payment) super.clone();
        newPayment.payment = this.payment;
        return newPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Payment payment1 = (Payment) o;
        return this.toString().equals(payment1.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payment);
    }

    public static void main(String[] args) {
        Payment pm = new Payment("Вася",1,10,2019,105);
        System.out.println(pm.toString());
    }
}
