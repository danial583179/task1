package Lessons.Task2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDate {

    @Test
    public void TestConstructorViaInts(){
        Date date1 = new Date(1,1,1);
        Assert.assertEquals(date1.getDay(),1);
        Assert.assertEquals(date1.getMonth(),1);
        Assert.assertEquals(date1.getEnumMonth(),Months.JANUARY);
        Assert.assertEquals(date1.getYear(),1);
    }

    @Test
    public void TestConstructorViaString(){
        Assert.assertEquals(new Date("1.1.1").getEnumMonth(),Months.JANUARY);
        Assert.assertEquals(new Date("1.2.1").getEnumMonth(),Months.FEBRUARY);
        Assert.assertEquals(new Date("1.3.1").getEnumMonth(),Months.MARCH);
        Assert.assertEquals(new Date("1.4.1").getEnumMonth(),Months.APRIL);
        Assert.assertEquals(new Date("1.5.1").getEnumMonth(),Months.MAY);
        Assert.assertEquals(new Date("1.6.1").getEnumMonth(),Months.JUNE);
        Assert.assertEquals(new Date("1.7.1").getEnumMonth(),Months.JULE);
        Assert.assertEquals(new Date("1.8.1").getEnumMonth(),Months.AUGUST);
        Assert.assertEquals(new Date("1.9.1").getEnumMonth(),Months.SEPTEMBER);
        Assert.assertEquals(new Date("1.10.1").getEnumMonth(),Months.OCTOBER);
        Assert.assertEquals(new Date("1.11.1").getEnumMonth(),Months.NOVEMBER);
        Assert.assertEquals(new Date("1.12.1").getEnumMonth(),Months.DECEMBER);
        Assert.assertEquals(new Date("1.12.1").getDay(),1);
        Assert.assertEquals(new Date("1.12.1").getYear(),1);
    }
    @Test
    public void TestExceptions(){
        //illegal argument of days exception
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(-1,1,1)).getMessage());
        Assert.assertNotNull(assertThrows(ArrayIndexOutOfBoundsException.class,()->new Date(1,0,1)).getMessage());
        //Month number of days exceptions
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,1,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,2,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,3,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,4,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,5,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,6,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,7,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,8,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,9,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,10,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,11,1)).getMessage());
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,()->new Date(35,12,1)).getMessage());

    }
}
