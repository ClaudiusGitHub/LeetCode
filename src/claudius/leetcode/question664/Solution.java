package claudius.leetcode.question664;

/**
 * 特殊的打印机
 * 每次打印可以 打印出连续的N个相同的字符
 * 每次打印可以选择开始的位置
 * aaaabba -> aaaaaaa->aaaabba  先打印全a，然后中间打印b，共需2次打印
 * 求给定一个字符串，其打印次数最少为多少
 * <p>
 * 动态规划
 * record[x][y] 为打印x->y 最小的次数
 * 状态转移方程为 record[x][y] = min(record[x][y],record[x][k-1]+record[k][y]-temp)
 * 其中 k为 i-j中 之间的数，当S[k-1] = S[y] 时，tmep=1，否则tmep=0   原因是打印S[k-1] 的时候可以捎带把S[y]打印了
 * 但是为什么我也不是很清楚
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strangePrinter("aaabb"));
    }

    public int strangePrinter(String s) {
        int size = s.length();
        if (size == 0)
            return 0;
        int[][] record = new int[size][size];
        for (int i = 0; i < size; i++) {
            record[i][i] = 1;
        }
        /**
         * i表示间距 j表示开始的结点 k表示 j -> j+i 之间的数
         */
        for (int i = 1; i < size; i++) {
            for (int j = 0; j + i < size; j++) {
                record[j][j + i] = i + 1;
                for (int k = j + 1; k <= j + i; k++) {
                    int sum = record[j][k - 1] + record[k][j + i];
                    if (s.charAt(k - 1) == s.charAt(j + i))
                        sum--;
                    record[j][j + i] = Math.min(record[j][j + i], sum);
                }
            }
        }
        return record[0][size - 1];
    }
}
