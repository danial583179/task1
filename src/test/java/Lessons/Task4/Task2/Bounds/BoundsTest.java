package Lessons.Task4.Task2.Bounds;

import Lessons.Task4.Task2.Exception.FunctionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundsTest {
    @Test
    void constructor(){
        Assertions.assertThrows(FunctionException.class,()->new Bounds(-5,-2));
        Assertions.assertThrows(FunctionException.class,()->new Bounds(0,0));
    }

    @Test
    void getUpperBound() {
        Bounds b = new Bounds(10,-10);
        Assertions.assertEquals(b.getUpperBound(),10,1e-10);
    }

    @Test
    void getLowerBound() {
        Bounds b = new Bounds(10,-10);
        Assertions.assertEquals(b.getLowerBound(),-10,1e-10);
    }

    @Test
    void isInBounds() {
        Bounds b = new Bounds(10,-10);
        Assertions.assertTrue(b.isInBounds(10 + 1e-10));
        Assertions.assertFalse(b.isInBounds(10 + 1e-9));
        Assertions.assertTrue(b.isInBounds(new Bounds(10,-10)));
    }
}