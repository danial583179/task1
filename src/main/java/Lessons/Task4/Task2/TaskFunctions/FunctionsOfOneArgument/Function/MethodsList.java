package Lessons.Task4.Task2.TaskFunctions.FunctionsOfOneArgument.Function;

import java.lang.reflect.Method;

public class MethodsList {

    public static Method Exp(){
        Method m = null;
        try {
            m = Math.class.getMethod("exp", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return m;
    }

    public static Method X(){
        Method m = null;
        try {
            m = FunctionOnSegment.class.getMethod("x", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return m;
    }

    public static Method Sinus(){
        Method m = null;
        try {
            m = Math.class.getMethod("sin", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return m;
    }
}
