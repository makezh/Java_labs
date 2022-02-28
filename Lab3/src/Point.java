import static java.lang.Math.*;

public class Point implements Comparable<Point> {
    private double x;
    private double y;
    private double z;
    private double mass;
    public Point(double varX, double varY, double varZ, double varM) {
        this.x=varX;
        this.y=varY;
        this.z=varZ;
        this.mass=varM;
    }

    public double getR()
    {
        return pow(pow(this.x,2)+pow(this.y,2)+pow(this.z,2),0.5);
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public double getMass() { return this.mass; }

    public int compareTo(Point obj){
        if (this.getR() > obj.getR()) return 1;
        else if (this.getR() == obj.getR()) return 0;
        else return -1;
    }

    public String toString(){
        return "(" + getX() + ", " + getY() + ", " + getZ() + ", " + getMass() + ")";
    }
}
