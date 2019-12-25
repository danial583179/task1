package Lessons.Task4.Task3;

import Lessons.Task3.Task1.Classes.PackedProducts.Pack;
import Lessons.Task3.Task1.Classes.PackedProducts.PackedWeightProduct;
import Lessons.Task3.Task1.Classes.Product.Product;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorDemoTest {

    @Test
    void setGoods() {
        ProductComparator<Product> c = new ProductComparator<>();
        Product[] p = new Product[]{new PackedWeightProduct(new WeightProduct("name 5","description 2"),new Pack(5,"name 2"),5)
                ,new PackedWeightProduct(new WeightProduct("name 3","description 2"),new Pack(5,"name 2"),5)
                ,new PackedWeightProduct(new WeightProduct("name 1","description 3"),new Pack(5,"name 3"),5)
                ,new PackedWeightProduct(new WeightProduct("name 8","description 4"),new Pack(5,"name 4"),5)
                ,new PackedWeightProduct(new WeightProduct("name 1","description 5"),new Pack(5,"name 5"),5)};
        ComparatorDemo.setGoods(p,c);
        int a = p.length;
    }
}