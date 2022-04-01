/*
                      ЗАДАНИЕ
    Целочисленная матрица размера m × n с итератором 
    по определителям всех подматриц размера 2 × 2. 
*/

public class Test {
    public static void main(String[ ] args ) {

        Matrix matrix = new Matrix(new int[][] {
                {1,1,2,1},
                {0,1,2,3},
                {3,2,8,4}
        });

        System.out.println(matrix);

        while (matrix.hasNext()) {
            System.out.print(matrix.next() + " ");
        }
    }
}
