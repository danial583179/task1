package Lessons.Task4.Task3;

import Lessons.Task3.Task1.Classes.Product.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void setGoods(Product[] products, Comparator<Product> comparator){
        Arrays.sort(products,comparator);
    }
}
