package claudius.leetcode.question72;

/**
 * 将word1转换成word2，有三种操作
 * 1.插入一个字符
 * 2.删除一个字符
 * 3.替换一个字符
 * 求word1转换成word2最少需要多少次操作
 * <p>
 * 建立一个m+1 * n+1 的二维数组，record[i][j] 表示word1的前i个字符转换成word2的前j个字符需要的最少次数
 * record[0][j] = j 表示word1为空，转换成word2的前j个字符需要最少次数（word1需要插入j个字符，操作数为j）
 * record[i][0] = i 表示word2为空，转换成word2,word1的前i个字符需要的最少次数（word1需要减去i个字符，操作数为i）
 * record[i][j] = min(record[i-1][j] + 1 ,record[i][j-1] + 1,record[i-1][j-1] + word1[i]==word2[j] ?0:1)
 * 解释：
 * record[i-1][j] + 1  word1在i的位置删除
 * record[i][j-1] + 1  word1在i的后面再加一个word2[j]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minDistance("a", "ab");
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] record = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    record[0][j] = j;
                    continue;
                }
                if (j == 0) {
                    record[i][0] = i;
                    continue;
                }
                record[i][j] = Math.min(record[i - 1][j] + 1, record[i][j - 1] + 1);
                //三目运算符要括起来，不然出大问题
                record[i][j] = Math.min(record[i][j], record[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        return record[m][n];
    }
}
