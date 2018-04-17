package claudius.leetcode.question62;

/**
 * 有个m*n的网格，你在网格的左上角，你要去右下角，每次只能下移或者右移
 * 去，那么从左上角到右下角一共有多少种走法
 * <p>
 * 使用动态规划，右下角开始，一层一层的迭代，每一个位置的可能性等于右侧的可能性+下侧的可能性
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uniquePaths(5, 5);
    }

    public int uniquePaths(int m, int n) {
        int[][] record = new int[m][n];
        compute(record);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(record[i][j] + " ");
            }
            System.out.println();
        }
        return record[0][0];
    }

    public void compute(int[][] record) {
        int m = record.length;
        int n = record[0].length;
        record[m - 1][n - 1] = 1;
        //从右下角开始计算
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //网格内
                if (j + 1 < n)
                    record[i][j] += record[i][j + 1];
                //网格内
                if (i + 1 < m)
                    record[i][j] += record[i + 1][j];
            }
        }
    }
}
