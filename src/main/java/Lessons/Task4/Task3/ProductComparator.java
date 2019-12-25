package Lessons.Task4.Task3;

import Lessons.Task3.Task1.Classes.Product.Product;

import java.util.Comparator;

public class ProductComparator<T extends Product> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int nameComparison = o1.getName().compareTo(o2.getName());
        return nameComparison == 0 ? o2.getDescription().compareTo(o2.getDescription()) : nameComparison;
    }
}
