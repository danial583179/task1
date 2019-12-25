package Lessons.Task3.Task1.PackedProducts;

import Lessons.Task3.Task1.Classes.PackedProducts.Pack;
import Lessons.Task3.Task1.Classes.PackedProducts.PackedPieceProduct;
import Lessons.Task3.Task1.Classes.Product.PieceProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackedPieceProductTest {
    @Test
    public void constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new PackedPieceProduct(new PieceProduct("name","description",5),(Pack) null,5)));
        Assert.assertNotNull(assertThrows(NullPointerException.class,() -> new PackedPieceProduct((PieceProduct) null,(Pack) null,5)));
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new PackedPieceProduct(new PieceProduct("name","description",5),new Pack(6,"name"),-5)));
    }

    @Test
    public void weight(){
        PackedProduct p = new PackedPieceProduct(new PieceProduct("name","description",5),new Pack(5,"name"),5);
        Assert.assertEquals(p.getNetWeight(),25);
        Assert.assertEquals(p.getGrossWeight(),30);
    }

    @Test
    public void gettersAndSetters(){
        PackedPieceProduct p = new PackedPieceProduct(new PieceProduct("name", "description", 5), new Pack(5, "name"), 5);
        Assert.assertEquals(p.getQuantity(),5);
        p.setQuantity(2);
        Assert.assertEquals(p.getQuantity(),2);

        Assert.assertEquals(p.getPack(),new Pack(5,"name"));
        p.setPack(new Pack(3,"name"));
        Assert.assertEquals(p.getPack(),new Pack(3,"name"));
    }

    @Test
    public void equals(){
        PackedPieceProduct p1 = new PackedPieceProduct(new PieceProduct("name", "description", 5), new Pack(5, "name"), 5);
        PackedPieceProduct p2 = new PackedPieceProduct(new PieceProduct("name", "description", 5), new Pack(5, "name"), 6);
        PackedPieceProduct p3 = new PackedPieceProduct(new PieceProduct("name", "description", 5), new Pack(6, "name"), 5);
        PackedPieceProduct p4 = new PackedPieceProduct(new PieceProduct("not the same name", "description", 5), new Pack(5, "name"), 5);
        PackedPieceProduct p5 = new PackedPieceProduct(new PieceProduct("name", "not the same description", 5), new Pack(5, "name"), 5);
        Assert.assertNotEquals(p1,p2);
        Assert.assertNotEquals(p1,p2);
        Assert.assertNotEquals(p1,p3);
        Assert.assertNotEquals(p1,p4);
        Assert.assertNotEquals(p1,(PackedPieceProduct)null);


    }
}
