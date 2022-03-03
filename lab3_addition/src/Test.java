import java.nio.channels.Pipe;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Test {
    public static void main(String [] args){
        Peak[] example = new Peak[]{
                new Peak(new int[] {1,2,3,4,5}),
                new Peak(new int[] {5,2,3,4,5}),
                new Peak(new int[] {1,4,3,5,2,6}),
                new Peak(new int[] {5,0,5,0,5,0,5,0,5,0,5,0}),
                new Peak(new int[] {0,0,0,0,0})
        };
    Arrays.sort(example);

    for(Peak i: example) System.out.println(i);
    }
}
