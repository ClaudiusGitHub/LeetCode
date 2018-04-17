package claudius.leetcode.question152;

/**
 * 求解一个数组中相邻坐标值的连乘积，取最大。
 *
 * 思路：
 *   记录当前连乘积的最大最小值 high[0],low[0] = nums[0]
 *   然后以下一个为终点的连乘积最大最小值为 nums[i]*high[0] nums[i]*low[0] nums[i]
 *   这三个数中取最大最小赋值给high[i] low[i]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {2,3,-2,4};
        System.out.println(solution.maxProduce(array));
    }

    public int maxProduce(int[] nums) {
        int length = nums.length;
        int[] high = new int[length];
        high[0] = nums[0];
        int[] low = new int[length];
        low[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            int highTemp = high[i - 1] * nums[i];
            int lowTemp = low[i - 1] * nums[i];
            if (highTemp > lowTemp) {
                high[i] = highTemp > nums[i] ? highTemp : nums[i];
                low[i] = lowTemp < nums[i] ? lowTemp : nums[i];

            } else {
                high[i] = lowTemp > nums[i] ? lowTemp : nums[i];
                low[i] = highTemp < nums[i] ? highTemp : nums[i];
            }
            if (high[i] > max) {
                max = high[i];
            }
        }
        return max;
    }
}
