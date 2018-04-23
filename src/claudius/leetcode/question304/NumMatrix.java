package claudius.leetcode.question304;

/**
 * 计算二维矩阵中 i j  -> m n中子矩阵的和
 * 同样方法求解 0，0 -> i,j 中的和，然后再用
 * record[i][j] - record[m-1][j] - record[i][n-1] + record[m-1][n-1]
 * 进行计算
 */
public class NumMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    private int[][] record;

    public NumMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            record = null;
            return;
        }
        int row = matrix.length + 1;
        int cloumn = matrix[0].length + 1;
        this.record = new int[row][cloumn];

        record[1][1] = matrix[0][0];
        for (int i = 2; i < row; i++) {
            record[i][1] = record[i - 1][1] + matrix[i - 1][0];
        }

        for (int i = 2; i < cloumn; i++) {
            record[1][i] = record[1][i - 1] + matrix[0][i - 1];
        }
        for (int i = 2; i < row; i++) {
            for (int j = 2; j < cloumn; j++) {
                record[i][j] = record[i - 1][j] + record[i][j - 1]
                        - record[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < cloumn; j++) {
//                System.out.print(record[i][j] + " ");
//            }
//            System.out.println();
//        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (record == null)
            return 0;
        else
            return record[row2 + 1][col2 + 1] - record[row2 + 1][col1] - record[row1][col2 + 1] + record[row1][col1];
    }
}
