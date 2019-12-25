package Lessons.Task1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class FirstSteps {
    static Scanner scan = new Scanner(System.in);
    public static String toCSV(int[] array) {
        StringJoiner sj = new StringJoiner(" , ");
        for(int elem:array){
            sj.add(Integer.toString(elem));
        }
        return sj.toString();
    }
    public static String toCSV(double[] array) {
        StringJoiner sj = new StringJoiner(" , ");
        for(double elem:array){
            sj.add(Double.toString(elem));
        }
        return sj.toString();
    }


    public static void HelloWorld(){
        System.out.println("Hello World");
    }
   public static void  ThreeIntegerValues() throws Exception{
        int[] array = new int[3];
        for(int i = 0;i < array.length; ++i){
            if(!scan.hasNextInt()){
                throw new Exception("Not enough Int values");
            }
            array[i] = scan.nextInt();
        }
       System.out.println(array[0] * array[1] * array[2]);
       System.out.println((array[0] + array[1] + array[2])/array.length);
       Arrays.sort(array);
       System.out.println(toCSV(array));
    }
    public static void ThreeDecimalValues() throws Exception{
        double[] array = new double[3];
        for(int i = 0;i < array.length; ++i){
            if(!scan.hasNextFloat()){
                throw new Exception("Not enough double values");
            }
            array[i] = scan.nextDouble();
        }
        System.out.println(array[0] * array[1] * array[2]);
        System.out.println((double)(array[0] + array[1] + array[2])/array.length);
        Arrays.sort(array);
        System.out.println(toCSV(array));
    }
    public static void Discriminant() throws Exception{
        double[] array = new double[3];
        for(int i = 0;i < array.length; ++i){
            if(!scan.hasNextFloat()){
                throw new Exception("Not enough double values");
            }
            array[i] = scan.nextDouble();
        }
        if(array[0] == 0){
            throw new Exception("A is 0");
        }
        double disc = Math.pow(array[1],2) - 4 * array[0] * array[2];
        if(disc < 0){
            throw new Exception("Discriminant is less then 0");
        }
        System.out.println((double)((-1)* array[1] + Math.sqrt(disc)) / (2 * array[0]));
        if (disc != 0){
            System.out.println((double)((-1)* array[1] + Math.sqrt(disc)) / (2 * array[0]));
        }
    }

    public static void SinTabulation(double min,double max,double step)throws Exception{
        if(step < 0 || min > max){
            throw new Exception("Bad parameters");
        }
        double var = min;
        while(Math.abs(max - var) < 1e-9 || var < max){
            System.out.println(var + " " + Math.sin(var));
            var+=step;
        }
    }

    public static void TwoLinearEquations(double x1,double x2,double x3,double y1,double y2,double y3) throws Exception{
        if(Math.abs(x1 * y2 - x2 * y1) < 1e-4){
            throw new Exception("Zero Equation");
        }
        System.out.println((double)(x3 * y2 - y3 * x2)/(x1 * y2 - x2 * y1));
        System.out.println((double)(x1 * y3 - x3 * y1 )/(x1 * y2 - x2 * y1));
    }


    public static BigDecimal TaylorSeries(double x, double acc) throws Exception{
        if(acc < 0){
            throw new Exception("Accuracy is less then 0");
        }
        BigDecimal sum = BigDecimal.ONE,nextSum = BigDecimal.ONE;
        for(int i = 1;nextSum.abs().compareTo(new BigDecimal(acc)) >= 0 ;++i){
            nextSum = nextSum.multiply(new BigDecimal(x / i));
            sum = sum.add(nextSum);
        }
        return sum;

    }

}
