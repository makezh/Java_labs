import java.util.stream.IntStream;

public class Test {
    public static void main(String [] args) {
        Point point1 = new Point(0, 2, 0);
        Point point2 = new Point(0, 0, 2);
        Point point3 = new Point(0, 0, 0);

        Triangle shape = new Triangle(point1, point2, point3);

        System.out.println(shape);

        System.out.println(shape.square());

    }
}
