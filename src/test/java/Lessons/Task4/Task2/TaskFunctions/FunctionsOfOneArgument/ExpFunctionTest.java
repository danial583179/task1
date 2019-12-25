package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument;

import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpFunctionTest {

    @Test
    void getValue() {
        Function f  = new ExpFunction(10,-10,1,0);
        Assertions.assertThrows(FunctionException.class , () -> f.getValue(11));
        Assertions.assertEquals(f.getValue(1),Math.E,1e-10);
    }
}