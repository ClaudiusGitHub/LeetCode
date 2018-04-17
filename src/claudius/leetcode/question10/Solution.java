package claudius.leetcode.question10;

/**
 * 实现正则表达式 .*  .匹配任何字符 *匹配一个或者多个
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("ab", ".*");
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(); //列数
        int m = p.length(); //行数
        boolean result[][] = new boolean[m + 1][n + 1];
        result[0][0] = true;

        for (int i = 1; i <= m; i++) {

            for (int j = 0; j <= n; j++) {
                //判断第一列的情况
                if (j == 0) {
                    //i-1 是当前p的下标，判断其是否为*，这一列是与空串比较
                    if (i >= 2 && p.charAt(i - 1) == '*')
                        result[i][j] = result[i - 2][j];
                    continue;
                }
                if (p.charAt(i - 1) == '*')
                    continue;
                //下一个值为*,那么可以分为0个或者1个或者多个
                if (i < m && p.charAt(i) == '*') {
                    //0个
                    if (result[i - 1][j]) {
                        result[i][j] = true;
                        result[i + 1][j] = true; //因为下一个为*，所以这个结果是这两个共同缔造的
                        continue;
                    }
                    //1个 那么和左上角比较
                    if (result[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.')) {
                        result[i][j] = true;
                        result[i + 1][j] = true;
                    }
                    //多个
                    if (j > 1 && result[i][j - 1] && ((s.charAt(j - 1) == s.charAt(j - 2) && s.charAt(j - 1) == p.charAt(i - 1)) || p.charAt(i - 1) == '.')) {
                        result[i][j] = true;
                        result[i + 1][j] = true;
                    }
                }
                //下一个值不为*，那么直接判断是否相等
                else {
                    if (result[i - 1][j - 1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1)))
                        result[i][j] = true;
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result[m][n];
    }

}
