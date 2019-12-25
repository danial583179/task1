package Lessons.Task2;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPayment {
    @Test
    public void TestConstructor() throws Exception {
        Payment payment = new Payment("ABC",1,1,0,123);
        Assert.assertEquals(payment.getName(),"ABC");
        Assert.assertEquals(payment.getDate().getDay(),1);
        Assert.assertEquals(payment.getDate().getMonth(),1);
        Assert.assertEquals(payment.getDate().getYear(),0);
        Assert.assertEquals(payment.getPayment(),123);

        Assert.assertNotNull(assertThrows(Exception.class,() -> {Payment payment1 = new Payment(null,0,0,0,0);}));
    }

    @Test
    public void TestSetters() throws Exception {
        Payment payment = new Payment("ABC",1,1,1,0);
        Assert.assertNotNull(assertThrows(Exception.class,()->{payment.setName(null);}));
        payment.setName("New Name");
        Assert.assertEquals(payment.getName(),"New Name");

        payment.getDate().setDay(2);
        Assert.assertEquals(payment.getDate().getDay(),2);

        payment.getDate().setMonth(2);
        Assert.assertEquals(payment.getDate().getMonth(),2);

        payment.getDate().setYear(2);
        Assert.assertEquals(payment.getDate().getYear(),2);
    }

    @Test
    public void TestEquals() throws Exception {
        Payment payment1 = new Payment("ABC",1,1,0,0);
        Payment payment2 = new Payment("ABC",1,1,0,0);
        Payment payment3 = new Payment("123",1,1,0,0);

        Assert.assertEquals(payment1,payment2);
        Assert.assertNotEquals(payment2,payment3);
    }
}
