package Lessons.Task1;

import org.junit.Assert;
import org.junit.Test;

public class TestVector3DProcessor {
    @Test
    public void TestSum() throws Exception {
        Vector3D vector3D1 = new Vector3D(new Point3D(-1,-1,-1));
        Vector3D vector3D2 = new Vector3D(new Point3D(1,1,1));
        Vector3D vector3D3 = new Vector3D(new Point3D(2,2,2));
        Assert.assertTrue(new Vector3D().equals(Vector3DProcessor.sum(vector3D1,vector3D2)));
        Assert.assertTrue(new Vector3D().equals(Vector3DProcessor.sum(vector3D2,vector3D1)));
        Assert.assertTrue(vector3D2.equals(Vector3DProcessor.sum(vector3D1,vector3D3)));
        Assert.assertTrue(vector3D3.equals(Vector3DProcessor.sum(vector3D2,vector3D2)));

        Vector3D vector3D4 = new Vector3D(new Point3D(1,1,0));
        Vector3D vector3D5 = new Vector3D(new Point3D(1,1,0),new Point3D(3,2,0));
        Assert.assertTrue(new Vector3D(new Point3D(3,2,0)).equals(Vector3DProcessor.sum(vector3D4,vector3D5)));
        Assert.assertTrue(new Vector3D(new Point3D(1,1,0),new Point3D(4,3,0)).equals(Vector3DProcessor.sum(vector3D5,vector3D4)));
    }

    @Test
    public void TestNeg() throws Exception {
        Vector3D vector3D1 = new Vector3D(new Point3D(-1,-1,-1));
        Vector3D vector3D2 = new Vector3D(new Point3D(1,1,1));
        Vector3D vector3D3 = new Vector3D(new Point3D(2,2,2));
        Assert.assertTrue(new Vector3D(new Point3D(-2,-2,-2)).equals(Vector3DProcessor.neg(vector3D1,vector3D2)));
        Assert.assertTrue(new Vector3D(new Point3D(2,2,2)).equals(Vector3DProcessor.neg(vector3D2,vector3D1)));
        Assert.assertTrue(new Vector3D(new Point3D(-3,-3,-3)).equals(Vector3DProcessor.neg(vector3D1,vector3D3)));
        Assert.assertTrue(new Vector3D().equals(Vector3DProcessor.neg(vector3D2,vector3D2)));

        Vector3D vector3D4 = new Vector3D(new Point3D(1,1,0));
        Vector3D vector3D5 = new Vector3D(new Point3D(1,1,0),new Point3D(3,2,0));
        Assert.assertTrue(new Vector3D(new Point3D(-1,0,0)).equals(Vector3DProcessor.neg(vector3D4,vector3D5)));
        Assert.assertTrue(new Vector3D(new Point3D(1,1,0),new Point3D(2,1,0)).equals(Vector3DProcessor.neg(vector3D5,vector3D4)));
    }

    @Test
    public void TestMul() throws Exception {
        Vector3D vector3D1 = new Vector3D(new Point3D(1,1,1));

        Assert.assertTrue(new Vector3D().equals(Vector3DProcessor.mul(0,vector3D1)));
        Assert.assertTrue(new Vector3D(new Point3D(2,2,2)).equals(Vector3DProcessor.mul(2,vector3D1)));
        Assert.assertTrue(new Vector3D(new Point3D(-2,-2,-2)).equals(Vector3DProcessor.mul(-2,vector3D1)));
    }

    @Test
    public void TestSсalarMul() throws Exception {
        Vector3D vector3D1 = new Vector3D(new Point3D(1,1,1));
        Vector3D vector3D2 = new Vector3D(new Point3D(2,2,2));

        Assert.assertEquals(Vector3DProcessor.scalarMul(new Vector3D(),vector3D1),0);
        Assert.assertEquals(Vector3DProcessor.scalarMul(vector3D2,vector3D2),12);
    }

