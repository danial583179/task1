package Lessons.Task4.Task2.TaskFunctions.Functionals;

import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.ExpFunction;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.FractionLinearFunction;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.LinearFunction;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.SinusFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegralOnSegmentTest {

    @Test
    void getMappingExp() {
        Functional<ExpFunction> f = new IntegralOnSegment<>(3,0,1e-2);
        Assertions.assertEquals(f.getMapping(new ExpFunction(100,0,1,0)),19.086,1e-2);
    }

    @Test
    void getMappingLinear(){
        Functional<LinearFunction> f = new IntegralOnSegment<>(10,0,1e-2);
        Assertions.assertEquals(f.getMapping(new LinearFunction(100,0,5,5)),300,1e-2);
    }

    @Test
    void getMappingSinus(){
        Functional<SinusFunction> f = new IntegralOnSegment<>(10,0,1e-2);
        Assertions.assertEquals(f.getMapping(new SinusFunction(100,0,1,1)),1.8391,1e-2);
    }

    @Test
    void getMappingFractionLinear(){
        Functional<FractionLinearFunction> f = new IntegralOnSegment<FractionLinearFunction>(10,0,1e-2);
        //Assertions.assertEquals(f.getMapping(new FractionLinearFunction(100,-100,1,5,7,-7)),1.8391,1e-2);
    }

}