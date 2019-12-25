package Lessons.Task3.Task3;

//import Lessons.Task3.Official.Task1.Classes.PackedProducts.*;
import Lessons.Task3.Task1.Classes.PackedProducts.*;
import Lessons.Task3.Task1.Classes.Product.PieceProduct;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;
import Lessons.Task3.Task2.Filter.BeginStringFilter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductServiceTest {
    private static PackedProduct[] packedProducts = new PackedProduct[]{new PackedWeightProduct(new WeightProduct("name 2","description 2"),new Pack(5,"name 2"),5)
            ,new PackedWeightProduct(new WeightProduct("name 2","description 2"),new Pack(5,"name 2"),5)
            ,new PackedWeightProduct(new WeightProduct("name 3","description 3"),new Pack(5,"name 3"),5)
            ,new PackedWeightProduct(new WeightProduct("name 4","description 4"),new Pack(5,"name 4"),5)
            ,new PackedWeightProduct(new WeightProduct("name 5","description 5"),new Pack(5,"name 5"),5)};

    private static PackedProduct[] packedProducts2 = new PackedProduct[]{new PackedPieceProduct(new PieceProduct("name 2","description 2",1),new Pack(5,"name 2"),5)
            ,new PackedWeightProduct(new WeightProduct("name 2","description 2"),new Pack(5,"name 2"),5)
            ,new PackedWeightProduct(new WeightProduct("name 3","description 3"),new Pack(5,"name 3"),5)
            ,new PackedWeightProduct(new WeightProduct("name 4","description 4"),new Pack(5,"name 4"),5)
            ,new PackedWeightProduct(new WeightProduct("name 5","description 5"),new Pack(5,"name 5"),5)};

    private static ProductBach packedProductsBach = new ProductBach(packedProducts,"description");

    private static PackagedProducts packagedProducts = new PackagedProducts(packedProducts,new Pack(5,"name"));

    private static ProductBach pb = new ProductBach(new PackedProduct[]{packagedProducts,packagedProducts},"description 2");

    private static ProductBach pb2 = new ProductBach(new PackedProduct[]{packagedProducts,new PackedWeightProduct(new WeightProduct("name 2","description 2"),new Pack(5,"name 2"),5)},"description");

    private static ProductBach pb3 = new ProductBach(new PackedProduct[]{packagedProducts,packagedProducts,null},"description 2");

    @Test
    public void countByFilter(){
        Assert.assertEquals(ProductService.countByFilter(packedProductsBach,new BeginStringFilter("name")),5);
        Assert.assertEquals(ProductService.countByFilter(pb,new BeginStringFilter("name")),0);
        Assert.assertEquals(ProductService.countByFilter(pb2,new BeginStringFilter("name")),1);
    }

    @Test
    public void countByFilterDeep(){
        Assert.assertEquals(ProductService.countByFilterDeep(pb,new BeginStringFilter("name")),10);
        Assert.assertNotNull(assertThrows(NullPointerException.class,() -> ProductService.countByFilterDeep(null,new BeginStringFilter("name"))));
        Assert.assertNotNull(assertThrows(NullPointerException.class,() -> ProductService.countByFilterDeep(pb,null)));
        Assert.assertEquals(ProductService.countByFilterDeep(pb3,new BeginStringFilter("name")),10);
    }

    @Test
    public void checkAllWeighted(){
        Assert.assertTrue(ProductService.checkAllWeighted(packedProductsBach));
        Assert.assertFalse(ProductService.checkAllWeighted(new ProductBach(packedProducts2,"description")));
        //unnecessary
    }
}
