package Lessons.Task1;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestIntegerArray {

    @Test
    public void ThrowTests()throws Exception{
        IntegerArray integerArray = new IntegerArray();
        Assert.assertNull(integerArray.getArray());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { IntegerArray a = new IntegerArray(-1); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { integerArray.setArray(-1); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, integerArray::print).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, integerArray::sumOfArray).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { integerArray.countOfElemsInSection(Integer.MIN_VALUE,Integer.MAX_VALUE); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, integerArray::countOfEvenValues).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, integerArray::isAllPositive).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, integerArray::reverse).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { new IntegerArray(5).countOfElemsInSection(5,2); }).getMessage());
    }

    @Test
    public void BasicTests()throws Exception{
        int[] array = {1,2,3};
        IntegerArray integerArray = new IntegerArray(array);
        Assert.assertEquals(array,integerArray.getArray());
        Assert.assertEquals(integerArray.sumOfArray(),6);
        Assert.assertEquals(integerArray.countOfEvenValues(),1);
        Assert.assertEquals(integerArray.countOfElemsInSection(1,3),3);
        Assert.assertTrue(integerArray.isAllPositive());
        Assert.assertFalse(new IntegerArray(new int[]{-1,2,-3}).isAllPositive());
        IntegerArray integerArrayReversed = new IntegerArray(array);
        integerArrayReversed.reverse();
        Assert.assertEquals(integerArray.getArray(),integerArrayReversed.getArray());
    }

}
