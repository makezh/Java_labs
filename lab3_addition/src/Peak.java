import java.lang.reflect.Array;
import java.util.Arrays;

public class Peak implements Comparable<Peak> {
    private int [] arr;

    public Peak(int [] ARR){
        this.arr = ARR;
    }

    public int countPeak(){
        int k = 0;

        if (arr[0] > arr[1]) k++;
        if (arr[arr.length-1] > arr[arr.length-2]) k++;

        for(int i = 1; i < arr.length - 1; i++)
        {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) k++;
        }

        return k;
    }

    public int compareTo(Peak obj){
        if (this.countPeak() > obj.countPeak()) return 1;
        else if (this.countPeak() == obj.countPeak()) return 0;
        else return -1;
    }

    public String toString(){
        return "" + countPeak() + " " + Arrays.toString(arr);
    }
}
