package Lessons.Task2;

import java.util.ArrayList;
import java.util.Comparator;

public class FinanceReportProcessor {
    public static FinanceReport getReportBySurname(FinanceReport financeReport,String surname) {
        ArrayList<Payment> paymentList = new ArrayList<>();
        for (Payment payment : financeReport.getPayments()) {
            if(payment.getName().startsWith(surname.trim())){
                paymentList.add(payment);
            }
        }
        return new FinanceReport(financeReport.getName(),financeReport.getDate(),paymentList.toArray(new Payment[paymentList.size()]));
    }
    public static final FinanceReport getReportByPayment(FinanceReport financeReport,int paymentAmount){
        ArrayList<Payment> paymentList = new ArrayList<>();
        for (Payment payment : financeReport.getPayments()) {
            if(payment.getPayment() <= paymentAmount){
                paymentList.add(payment);
            }
        }
        return new FinanceReport(financeReport.getName(),financeReport.getDate(),paymentList.toArray(new Payment[paymentList.size()]));
    }

    public static final int getPaymentByDate(FinanceReport financeReport,String stringDate){
        Date date = new Date(stringDate);
        int sum = 0;
        for (Payment payment : financeReport.getPayments()) {
            if(payment.getDate().equals(date)){
                sum+=payment.getPayment();
            }
        }
        return sum;
    }

    public static final Months[] getMonthsWithoutPayments(FinanceReport financeReport,int year){
        ArrayList<Months> monthsWithPayments = new ArrayList<>();

        for(Payment payment:financeReport.getPayments()){
            if(payment.getDate().getYear() == year && !monthsWithPayments.contains(payment.getDate().getEnumMonth())){
                monthsWithPayments.add(payment.getDate().getEnumMonth());
            }
        }

        monthsWithPayments.sort(Comparator.naturalOrder());
        ArrayList<Months> monthsWithoutPayments = new ArrayList<>();
        for(Months month:Months.values()){
            if(!monthsWithPayments.contains(month)){
                monthsWithoutPayments.add(month);
            }
        }
        return monthsWithoutPayments.toArray(new Months[monthsWithoutPayments.size()]);
    }
}
