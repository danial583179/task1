package Lessons.Task2;

import java.util.Arrays;

public class FinanceReport extends BankUser implements Cloneable{
    private Payment[] payments;


    public FinanceReport(String name,Date date,Payment[] payments){
        super(name, date);
        this.payments = payments;
    }

    public FinanceReport(String name, String date, Payment[] payments) {
        this(name,new Date(date),payments);
    }

    public FinanceReport(String name, int day, int month, int year, Payment[] payments) {
        this(name,new Date(day,month,year),payments);
    }

    public FinanceReport(FinanceReport financeReport) throws CloneNotSupportedException {
        super(financeReport.getName(),(Date) financeReport.getDate().clone());
        this.payments = new Payment[financeReport.length()];
        for(int i = 0;i < this.length();++i){
            this.payments[i] = (Payment) financeReport.getPayments()[i].clone();
        }
       //this =(FinanceReport) financeReport.clone();
    }

    public Payment paymentAt(int index){
        return payments[index];
    }

    public int length(){
        if(payments != null){
            return payments.length;
        }
        else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "FinanceReport{"  + super.toString() +
                "\npayments=" + Arrays.toString(payments) +
                "} ";
    }

    public Payment[] getPayments(){
        return payments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return Arrays.equals(payments, that.payments);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(payments);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FinanceReport newFinanceReport = (FinanceReport) super.clone();
        for(int i = 0;i < this.length();++i){
            newFinanceReport.getPayments()[i] = (Payment) this.getPayments()[i].clone();
        }
        return newFinanceReport;
    }

    public static void main(String[] args) {
        FinanceReport fr  = new FinanceReport("1",1,2,3,new Payment[]{
                new Payment("abc",1,2,3,500),
                new Payment("def",2,3,4,1000)});
        System.out.println(fr.toString());
    }
}
