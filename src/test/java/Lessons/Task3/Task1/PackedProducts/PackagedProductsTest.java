package Lessons.Task3.Task1.PackedProducts;

import Lessons.Task3.Task1.Classes.PackedProducts.Pack;
import Lessons.Task3.Task1.Classes.PackedProducts.PackagedProducts;
import Lessons.Task3.Task1.Classes.PackedProducts.PackedPieceProduct;
import Lessons.Task3.Task1.Classes.PackedProducts.PackedWeightProduct;
import Lessons.Task3.Task1.Classes.Product.PieceProduct;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackagedProductsTest {
    private  PackedProduct[] packedProducts = new PackedProduct[]{new PackedPieceProduct(new PieceProduct("name 1","description 1",5),new Pack(5,"name 1"),5)
    ,new PackedWeightProduct(new WeightProduct("name 2","description 2"),new Pack(5,"name 2"),5)
    ,new PackedWeightProduct(new WeightProduct("name 3","description 3"),new Pack(5,"name 3"),5)
    ,new PackedWeightProduct(new WeightProduct("name 4","description 4"),new Pack(5,"name 4"),5)
    ,new PackedWeightProduct(new WeightProduct("name 5","description 5"),new Pack(5,"name 5"),5)};

    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new PackagedProducts(packedProducts,(Pack) null)));
    }

    @Test
    public void weight(){
        PackedProduct p = new PackagedProducts(packedProducts,new Pack(5,"name"));
        Assert.assertEquals(p.getNetWeight(),70);
        Assert.assertEquals(p.getGrossWeight(),75);
    }

    @Test
    public void gettersAndSetters(){
        PackagedProducts p = new PackagedProducts(packedProducts,new Pack(5,"name"));
        Assert.assertEquals(p.getPack(),new Pack(5,"name"));
        p.setPack(new Pack(3,"name 2"));
        Assert.assertEquals(p.getPack(),new Pack(3,"name 2"));
        Assert.assertEquals(p.getProducts(),new LinkedList<>(Arrays.asList(packedProducts)));
        p.setProducts(new LinkedList<>(Arrays.asList(Arrays.copyOfRange(packedProducts,1,packedProducts.length))));
        Assert.assertEquals(p.getProducts(),new LinkedList<>(Arrays.asList(Arrays.copyOfRange(packedProducts,1,packedProducts.length))));
        p.setProducts(null);
        Assert.assertNull(p.getProducts());
    }
}
