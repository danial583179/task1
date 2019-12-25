package Lessons.Task4.Task2.TaskFunctions.Functionals;

import Lessons.Task4.Task2.Bounds.Bounds;
import Lessons.Task4.Task2.Bounds.HasBounds;
import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.Exception.FunctionExceptionCode;
import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.Function;

public class IntegralOnSegment<T extends Function> implements HasBounds , Functional<T> {
    private Bounds bounds;
    private double ACC;

    public IntegralOnSegment(double upperBound,double lowerBound,double acc) {
        this.bounds = new Bounds(upperBound,lowerBound);
        this.ACC = acc;
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }


    private double getIntegral(int countOfRects,T argument){
        double integral = 0;
        for(int i = 0; i < countOfRects; ++i){
            try {
                integral += argument.getValue(argument.getBounds().getLowerBound() + i * argument.getBounds().getUpperBound() / countOfRects);
            } catch (FunctionException e) {
                continue;
            }
        }
        return integral;
    }

    @Override
    public double getMapping(T argument) {
        if(!argument.getBounds().isInBounds(bounds)){
            throw new FunctionException(FunctionExceptionCode.ILLEGAL_SEGMENT);
        }

        int rectsCount = 100;
        double int2p = getIntegral(2 * rectsCount,argument);
        double int1p = getIntegral(rectsCount,argument);
        double rungeError = (int2p - int1p) / 3;

        while(Math.abs(rungeError) < ACC){
            rectsCount += rectsCount * (rectsCount + 100);
            int2p = getIntegral(2 * rectsCount,argument);
            int1p = getIntegral(rectsCount,argument);
            rungeError = (int2p - int1p) / 3;
        }
        return int2p + rungeError;
    }

}
