package claudius.leetcode.question198;

/**
 * 一个正整数数组中值的最大和，其中不能有任意两个值相邻。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1, 1, 5, 2};
        System.out.println(solution.rob(nums));
    }

    /**
     * 思路1
     * 计算以每个下标为结束点的和值
     * 每个下标结束最大的和值为 record[i-2]+nums[i] 与 record[i-3]+nums[i] 中较大的一个
     * 最后最大值出现在 record[length-1] record[length-2]中的一个
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length==1)
            return nums[0];
        int max = nums[0];
        int[] record = new int[length];
        record[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (i > 2) {
                record[i] = Math.max(record[i - 2] + nums[i], record[i - 3] + nums[i]);
            } else if (i == 2) {
                record[i] = record[i - 2] + nums[i];
            } else {
                record[i] = nums[i];
            }
        }
        return Math.max(record[length - 1], record[length - 2]);
    }

    /**
     * 思路2
     *
     * 计算以每个点为结束点的最大和值，不一定以该点为结束点。
     * 当前点的最大和值为 record[i-1] record[i-2]+nums[i] 的较大值
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return nums[0];
        int[] record = new int[length];
        record[0] = nums[0];
        record[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            record[i] = Math.max(record[i - 1], record[i - 2] + nums[i]);
        }
        return record[length - 1];
    }


}
