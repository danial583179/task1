package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument;


import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.Exception.FunctionExceptionCode;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.FunctionOnSegment;

public final class LinearFunction extends FunctionOnSegment {
    private double parameterA,parameterB;

    public LinearFunction(double upperBound, double lowerBound, double parameterA, double parameterB)  {
        super(upperBound, lowerBound);
        this.parameterA = parameterA;
        this.parameterB = parameterB;
    }

    @Override
    public double getValue(double arg) throws FunctionException {
       if(!super.getBounds().isInBounds(arg)){
           throw new FunctionException(FunctionExceptionCode.ARGUMENT_OUT_OF_BOUNDS);
       }
       return parameterA * arg + parameterB;
    }
}
