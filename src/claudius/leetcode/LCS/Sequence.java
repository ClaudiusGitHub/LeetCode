package claudius.leetcode.LCS;

/**
 * 最长公共子序列
 * 建立m+1 n+1 的二维数组，i=0 或j=0时为0
 * 注意是多建立了一层，为的是开始遍历省事儿
 * 如果： str1[i]  = str2[j]  那么record[i+1][j+1] = reocrd[i][j]+1
 * 如果： str1[i] != str2[j]  那么record[i+1][j+1] = max{record[i][j+1],record[i+1][j]}
 */
public class Sequence {
    public static void main(String[] args) {
        int[][] record = Sequence.compute("ABCBDAB", "BDCABA");
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
                    record[i][j] = Math.max(record[i][j - 1], record[i - 1][j]);
            }
        }
        return record;
    }
}

