package Lessons.Task1;

import java.util.Arrays;
import java.util.Objects;

public class Point3D {
    private double x,y,z;

    public Point3D(double x, double y, double z) throws Exception {
        if(Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z)){
            throw new Exception("Attempt to create point with infinite values");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D() throws Exception {
        this(0,0,0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x)throws Exception {
        if(Double.isInfinite(x)){
            throw new Exception("Attempt to create point with infinite value");
        }
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y)throws Exception {
        if(Double.isInfinite(y)){
            throw new Exception("Attempt to create point with infinite value");
        }
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) throws Exception {
        if(Double.isInfinite(z)){
            throw new Exception("Attempt to create point with infinite value");
        }
        this.z = z;
    }

    public double distanceXAbs(Point3D point) throws Exception {
        return Math.abs(distanceX(point));
    }

    public double distanceX(Point3D point) throws Exception {
        if(Double.isInfinite(point.x - this.x)){
            throw new Exception("Points to far away to count distance");
        }
        return (point.x - this.x);
    }

    public double distanceYAbs(Point3D point) throws Exception {
        return Math.abs(distanceY(point));
    }

    public double distanceY(Point3D point) throws Exception {
        if(Double.isInfinite(point.y - this.y)){
            throw new Exception("Points to far away to count distance");
        }
        return (point.y - this.y);
    }

    public double distanceZAbs(Point3D point) throws Exception {
        return Math.abs(distanceZ(point));
    }

    public double distanceZ(Point3D point) throws Exception {
        if(Double.isInfinite(point.z - this.z)){
            throw new Exception("Points to far away to count distance");
        }
        return (point.z - this.z);
    }

    public double distance(Point3D point) throws Exception {
        double
                x = Math.pow(distanceXAbs(point),2),
                y = Math.pow(distanceYAbs(point),2),
                z = Math.pow(distanceZAbs(point),2);

        //ненужный код,т.к. значения проверяются в метода distanceXAbs...
        if(Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z)){
            throw new Exception("Points to far away to count distance");
        }

        return Math.sqrt(x + y + z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public void print(){
        System.out.println(Arrays.toString(new double[]{x,y,z}));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Math.abs(x - point3D.x) <= 1e-9 &&
                Math.abs(y - point3D.y) <= 1e-9 &&
                Math.abs(z - point3D.z) <= 1e-9;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public static void main(String[] args) throws Exception {
        Point3D point3D = new Point3D(1,1,1);
        point3D.print();
    }
}
