package Lessons.Task2;

import org.junit.*;

public class TestFinanceReportProcessor {

    private static FinanceReport fr1 = new FinanceReport("Finance Reporter Name","01:01:12",new Payment[]{
            new Payment("Ivan","1:2:3",500),
            new Payment("Igor","1:3:4",200),
            new Payment("Ioan","1:5:2",0),
            new Payment("Ildar","1:2:3",5100),
            new Payment("Ilya","1:8:29",5092300),
            new Payment("Andrey","1:1:5",500000),
            new Payment("Nik1","1:2:3",911100),
            new Payment("Nik2","1:3:5",1),
            new Payment("Nik3","1:4:5",1),
            new Payment("Nik4","1:6:5",1),
    });

    @Test
    public void TestGetReportBySurname(){
        Assert.assertEquals(new FinanceReport("Finance Reporter Name","01:01:12",new Payment[]{
                new Payment("Ivan","1:2:3",500),
                new Payment("Igor","1:3:4",200),
                new Payment("Ioan","1:5:2",0),
                new Payment("Ildar","1:2:3",5100),
                new Payment("Ilya","1:8:29",5092300)
        }).toString(), FinanceReportProcessor.getReportBySurname(fr1,"I").toString());
    }

    @Test
    public void TestGetReportByPayment(){
        Assert.assertEquals(new FinanceReport("Finance Reporter Name","01:01:12",new Payment[]{
                new Payment("Ivan","1:2:3",500),
                new Payment("Igor","1:3:4",200),
                new Payment("Ioan","1:5:2",0),
                new Payment("Nik2","1:3:5",1),
                new Payment("Nik3","1:4:5",1),
                new Payment("Nik4","1:6:5",1),
        }).toString(), FinanceReportProcessor.getReportByPayment(fr1,500).toString());
    }

    @Test
    public void TestGetPaymentByDate(){
        Assert.assertEquals(FinanceReportProcessor.getPaymentByDate(fr1,"1.2.3"),916700);
    }
    @Test
    public void TestGetMonthsWithoutPayments(){
        Assert.assertEquals(new Months[]{
                Months.FEBRUARY,Months.MAY,Months.JULE,Months.AUGUST,Months.SEPTEMBER,Months.OCTOBER,Months.NOVEMBER,Months.DECEMBER
                }, FinanceReportProcessor.getMonthsWithoutPayments(fr1,5));
    }
}
