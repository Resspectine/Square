package VMA;

/**
 * Created by maks6 on 26.10.16.
 */
public class SquareRadical {
    public static void printMatrix(double[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%+.5f ", matrix[i][j]);
            System.out.println();
        }
    }

    private static double multiplay(double[][] a, double[][] b, int i1, int j1) {
        double rez = 0;
        for (int j = 0; j < 4; j++)
            rez += a[i1][j] * b[j][j1];
        return rez;
    }

    public static void matrixMultiplay(double[][] A, double[][] B, int size) {
        double rez[][] = new double[4][4];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                rez[i][j] = multiplay(A, B, i, j);
        printMatrix(rez, size);
    }

    public static double findSum(int _i, int _j, double[][] matrix) {
        double sum = 0;
        for (int i = 0; i < _i; i++)
            sum += matrix[i][_i] * matrix[i][_j];
        return sum;
    }

    public static void findTriangleMatrix(double[][] matrix, int size) {
        double[][] triangle = new double[size][size];
        triangle[0][0] = Math.sqrt(matrix[0][0]);
        for (int i = 0; i < size; i++) {
            if (i != 0)
                triangle[i][i] = Math.sqrt(Math.abs(matrix[i][i] - findSum(i, i, triangle)));
            for (int j = i + 1; j < size; j++)
                triangle[i][j] = (matrix[i][j] - findSum(i, j, triangle)) / triangle[i][i];
        }
        printMatrix(triangle, size);
    }
}
