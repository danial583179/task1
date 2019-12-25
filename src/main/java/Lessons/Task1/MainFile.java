package Lessons.Task1;

import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        int a = 5;
        Scanner s = new Scanner(System.in);


        //hello world(!)
        /*FirstSteps.HelloWorld();
        try {
            System.out.println("Three integer values");
            FirstSteps.ThreeIntegerValues();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Three double values");
            FirstSteps.ThreeDecimalValues();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("discriminant");
            FirstSteps.Discriminant();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("two linear equation");
            FirstSteps.TwoLinearEquations(1,2,3,4,5,6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        try {
            System.out.println("Sin tabulation");
            FirstSteps.SinTabulation(1.0, 2.0, .1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*try {
            System.out.println("Taylor series");
            BigDecimal res = FirstSteps.TaylorSeries(100,1e-9);
            System.out.println(res.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }


}
