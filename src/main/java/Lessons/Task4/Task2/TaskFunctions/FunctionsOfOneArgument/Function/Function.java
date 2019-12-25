package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function;

import Lessons.Task4.Task2.Bounds.Bounds;
import Lessons.Task4.Task2.Exception.FunctionException;

public interface Function {
    // TODO: 12/10/2019 проверить можно ли наслдовать интерфейсы и унаследовать от HasBounds
    double getValue(double x) throws FunctionException;
    Bounds getBounds();
}
