package Lessons.Task3.Task2.Filter;

import org.junit.Assert;
import org.junit.Test;

public class EndStringFilterTest {
    @Test
    public void Apply(){
        Filter f = new EndStringFilter("test");
        Assert.assertTrue(f.apply("endstest"));
        Assert.assertFalse(f.apply("teststart"));
    }
}
