package Lessons.Task4.Task2.TaskFunctions.Functionals;

import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.LinearFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleAndBoundsValueOfFunctionTest {

    @Test
    void getMappingLinear() {
        Functional<LinearFunction> f = new MiddleAndBoundsValueOfFunction<>();
        Assertions.assertEquals(f.getMapping(new LinearFunction(10,-10,1,0)),0,1e-10);
    }
}