package Lessons.Task3.Task1.Product;

import Lessons.Task3.Task1.Classes.Product.Product;
import Lessons.Task3.Task1.Interfaces.HasDescription;
import Lessons.Task3.Task1.Interfaces.HasName;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    public void Constructor(){
        Assert.assertNotNull(assertThrows(IllegalArgumentException.class,() -> new Product(null,null)));
        Assert.assertNotNull(assertThrows(NullPointerException.class,() -> new Product((Product) null)));
    }

    @Test
    public void GettersAndSetters(){
        Product p = new Product("name","description");
        Assert.assertEquals(p.getName(),"name");
        Assert.assertEquals(p.getDescription(),"description");
        p.setName("new name");
        p.setDescription("new description");
        Assert.assertEquals(p.getName(),"new name");
        Assert.assertEquals(p.getDescription(),"new description");
    }

    @Test
    public void Equals(){
        Product p1 = new Product("name","description");
        Product p2 = new Product("name","description");
        Product p3 = new Product("not similar name","description");
        Product p4 = new Product("name","not similar description");
        Assert.assertEquals(p1, p2);
        Assert.assertNotEquals(p1,p3);
        Assert.assertNotEquals(p1,p4);
    }

    @Test
    public void Implementations(){
        Assert.assertEquals(new HashSet<>(Arrays.asList(Product.class.getInterfaces())),new HashSet<>(Arrays.asList(HasDescription.class, HasName.class)));
    }
}