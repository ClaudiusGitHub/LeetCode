package claudius.leetcode.question64;

/**
 * m*n的二维数组存储了>= 0 的值，从左上角走到右下角，让路径经过的网格点和最小
 * 每次只能往下或者往右
 * 动态规划
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                //最后一行
                if (i == m - 1) {
                    grid[i][j] += grid[i][j + 1];
                    continue;
                }
                //最后一列
                if (j == n - 1) {
                    grid[i][j] += grid[i + 1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
