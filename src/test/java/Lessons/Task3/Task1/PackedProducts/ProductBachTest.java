package Lessons.Task3.Task1.PackedProducts;

//import Lessons.Task3.Official.Task1.Classes.PackedProducts.*;
import Lessons.Task3.Task1.Classes.Product.PieceProduct;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;
import Lessons.Task3.Task1.Classes.PackedProducts.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductBachTest {
    private static PackedProduct[] packedProducts = new PackedProduct[]{new PackedPieceProduct(new PieceProduct("name 1","description 1",5),new Pack(5,"name 1"),5)
            ,new PackedWeightProduct(new WeightProduct("name 2","description 2"),new Pack(5,"name 2"),5)
            ,new PackedWeightProduct(new WeightProduct("name 3","description 3"),new Pack(5,"name 3"),5)
            ,new PackedWeightProduct(new WeightProduct("name 4","description 4"),new Pack(5,"name 4"),5)
            ,new PackedWeightProduct(new WeightProduct("name 5","description 5"),new Pack(5,"name 5"),5)};

    private static ProductBach packedProductsBach = new ProductBach(packedProducts,"description");

    private static PackagedProducts packagedProducts = new PackagedProducts(packedProducts,new Pack(5,"name"));

    private static ProductBach pb = new ProductBach(new PackedProduct[]{packagedProducts,packagedProducts},"description 2");
    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new ProductBach(packedProducts,null)));
    }

    @Test
    public void weight(){
        Assert.assertEquals(packedProductsBach.getWeight(),70);
        Assert.assertEquals(pb.getWeight(),150);
    }
}
