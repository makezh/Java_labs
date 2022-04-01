import java.util.Iterator;

public class Matrix implements Iterator {
    private final int[][] matrix;
    private final int size;
    private int position = 0;
    private int colIndex = 0;
    private int rowIndex = 0;


    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length * matrix[0].length;
    }

    public boolean hasNext() {
        return position < size - matrix[0].length;
    }

    private Integer getReduction(int i, int j)
    {
        return matrix[i][j] * matrix[i+1][j+1] - matrix[i][j+1] * matrix[i+1][j];
    }

    public Integer next() {

        int reductor = getReduction(rowIndex, colIndex);
        colIndex++;
        if (colIndex == matrix[0].length - 1) {
            colIndex = 0;
            rowIndex++;
            position++;
        }
        position++;
        return reductor;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            sb.append("[ ");
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(ints[j]).append(" ");
            }
            sb.append("]\n");
        }
                return sb.toString();
    }


}
