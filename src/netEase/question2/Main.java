package netEase.question2;

import java.util.Scanner;

/**
 * 最长公共子串的串的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = str.length() / 2;
        int[][] result = new int[length][length];
        for (int i = 0; i < length; i++) {
            result[i][0] = 1;
            result[i][i] = 1;
        }
        int sum = 0;
        for (int i = 2; i < length; i++) {
            for (int j = 1; j < i; j++) {
                result[i][j] = result[i - 1][j - 1] * (j + 1);
                if (i == length - 1) {
                    sum += result[i][j];
                }
            }
        }
        System.out.println(sum + 1);
    }
}
