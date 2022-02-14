import static java.lang.Math.*;

public class Triangle {
    private Point one;
    private Point two;
    private Point three;

    public Triangle(Point var1, Point var2, Point var3) {
        this.one = var1;
        this.two = var2;
        this.three = var3;
    }

    public double findLength(Point var1, Point var2) {
        double x = (var2.getX() - var1.getX());
        double y = (var2.getY() - var1.getY());
        double z = (var2.getZ() - var1.getZ());
        return sqrt(pow(x, 2)+pow(y, 2)+pow(z, 2));
    }

    public double square() {
        double a = findLength(this.one, this.two);
        double b = findLength(this.one, this.three);
        double c = findLength(this.two, this.three);
        double p = (a + b + c)/2;
        return sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public String toString() {
        return "(" + findLength(this.one, this.two) + ", " + findLength(this.one, this.three) + ", " + findLength(this.two, this.three) + ")";
    }
}
