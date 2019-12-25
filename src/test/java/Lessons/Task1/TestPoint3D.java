package Lessons.Task1;

import org.junit.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPoint3D {

    @Test
    public void TestConstructorException(){
        Assert.assertNotNull(assertThrows(Exception.class,() -> {Point3D point3D = new Point3D(Double.NEGATIVE_INFINITY,1,1);}));
        Assert.assertNotNull(assertThrows(Exception.class,() -> {Point3D point3D = new Point3D(1,Double.NEGATIVE_INFINITY,1);}));
        Assert.assertNotNull(assertThrows(Exception.class,() -> {Point3D point3D = new Point3D(1,1,Double.NEGATIVE_INFINITY);}));
    }
    @Test
    public void TestSettersAndGetters() throws Exception {
        Point3D point = new Point3D();
        BigDecimal bd = FirstSteps.TaylorSeries(1000,1e-9);
        //xAssert.assertNotNull(assertThrows(Exception.class, () -> { point.setX(bd.doubleValue()); }).getMessage());
        Assert.assertEquals(0,point.getX());
        point.setX(1);
        Assert.assertEquals(1,point.getX());

        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setX(Double.POSITIVE_INFINITY);; }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setX(Double.NEGATIVE_INFINITY);; }).getMessage());
        //тест для любитилей больший чисел
        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setX(bd.doubleValue()); }).getMessage());
        //y
        Assert.assertEquals(0,point.getY());
        point.setY(1);
        Assert.assertEquals(1,point.getY());;

        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setY(Double.POSITIVE_INFINITY);; }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setY(Double.NEGATIVE_INFINITY);; }).getMessage());
        //тест для любитилей больший чисел
        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setY(bd.doubleValue()); }).getMessage());
        //z
        Assert.assertEquals(0,point.getZ());
        point.setZ(1);
        Assert.assertEquals(1,point.getZ());

        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setZ(Double.POSITIVE_INFINITY);; }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setZ(Double.NEGATIVE_INFINITY);; }).getMessage());
        //тест для любитилей больший чисел
        Assert.assertNotNull(assertThrows(Exception.class, () -> { point.setZ(bd.doubleValue()); }).getMessage());
    }

    @Test
    public void TestDistance() throws Exception {
        Point3D point1 = new Point3D(2,2,2);
        Point3D point2 = new Point3D();
        Assert.assertEquals(-2 ,point1.distanceX(point2));
        Assert.assertEquals(-2 ,point1.distanceY(point2));
        Assert.assertEquals(-2 ,point1.distanceZ(point2));
        Assert.assertEquals((double)2 * Math.sqrt(3) ,point1.distance(point2));

        Point3D positivePoint = new Point3D(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE);
        Point3D negativePoint = new Point3D(-Double.MAX_VALUE,-Double.MAX_VALUE,-Double.MAX_VALUE);
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distance(negativePoint);}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distanceX(negativePoint);}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distanceY(negativePoint);}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distanceZ(negativePoint);}).getMessage());
    }

    @Test
    public void TestDistanceAbs() throws Exception {
        Point3D point1 = new Point3D(2,2,2);
        Point3D point2 = new Point3D();
        Assert.assertEquals(2 ,point1.distanceXAbs(point2));
        Assert.assertEquals(2 ,point1.distanceYAbs(point2));
        Assert.assertEquals(2 ,point1.distanceZAbs(point2));
        Assert.assertEquals((double)2 * Math.sqrt(3) ,point1.distance(point2));

        Point3D positivePoint = new Point3D(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE);
        Point3D negativePoint = new Point3D(-Double.MAX_VALUE,-Double.MAX_VALUE,-Double.MAX_VALUE);
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distanceXAbs(negativePoint);}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distanceYAbs(negativePoint);}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class,() ->{positivePoint.distanceZAbs(negativePoint);}).getMessage());

    }

    @Test
    public void TestEquals() throws Exception {
        Assert.assertTrue(new Point3D().equals(new Point3D()));
        Assert.assertFalse(new Point3D().equals(new Point3D(1,2,3)));
    }

}
