package Lessons.Task4.Task2.TaskFunctions.Functionals;

import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.FunctionOnSegment;

public class MiddleAndBoundsValueOfFunction<T extends FunctionOnSegment> implements Functional<T> {

    @Override
    public double getMapping(T argument) {
        return argument.getValue(argument.getBounds().getLowerBound()) + argument.getValue(argument.getBounds().getUpperBound()) + argument.getValue((argument.getBounds().getLowerBound() + argument.getBounds().getUpperBound()) / 2);
    }
}
