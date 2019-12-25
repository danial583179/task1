package Lessons.Task3.Task2.Filter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BeginStringFilterTest {
    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new BeginStringFilter("")));
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new BeginStringFilter(null)));

    }

    @Test
    public void Apply(){
        BeginStringFilter b = new BeginStringFilter("test");
        Assert.assertTrue(b.apply("test message"));
        Assert.assertFalse(b.apply("gtest message"));
    }
}
