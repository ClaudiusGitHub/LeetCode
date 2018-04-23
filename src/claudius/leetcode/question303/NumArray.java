package claudius.leetcode.question303;


/**
 * 返回一个数组中两个下标间的数字和
 * <p>
 * 调用次数过多，直接存储0-i的和的dp数组
 * <p>
 * 每次调用get(i,j) dp[j] - dp[i] + nums[i]，如果使用dp[j]- dp[i-1] 需要考虑i为0的情况
 */
public class NumArray {

    private int[] record;
    private int[] nums;

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 5));
    }

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            this.record = null;
            return;
        }
        this.nums = nums;
        int length = nums.length;
        record = new int[length];
        record[0] = nums[0];
        for (int i = 1; i < length; i++) {
            record[i] = record[i - 1] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        if (record == null)
            return 0;
        return record[j] - record[i] + nums[i];
    }
}
