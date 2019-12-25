package Lessons.Task1;

public class Vector3DProcessor {
    public static Vector3D sum(Vector3D vector1,Vector3D vector2) throws Exception {
        return new Vector3D(
                vector1.getFirstPoint(),
                new Point3D(vector1.getLastPoint().getX() + vector2.getDeltaPoint().getX(),
                            vector1.getLastPoint().getY() + vector2.getDeltaPoint().getY(),
                            vector1.getLastPoint().getZ() + vector2.getDeltaPoint().getZ()));
    }
    public static Vector3D neg(Vector3D vector1,Vector3D vector2) throws Exception {
        return new Vector3D(
                vector1.getFirstPoint(),
                new Point3D(vector1.getLastPoint().getX() - vector2.getDeltaPoint().getX(),
                        vector1.getLastPoint().getY() - vector2.getDeltaPoint().getY(),
                        vector1.getLastPoint().getZ() - vector2.getDeltaPoint().getZ()));
    }
    public static Vector3D mul(double mulOdd,Vector3D vector) throws Exception {
        return new Vector3D(vector.getFirstPoint().getX(),
                vector.getFirstPoint().getY(),
                vector.getFirstPoint().getZ(),
                vector.getLastPoint().getX() * mulOdd,
                vector.getLastPoint().getY() * mulOdd,
                vector.getLastPoint().getZ() * mulOdd);
    }
    public static double scalarMul(Vector3D vector1,Vector3D vector2){
        return vector1.getDeltaPoint().getX() * vector2.getDeltaPoint().getX() +
                vector1.getDeltaPoint().getY() * vector2.getDeltaPoint().getY() +
                vector1.getDeltaPoint().getZ() * vector2.getDeltaPoint().getZ();
    }
    public static Vector3D vectorMul(Vector3D vector1,Vector3D vector2) throws Exception {
        //if(vector1.equals(new Vector3D()) || vector2.equals(new Vector3D()) || isColl(vector1,vector2))return new Vector3D();
        return new Vector3D(new Point3D(
                vector1.getDeltaPoint().getY() * vector2.getDeltaPoint().getZ() - vector2.getDeltaPoint().getY() * vector1.getDeltaPoint().getZ(),
                - (vector1.getDeltaPoint().getX() * vector2.getDeltaPoint().getZ() - vector1.getDeltaPoint().getZ() * vector2.getDeltaPoint().getX()),
                + (vector1.getDeltaPoint().getX() * vector2.getDeltaPoint().getY() - vector1.getDeltaPoint().getY() * vector2.getDeltaPoint().getX())));
    }
    public static boolean isColl(Vector3D vector1,Vector3D vector2) throws Exception {
        return vectorMul(vector1,vector2).equals(new Vector3D());
    }

}
