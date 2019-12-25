package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument;

import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.Exception.FunctionExceptionCode;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.FunctionOnSegment;

public final class FractionLinearFunction extends FunctionOnSegment {
    private double parameterA,parameterB,parameterC,parameterD;

    public FractionLinearFunction(double upperBound, double lowerBound, double parameterA, double parameterB, double parameterC, double parameterD) {
        super(upperBound, lowerBound);
        this.parameterA = parameterA;
        this.parameterB = parameterB;
        this.parameterC = parameterC;
        this.parameterD = parameterD;
    }


    @Override
    public double getValue(double x) throws FunctionException {
        if(!getBounds().isInBounds(x) || Math.abs(x - -parameterD / parameterC) < 1e-10){
            throw new FunctionException(FunctionExceptionCode.ARGUMENT_OUT_OF_BOUNDS);
        }
        return (parameterA * x + parameterB) / (parameterC * x + parameterD);
    }
}
