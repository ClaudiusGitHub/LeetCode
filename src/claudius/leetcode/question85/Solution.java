package claudius.leetcode.question85;

public class Solution {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int sum = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        Pair[][] record = new Pair[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }
        return sum;
    }

    class Pair {
        private int row;
        private int column;
    }
}
