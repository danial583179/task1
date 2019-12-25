package Lessons.Task2;


import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFinanceReport {

    @Test
    public void TestConstructor(){
        FinanceReport financeReport  = new FinanceReport("1",1,2,3,new Payment[]{
                new Payment("abc",1,2,3,500),
                new Payment("def",2,3,4,1000)});
        Assert.assertEquals(financeReport.getName(),"1");
        Assert.assertEquals(financeReport.getDate().getDay(),1);
        Assert.assertEquals(financeReport.getDate().getEnumMonth(),Months.FEBRUARY);
        Assert.assertEquals(financeReport.getDate().getYear(),3);
    }

    @Test
    public void TestCopyConstructor() throws CloneNotSupportedException {
        FinanceReport financeReport  = new FinanceReport("1",1,2,3,new Payment[]{
                new Payment("abc",1,2,3,500),
                new Payment("def",2,3,4,1000)});
        FinanceReport financeReport1 = new FinanceReport(financeReport);
        financeReport1.getPayments()[0].setPayment(1001);// new Payment("as",1,1,1,10001);
        Assert.assertNotEquals(financeReport,financeReport1);
    }

    @Test
    public void TestPaymentAt(){
        FinanceReport financeReport  = new FinanceReport("1",1,2,3,new Payment[]{
                new Payment("abc",1,2,3,500),
                new Payment("def",2,3,4,1000)});
        Assert.assertNotNull(assertThrows(ArrayIndexOutOfBoundsException.class,() ->{financeReport.paymentAt(4);}));
        Assert.assertEquals(financeReport.paymentAt(0).toString(),new Payment("abc",1,2,3,500).toString());
    }

    @Test
    public void TestLength(){
        FinanceReport financeReport  = new FinanceReport("1",1,2,3,new Payment[]{
                new Payment("abc",1,2,3,500),
                new Payment("def",2,3,4,1000)});
        Assert.assertEquals(financeReport.length(),2);
        Assert.assertEquals(new FinanceReport("1",1,2,3,null).length(),0);
    }
}
