import static java.lang.Math.*;

public class Point
{
    private double x;
    private double y;
    private double z;
    private static int n;
    public static int val;
    public Point(double varX, double varY, double varZ) {
    this.x=varX;
    this.y=varY;
    this.z=varZ;
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
}
