package claudius.leetcode.question91;

/**
 * 1-26分别对应A-Z
 * 给定一个数字字符串，判断这个字符串能够解析成多少种A-Z的字符串
 * 12 可以解析为 AB 也可以解析为 L
 * 动态规划，先计算最后一个
 * <p>
 * 中间需要注意，当该值为0的时候，那么从该值开始的字符串的解析个数为0个
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("1010"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int[] record = new int[length + 1];
        //额外加的一个位置，用来给最后两个字符串在10-26之间时提供值来加
        record[length] = 1;
        //最后一个字符，如果为'0'则是0，如果不为'0'则是1
        record[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
        //从倒数第二个字符开始算起
        for (int i = length - 2; i >= 0; i--) {
            //如果为0，则等于0，否则判断他开始的两个值是否位于10-26之间，若是则等于record[i + 1] + record[i + 2]
            if (s.charAt(i) != '0') {
                String temp = s.substring(i, i + 2);
                if (Integer.parseInt(temp) <= 26) {
                    record[i] = record[i + 1] + record[i + 2];
                } else
                    record[i] = record[i + 1];
            }
        }
        return record[0];
    }
}
