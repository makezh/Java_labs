import java.nio.channels.Pipe;
import java.util.stream.IntStream;
import java.util.Arrays;

/*
                            ЗАДАНИЕ
        Класс, представляющий множество материальных точек,
      заданных координатами в трёхмерном пространстве и массой,
    с порядком на основе расстояния от центра масс до начала координат.
    
*/

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
