package Lessons.Task3.Task1.PackedProducts;

import Lessons.Task3.Task1.Classes.PackedProducts.Pack;
import Lessons.Task3.Task1.Classes.PackedProducts.PackedWeightProduct;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackedWeightProductTest {
    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new PackedWeightProduct(new WeightProduct("name","description"),(Pack) null,5)));
        Assert.assertNotNull(assertThrows(NullPointerException.class,() -> new PackedWeightProduct((WeightProduct) null,(Pack) null,5)));
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new PackedWeightProduct(new WeightProduct("name","description"),new Pack(6,"name"),-5)));
    }

    @Test
    public void weight(){
        PackedProduct p = new PackedWeightProduct(new WeightProduct("name","description"),new Pack(5,"pack name"),5);
        Assert.assertEquals(p.getGrossWeight(),10);
        Assert.assertEquals(p.getNetWeight(),5);
    }

    @Test
    public void gettersAndSetters(){
        PackedWeightProduct p = new PackedWeightProduct(new WeightProduct("name", "description"), new Pack(5, "name"), 5);
        Assert.assertEquals(p.getWeight(),5);
        p.setWeight(2);
        Assert.assertEquals(p.getWeight(),2);

        Assert.assertEquals(p.getPack(),new Pack(5,"name"));
        p.setPack(new Pack(3,"name"));
        Assert.assertEquals(p.getPack(),new Pack(3,"name"));
    }

    @Test
    public void equals(){
        PackedWeightProduct p1 = new PackedWeightProduct(new WeightProduct("name", "description"), new Pack(5, "name"), 5);
        PackedWeightProduct p2 = new PackedWeightProduct(new WeightProduct("name", "description"), new Pack(5, "name"), 6);
        PackedWeightProduct p3 = new PackedWeightProduct(new WeightProduct("name", "description"), new Pack(6, "name"), 5);
        PackedWeightProduct p4 = new PackedWeightProduct(new WeightProduct("not the same name", "description"), new Pack(5, "name"), 5);
        PackedWeightProduct p5 = new PackedWeightProduct(new WeightProduct("name", "not the same description"), new Pack(5, "name"), 5);
        Assert.assertNotEquals(p1,p2);
        Assert.assertNotEquals(p1,p2);
        Assert.assertNotEquals(p1,p3);
        Assert.assertNotEquals(p1,p4);
        Assert.assertNotEquals(p1,(PackedWeightProduct)null);
    }
}
