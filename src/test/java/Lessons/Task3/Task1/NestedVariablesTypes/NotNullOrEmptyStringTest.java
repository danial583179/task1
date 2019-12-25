package Lessons.Task3.Task1.NestedVariablesTypes;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotNullOrEmptyString;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotNullOrEmptyStringTest {

    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new NotNullOrEmptyString(null)));
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new NotNullOrEmptyString("")));
    }

    @Test
    public void gettersAndSetters(){
        NotNullOrEmptyString n = new NotNullOrEmptyString("value");
        Assert.assertEquals(n.getValue(),"value");
        n.setValue("new value");
        Assert.assertEquals(n.getValue(),"new value");
    }
}
