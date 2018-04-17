package claudius.leetcode.LCS;

/**
 * 最长公共子串
 * 建立(m+1)*(n+1)的二维数组，如果word1[i] = word2[j] 则record[i][j] = record[i-1][j-1] + 1,否则的话record[i][j] = 0
 */
public class SubString {
    public static void main(String[] args) {
        int[][] record = SubString.compute("ABCBDAB", "BDCABA");
        int m = record.length;
        int n = record[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(record[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] compute(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] record = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    record[i][j] = 0;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    record[i][j] = record[i - 1][j - 1] + 1;
                else
                    record[i][j] = 0;
            }
        }
        return record;
    }
}
