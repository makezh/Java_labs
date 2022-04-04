import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class LinesMap {
    ArrayList<Line> Lines;
    int total;
    LinesMap() {
        Lines = new ArrayList<>();
        total = 0;
    }

    void add(int a, int b, int c) {
        Lines.add(new Line(a, b, c));
        total++;
    }

    void add(Line l) {
        Lines.add(l);
        total++;
    }

    public Stream<String> nameStream(int a, int b) {
        ArrayList<String> result = new ArrayList<>();
        Lines.stream()
                .filter(x -> x.intersectLines(new Line(-x.getY(), x.getX(),(x.getY() * a - x.getX() * b))) == 1)
                .forEach(x -> result.add(String.valueOf(new Line(-x.getY(), x.getX(),(x.getY() * a - x.getX() * b)))));
        return  result.stream();
    }

    public Optional<Line> getMax(int a, int b) {
        Optional<Line> result = Optional.empty();
        Optional<Line> tmp = Lines
                .stream()
                .max(Comparator.comparing(x -> x.distance(a, b)));
        if (tmp.isPresent()) {
            result = tmp;
        }
        return result;
    }
}
