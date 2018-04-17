package claudius.leetcode.question63;

/**
 * question62的升级版，除了计算路径外，还要考虑中间某个点不通过的情况，
 * 最坑的是最后一个点是1，直接不用计算，返回0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = {{0, 0, 0}
                , {0, 1, 0},
                {0, 0, 0}};
        solution.uniquePathsWithObstacles(obstacleGrid);
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] record = new int[m][n];
        record[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                //网格内
                if (j + 1 < n)
                    record[i][j] += record[i][j + 1];
                //网格内
                if (i + 1 < m)
                    record[i][j] += record[i + 1][j];
            }
        }
        return record[0][0];
    }

}
