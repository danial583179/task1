package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument;

import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearFunctionTest {

    @Test
    void getValue() {
        Function f = new LinearFunction(10,-10,1,0);
        Assertions.assertThrows(FunctionException.class,() -> f.getValue(11));
        Assertions.assertEquals(f.getValue(5),5,1e-10);
    }
}