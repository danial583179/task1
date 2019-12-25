package Lessons.Task4.Task2.TaskFunctions.Functionals;

import Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function.Function;

public interface Functional<T extends Function> {

    double getMapping(T x);
}
