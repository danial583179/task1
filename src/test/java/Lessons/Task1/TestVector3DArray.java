package Lessons.Task1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVector3DArray {

    @Test
    public void TestConstructors()throws Exception{
        Assert.assertNull(new Vector3DArray().getArray());
        Assert.assertTrue(new Vector3D().equals(new Vector3DArray(1).getArray()[0]));
        Assert.assertEquals(new Vector3D[]{new Vector3D(),new Vector3D()}
                            ,new Vector3DArray(new Vector3D[]{new Vector3D(),new Vector3D()})
                            .getArray());
    }

    @Test
    public void ThrowTests()throws Exception{
        Assert.assertNotNull(assertThrows(Exception.class, () -> {new Vector3DArray(-5);}).getMessage());

        Vector3DArray vector3DArray= new Vector3DArray();
        Assert.assertNull(vector3DArray.getArray());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.maxVectorLength(); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.findVector(new Vector3D()); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.sumVectors(); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.linearCombination(new double[]{1,2,3});}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.pointShift(new Point3D()); }).getMessage());

        Vector3DArray vector3DArray1 = new Vector3DArray(5);
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray1.linearCombination(new double[]{1,2,3});}).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.addAtIndex(2,new Vector3D()); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray1.addAtIndex(-2,new Vector3D()); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { vector3DArray.addAtIndex(20,new Vector3D()); }).getMessage());

    }

    @Test
    public void TestLength() throws Exception {
        Assert.assertEquals(new Vector3DArray(5).length(),5);
        Assert.assertNotNull(assertThrows(Exception.class,() -> {int length = new Vector3DArray().length();}));
    }

    @Test
    public void TestGetArray() throws Exception {
        Assert.assertEquals(new Vector3D[]{new Vector3D(),new Vector3D()},new Vector3DArray(2).getArray());
        Assert.assertEquals(new Vector3DArray(2).getArray(),new Vector3DArray(2).getArray());
    }

    @Test
    public void TestMaxVectorLength()throws Exception{
        Assert.assertEquals(new Vector3DArray(new Vector3D[]
                {new Vector3D(),new Vector3D(new Point3D(1,1,1))})
                .maxVectorLength(),Math.sqrt(3));
        Assert.assertEquals(new Vector3DArray(new Vector3D[]
                {new Vector3D(),new Vector3D(new Point3D())})
                .maxVectorLength(),0);
    }

   @Test
   public void TestAddAtIndex() throws Exception {
        Vector3DArray vector3DArray = new Vector3DArray(5);
        Vector3D vector3DToInsert = new Vector3D(new Point3D(1,1,1));
        vector3DArray.addAtIndex(2,vector3DToInsert);
        Assert.assertTrue(vector3DToInsert.equals(vector3DArray.getArray()[2]));
   }

   @Test
   public void TestFindVector() throws Exception {
        Assert.assertEquals(0,new Vector3DArray(5).findVector(new Vector3D()));
        Assert.assertEquals(-1,new Vector3DArray(5).findVector(new Vector3D(new Point3D(1,1,1))));
    }

    @Test
    public void TestSumVectors() throws Exception {
        Vector3DArray vector3DArray = new Vector3DArray(5);
        vector3DArray.addAtIndex(4,new Vector3D(new Point3D(1,1,1)));
        Vector3D vector3DResult = vector3DArray.sumVectors();
        Assert.assertTrue(new Vector3D(new Point3D(1,1,1)).equals(vector3DArray.sumVectors()));
    }

    @Test
    public void TestPointShift() throws Exception {
        Vector3DArray emptyArray = new Vector3DArray();
        Vector3DArray arrayWith0Vectors = new Vector3DArray(2);
        Vector3DArray array = new Vector3DArray(new Vector3D[]{
                new Vector3D(new Point3D(1,1,1)),
                new Vector3D(new Point3D(-2,-2,-2)),
                new Vector3D(new Point3D(3,3,3))});
        Point3D point = new Point3D();
        Assert.assertNotNull(assertThrows(Exception.class,() -> {emptyArray.pointShift(point);}));
        Point3D[] points = arrayWith0Vectors.pointShift(point);
        Assert.assertEquals(points[0],point);
        Assert.assertEquals(points[1],point);

        points = array.pointShift(point);
        Assert.assertEquals(points[0],new Point3D(1,1,1));
        Assert.assertEquals(points[1],new Point3D(-2,-2,-2));
        Assert.assertEquals(points[2],new Point3D(3,3,3));


    }

    @Test
    public void TestLinearCombination() throws Exception {
        Vector3DArray vector3DArray = new Vector3DArray(5);
        vector3DArray.addAtIndex(4,new Vector3D(new Point3D(1,1,1)));
        Vector3D vector3DResult = vector3DArray.linearCombination(new double[]{0.5,0.5,0.5,0.5,0.5});
        Assert.assertTrue(new Vector3D(new Point3D(0.5,0.5,0.5)).equals(vector3DResult));
    }





}
