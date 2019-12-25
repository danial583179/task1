package Lessons.Task3.Task1.Product;

import Lessons.Task3.Task1.Classes.Product.PieceProduct;
import Lessons.Task3.Task1.Interfaces.HasWeight;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceProductTest {
    @Test
    public void Weight(){
        PieceProduct p = new PieceProduct("name","description",2);
        Assert.assertEquals(p.getWeight(),2);
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> p.setWeight(-2)));
        p.setWeight(3);
        Assert.assertEquals(p.getWeight(),3);
    }

    @Test
    public void Implementation(){
        Assert.assertEquals(new HashSet<>(Arrays.asList(PieceProduct.class.getInterfaces())),new HashSet<>(Collections.singletonList(HasWeight.class)));
    }
}
