package Lessons.Task3.Task1.NestedVariablesTypes;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotLessZeroInt;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotLessZeroIntTest {

    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new NotLessZeroInt(-1)));
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new NotLessZeroInt(0)));
    }

    @Test
    public void gettersAndSetters(){
        NotLessZeroInt w = new NotLessZeroInt(5);
        Assert.assertEquals(w.getValue(),5);
        w.setValue(2);
        Assert.assertEquals(w.getValue(),2);
    }

    @Test
    public void equals(){
        NotLessZeroInt w1 = new NotLessZeroInt(2);
        NotLessZeroInt w2 = new NotLessZeroInt(2);
        NotLessZeroInt w3 = new NotLessZeroInt(3);
        Assert.assertEquals(w1,w2);
        Assert.assertNotEquals(w1,w3);
        Assert.assertNotEquals(w1,(NotLessZeroInt) null);
    }
}
