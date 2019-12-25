package Lessons.Task1;

public class Vector3DArray {
    private Vector3D[] array;
    public Vector3DArray(){
        array = null;
    }
    public Vector3DArray(int length)throws Exception{
        if(length < 0){
            throw new Exception("Length is less then 0");
        }
        array = new Vector3D[length];
        for(int i = 0;i < length;++i){
            array[i] = new Vector3D();
        }
    }

    public Vector3DArray(Vector3D[] array){
        this.array = array;
    }
    public int length() throws Exception {
        if(array == null){
            throw new Exception("Attempt to take length of null array");
        }
        return array.length;
    }
    public void addAtIndex(int index,Vector3D vector)throws Exception{
        if(array == null || index >= array.length || index < 0){
            throw new Exception("Index is out of bounds");
        }
        array[index] = vector;
    }
    public double maxVectorLength()throws Exception{
        if(array == null){
            throw new Exception("Attempt to count MaxVectorLength in null array");
        }
        double max = -Double.MAX_VALUE;
        for(Vector3D vector:array){
            if(vector.length() > max){
                max = vector.length();
            }
        }
        return max;
    }
    public int findVector(Vector3D vector)throws Exception{
        if(array == null){
            throw new Exception("Attempt to search in null array");
        }
       for(int i = 0 ;i < array.length;++i){
           if(array[i].equals(vector)){
               return i;
           }
       }
        return -1;
    }
    public Vector3D sumVectors()throws Exception{
        if(array == null){
            throw new Exception("Attempt to sum null array");
        }
        Vector3D sum = new Vector3D();
        for(Vector3D vector:array){
            //sum = new Vector3D(Vector3DProcessor.sum(sum,vector).getDeltaPoint());
            sum.add(vector);
        }
        return sum;
    }

    public Vector3D linearCombination(double[] odds)throws Exception{
        if(array == null){
            throw new Exception("Attempt to count LinearCombination in null array");
        }
        if(odds.length != array.length){
            throw new Exception("impossible to count linear combination with different size of arrays");
        }
        Vector3D sum = new Vector3D();
        for(int i = 0;i < array.length;++i){
            sum.add(Vector3DProcessor.mul(odds[i],array[i]));
        }
        return sum;
    }
    public Point3D[] pointShift(Point3D point)throws Exception{
        if(array == null){
            throw new Exception("Attempt to pointShft in null array");
        }
        Point3D[] shiftedPoints = new Point3D[array.length];
        for(int i = 0;i < array.length;++i){
            shiftedPoints[i] = new Point3D(point.getX() + array[i].getDeltaPoint().getX(),
                                            point.getY() + array[i].getDeltaPoint().getY(),
                                            point.getZ() + array[i].getDeltaPoint().getZ());
        }
        return shiftedPoints;
    }

    public Vector3D[] getArray() {
        return array;
    }
}
