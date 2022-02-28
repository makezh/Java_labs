import java.nio.channels.Pipe;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Test {
    public static void main(String [] args) {
        Point[] example = new Point[]{
                new Point(5,5,2,200),
                new Point(1,1,1,100),
                new Point(5,5,2,300),
                new Point(1,2,3,400),
        };

        Arrays.sort(example);

        for(Point i: example) System.out.println(i);
    }
}
