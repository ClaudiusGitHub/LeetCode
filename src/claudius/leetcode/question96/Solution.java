package claudius.leetcode.question96;

/**
 * 给一个数n，判断从1-n的整数序列能生成多少个二叉排序树
 * 参考question95，但是不需要递归，因为只需要计算次数，所以用一个数组动态统计数值
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(4));
    }

    public int numTrees(int n) {
        if (n <= 2)
            return n;
        int[] record = new int[n + 1];
        record[0] = 1;
        record[1] = 1;
        record[2] = 2;
        for (int i = 3; i <= n; i++) {
            record[i] = 0;
            for (int j = 1; j <= i; j++) {
                record[i] += record[j - 1] * record[i - j];
            }
        }
        return record[n];
    }
}
