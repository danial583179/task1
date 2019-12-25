package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function;

import Lessons.Task4.Task2.Bounds.Bounds;
import Lessons.Task4.Task2.Exception.FunctionException;

public abstract class FunctionOnSegment implements Function {
    private Bounds bounds;


    public FunctionOnSegment(double upperBound, double lowerBound ) {
        this.bounds = new Bounds(upperBound, lowerBound);
    }

    @Override
    public Bounds getBounds(){
        return bounds;
    }

    @Override
    public abstract double getValue(double arg) throws FunctionException;

}
