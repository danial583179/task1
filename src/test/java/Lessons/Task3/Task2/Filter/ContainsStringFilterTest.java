package Lessons.Task3.Task2.Filter;

import org.junit.Assert;
import org.junit.Test;

public class ContainsStringFilterTest {

    @Test
    public void Apply(){
        Filter f = new ContainsStringFilter("test");
        Assert.assertTrue(f.apply("not testtest"));
        Assert.assertFalse(f.apply("not est"));
    }
}
