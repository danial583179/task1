package Lessons.Task1;

import java.util.Objects;

public class Vector3D {
    private Point3D firstPoint,lastPoint,deltaPoint;

    public Vector3D(Point3D firstPoint,Point3D lastPoint) throws Exception {
        this.firstPoint =firstPoint;
        this.lastPoint = lastPoint;
        this.deltaPoint = new Point3D(firstPoint.distanceX(lastPoint),firstPoint.distanceY(lastPoint),firstPoint.distanceZ(lastPoint));
    }
    public Vector3D() throws Exception {
        this(new Point3D(),new Point3D());
    }
    public Vector3D(Point3D deltaPoint) throws Exception {
       this(new Point3D(),deltaPoint);
    }

    public Vector3D(double x1,double y1,double z1,double x2,double y2,double z2) throws Exception {
       this(new Point3D(x1,y1,z1),new Point3D(x2,y2,z2));
    }
    public double length() throws Exception {
        return firstPoint.distance(lastPoint);
    }

    public void setFirstPoint(Point3D firstPoint) throws Exception {
        this.firstPoint = firstPoint;
        this.deltaPoint = new Point3D(firstPoint.distanceX(lastPoint),firstPoint.distanceY(lastPoint),firstPoint.distanceZ(lastPoint));
    }

    public void setLastPoint(Point3D lastPoint) throws Exception {
        this.lastPoint = lastPoint;
        this.deltaPoint = new Point3D(firstPoint.distanceX(lastPoint),firstPoint.distanceY(lastPoint),firstPoint.distanceZ(lastPoint));
    }
    public void setDeltaPoint(Point3D deltaPoint) throws Exception {
        this.deltaPoint = deltaPoint;
        this.lastPoint = new Point3D(lastPoint.getX() + deltaPoint.getX(),lastPoint.getY() + deltaPoint.getY(),lastPoint.getZ() + deltaPoint.getZ());
    }

    public Point3D getFirstPoint() {
        return firstPoint;
    }

    public void add(Vector3D vector3D) throws Exception {
        this.lastPoint = new Point3D(this.lastPoint.getX() + vector3D.getDeltaPoint().getX(),
                this.lastPoint.getY() + vector3D.getDeltaPoint().getY(),
                this.lastPoint.getZ() + vector3D.getDeltaPoint().getZ());
        this.deltaPoint = new Point3D(firstPoint.distanceX(lastPoint),firstPoint.distanceY(lastPoint),firstPoint.distanceZ(lastPoint));
    }

    public Point3D getLastPoint() {
        return lastPoint;
    }

    public Point3D getDeltaPoint(){
        return deltaPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Objects.equals(firstPoint, vector3D.firstPoint) &&
                Objects.equals(lastPoint, vector3D.lastPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, lastPoint);
    }
}
