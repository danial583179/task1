package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument;

import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionLinearFunctionTest {

    @Test
    void getValue() {
        Function f = new FractionLinearFunction(10,-10,1,5,1,-7);
        Assertions.assertThrows(FunctionException.class, () -> f.getValue(7));
        Assertions.assertEquals(f.getValue(1),-1,1e-9);
    }
}