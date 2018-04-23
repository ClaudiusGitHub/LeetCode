package claudius.leetcode.question300;

/**
 * 最长递增子序列
 * <p>
 * 建立一个dp数组用来存储以每个下标值为终点的最长递增子序列。
 * 当查询以i为终点的最长递增子序列，遍历dp数组的0-i-1的值
 * 以i为终点的最长递增子序列为 max(dp'[j]) 其中 0 <= j< i,且num[j] < num[i]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(solution.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int maxNum = 1;
        int[] record = new int[length];
        record[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (record[j] + 1 > max) {
                        max = record[j] + 1;
                    }
                }
            }
            record[i] = max;
            if (max > maxNum) {
                maxNum = max;
            }
        }
        return maxNum;
    }
}