    @Test
    public void TestIsColl() throws Exception {
        Vector3D vector3D1 = new Vector3D();
        Vector3D vector3D2 = new Vector3D(new Point3D(1,1,1));
        Vector3D vector3D3 = new Vector3D(new Point3D(2,3,4));
        Vector3D vector3D4 = new Vector3D(new Point3D(1,1.5,2));
        Vector3D vector3D5 = new Vector3D(new Point3D(4,3,2));

        Assert.assertTrue(Vector3DProcessor.isColl(vector3D3,vector3D4));
        Assert.assertFalse(Vector3DProcessor.isColl(vector3D4,vector3D2));
        Assert.assertFalse(Vector3DProcessor.isColl(vector3D5,vector3D3));
       // Assert.assertNotNull(assertThrows(Exception.class,() -> {Vector3DProcessor.isColl(new Vector3D(),vector3D3);}).getMessage());
       // Assert.assertNotNull(assertThrows(Exception.class,() -> {Vector3DProcessor.isColl(new Vector3D(),new Vector3D());}).getMessage());

        //failure tests
        Vector3D vector1 = new Vector3D(new Point3D(0,0,1));
        Vector3D vector2 = new Vector3D(new Point3D(1,0,1));
        Vector3D vector3 = new Vector3D(new Point3D(0,0,2));
        Assert.assertFalse(Vector3DProcessor.isColl(vector1,vector2));
        Assert.assertFalse(Vector3DProcessor.isColl(vector2,vector3));
        Assert.assertTrue(Vector3DProcessor.isColl(vector1,vector3));

    }

    @Test
    public void TestVectorMul() throws Exception {
        Vector3D vector3D1 = new Vector3D();
        Vector3D vector3D2 = new Vector3D(new Point3D(1,1,1));
        Vector3D vector3D3 = new Vector3D(new Point3D(1,2,3));
        Vector3D vector3D4 = new Vector3D(new Point3D(2,4,6));
        Vector3D vector3D5 = new Vector3D(new Point3D(5,3,-2.5));

        Assert.assertTrue(vector3D1.equals(Vector3DProcessor.vectorMul(vector3D1,vector3D2)));
        Assert.assertTrue(vector3D1.equals(Vector3DProcessor.vectorMul(vector3D3,vector3D4)));
        Assert.assertTrue(new Vector3D(new Point3D(1,-2,1)).equals(Vector3DProcessor.vectorMul(vector3D2,vector3D3)));
        Assert.assertTrue(new Vector3D(new Point3D(-1,2,-1)).equals(Vector3DProcessor.vectorMul(vector3D3,vector3D2)));
        Assert.assertTrue(new Vector3D(new Point3D(14,-17.5,7)).equals(Vector3DProcessor.vectorMul(vector3D5,vector3D3)));

        //failure tests
        Vector3D vector1 = new Vector3D(new Point3D(0,1,1));
        Vector3D vector2 = new Vector3D(new Point3D(1,0,1));
        Vector3D vector3 = new Vector3D(new Point3D(1,1,0));
        Assert.assertEquals(new Vector3D(new Point3D(1,1,-1)),Vector3DProcessor.vectorMul(vector1,vector2));
        Assert.assertEquals(new Vector3D(new Point3D(-1,1,1)),Vector3DProcessor.vectorMul(vector2,vector3));
        Assert.assertEquals(new Vector3D(new Point3D(-1,1,-1)),Vector3DProcessor.vectorMul(vector1,vector3));

        //coll tests
        Vector3D colVector1 = new Vector3D(new Point3D(0,0,1));
        Vector3D colVector2 = new Vector3D(new Point3D(0,0,2));
        Vector3D colVector3 = new Vector3D(new Point3D(2,2,2));
        Vector3D colVector4 = new Vector3D(new Point3D(4,4,4));
        Assert.assertEquals(new Vector3D(),Vector3DProcessor.vectorMul(colVector1,colVector2));
        Assert.assertEquals(new Vector3D(),Vector3DProcessor.vectorMul(colVector2,colVector1));
        Assert.assertEquals(new Vector3D(),Vector3DProcessor.vectorMul(colVector3,colVector4));
        Assert.assertEquals(new Vector3D(),Vector3DProcessor.vectorMul(colVector4,colVector3));
    }
}
