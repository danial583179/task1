package Lessons.Task1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVector3D {

    @Test
    void TestConstructorViaNonArgs() throws Exception {
        Vector3D vector3D  = new Vector3D();
        Assert.assertTrue(new Point3D().equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D().equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D().equals(vector3D.getDeltaPoint()));
    }

    @Test
    public void TestConstructorViaDeltaPoint() throws Exception {
        Vector3D vector3D = new Vector3D(new Point3D(1,1,1));
        Assert.assertTrue(new Point3D(0,0,0).equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getDeltaPoint()));

    }
    @Test
    public void TestConstructorViaFirstAndLastPoints() throws Exception {
        Vector3D vector3D  = new Vector3D(new Point3D(1,1,1),new Point3D(-1,-1,-1));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D(-1,-1,-1).equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D(-2,-2,-2).equals(vector3D.getDeltaPoint()));


        Assert.assertNotNull(
                assertThrows(Exception.class,
                        () -> {
                Vector3D
                        vector3D1 = new Vector3D(
                        new Point3D(-Double.MAX_VALUE,-Double.MAX_VALUE,-Double.MAX_VALUE),
                        new Point3D(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE));
                    }
                )
                .getMessage()
        );

    }
    @Test
    public void TestConstructorViaIntCoordinates() throws Exception {
        Vector3D vector3D = new Vector3D(1,1,1,-1,-1,-1);
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D(-1,-1,-1).equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D(-2,-2,-2).equals(vector3D.getDeltaPoint()));
    }

    @Test
    public void TestLength() throws Exception {
        Vector3D vector3D = new Vector3D();
        Assert.assertEquals(0,vector3D.length());
        vector3D = new Vector3D(new Point3D(2,2,2));
        Assert.assertEquals(2 * Math.sqrt(3),vector3D.length());
        vector3D = new Vector3D(new Point3D(2,2,2),new Point3D(0,0,0));
        Assert.assertEquals(2 * Math.sqrt(3),vector3D.length());
        vector3D = new Vector3D(0,0,0,2,2,2);
        Assert.assertEquals(2 * Math.sqrt(3),vector3D.length());
    }

    @Test
    public void TestSetters() throws Exception {
        Vector3D vector3D = new Vector3D();

        vector3D.setDeltaPoint(new Point3D(1,1,1));
        Assert.assertTrue(new Point3D().equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getDeltaPoint()));

        vector3D.setFirstPoint(new Point3D(1,1,1));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D(0,0,0).equals(vector3D.getDeltaPoint()));

        vector3D.setLastPoint(new Point3D(2,2,2));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getFirstPoint()));
        Assert.assertTrue(new Point3D(2,2,2).equals(vector3D.getLastPoint()));
        Assert.assertTrue(new Point3D(1,1,1).equals(vector3D.getDeltaPoint()));

    }

    @Test
    public void TestEquals() throws Exception {

        Assert.assertTrue(new Vector3D().equals(new Vector3D()));
        Assert.assertTrue(new Vector3D(new Point3D()).equals(new Vector3D()));
        Assert.assertTrue(new Vector3D(new Point3D(),new Point3D()).equals(new Vector3D()));
        Assert.assertTrue(new Vector3D(0,0,0,0,0,0).equals(new Vector3D()));

        Assert.assertFalse(new Vector3D(new Point3D(1,1,1)).equals(new Vector3D()));
        Assert.assertFalse(new Vector3D(new Point3D(),new Point3D(1,1,1)).equals(new Vector3D()));
        Assert.assertFalse(new Vector3D(0,0,0,1,1,1).equals(new Vector3D()));

    }
}
