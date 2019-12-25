package Lessons.Task4.Task2.Bounds;

import Lessons.Task4.Task2.Exception.FunctionException;
import Lessons.Task4.Task2.Exception.FunctionExceptionCode;

public final class Bounds {
    private double
            upperBound = Double.MAX_VALUE,
            lowerBound = -Double.MAX_VALUE;
    private final double ACCURACY = 1e-9;

    public Bounds(double upperBound, double lowerBound) {
        setLowerBound(lowerBound);
        setUpperBound(upperBound);
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        if(lowerBound > upperBound || Math.abs(lowerBound - upperBound) < ACCURACY){
            throw new FunctionException(FunctionExceptionCode.ILLEGAL_BOUNDS);
        }
        this.upperBound = upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        if(lowerBound > upperBound || Math.abs(lowerBound - upperBound) < ACCURACY){
            throw new FunctionException(FunctionExceptionCode.ILLEGAL_BOUNDS);
        }
        this.lowerBound = lowerBound;
    }

    public boolean isInBounds(double arg){
        return (arg <= upperBound && arg >= lowerBound) || (Math.abs(arg - upperBound) < ACCURACY || Math.abs(arg - lowerBound) < ACCURACY);
    }

    public boolean isInBounds(Bounds bounds){
        return bounds.isInBounds(this.lowerBound) && bounds.isInBounds(this.upperBound);
    }


}
