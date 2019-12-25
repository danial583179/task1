package Lessons.Task1;

import java.util.Scanner;

public class IntegerArray {
    static Scanner scan = new Scanner(System.in);
    private int[] array;

    public IntegerArray(){
        array = null;
    }
    public IntegerArray(int length) throws Exception {
        if(length < 0){
            throw new Exception("Length is less then 0");
        }
        array = new int[length];
    }
    public IntegerArray(int[] array){
        this.array = array;
    }
    public void print()throws Exception{
        if(array == null){
            throw new Exception("Attempt to print null array");
        }
        System.out.println(FirstSteps.toCSV(array));
    }

    public void setArray(int length) throws Exception{
        if(length < 0){
            throw new Exception("Length is less then 0");
        }
        array = new int[length];
        for(int i = 0;i < length;++i){
            if(!scan.hasNextInt()){
                throw new Exception("Not enough Int values");
            }
            array[i] = scan.nextInt();
        }
    }

    public long sumOfArray()throws Exception{
        if(array == null){
            throw new Exception("Attempt to summarize null array");
        }
        long sum = 0;
        for(int elem:array){
            sum += elem;
        }
        return sum;
    }

    public int countOfEvenValues()throws Exception{
        if(array == null){
            throw new Exception("Attempt to count evens in null array");
        }
        int count = 0;
        for(int elem:array){
            if(elem % 2 == 0){
                count ++;
            }
        }
        return count;
    }

    public int countOfElemsInSection(int min,int max)throws Exception{
         if(array == null){
             throw new Exception("Attempt to count evens in null array");
         }
         if(min > max){
             throw new Exception("Min must be less then Max");
         }
         int count = 0;
         for(int elem:array){
             if(elem >= min && elem <= max){
                 count ++;
             }
         }
         return count;
     }

     public boolean isAllPositive()throws Exception{
        if(array == null){
            throw new Exception("Attempt to count positives elems in null array");
        }
        for(int elem:array){
            if(elem < 0) {
                return false;
            }
        }
        return true;
     }
     public void reverse()throws Exception{
        if(array == null){
            throw new Exception("Attempt to reverse null array");
        }
        int arraySize = array.length;
        for(int i = 0; i < arraySize / 2;++i){
            int tempElem = array[i];
            array[i] = array[arraySize - i - 1];
            array[arraySize- i - 1] = tempElem;
        }
     }

     public int[] getArray(){
        return array;
     }

    public static void main(String[] args) throws Exception {
        IntegerArray arr = new IntegerArray(5);
        arr.print();
        arr.setArray(5);
        arr.print();

    }
}
