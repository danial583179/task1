package Lessons.Task3.Task1.PackedProducts;

import Lessons.Task3.Task1.Classes.PackedProducts.Pack;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackTest {
    @Test
    public void Constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new Pack(-2,"name")));
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new Pack(2,null)));
    }

    @Test
    public void GettersAndSetters(){
        Pack p = new Pack(5,"name");
        Assert.assertEquals(p.getWeight(),5);
        p.setWeight(2);
        Assert.assertEquals(p.getWeight(),2);
        Assert.assertEquals(p.getName(),"name");
        p.setName("new name");
        Assert.assertEquals(p.getName(),"new name");
    }

    @Test
    public void Equals(){
        Pack p1 = new Pack(3,"name");
        Pack p2 = new Pack(3,"name");
        Pack p3 = new Pack(3,"not the same name");
        Pack p4 = new Pack(4,"name");
        Assert.assertEquals(p1,p2);
        Assert.assertNotEquals(p1,p3);
        Assert.assertNotEquals(p1,p4);
        Assert.assertNotEquals(p1,(Pack) null);
    }
}
