package claudius.leetcode.question213;

/**
 * 一个正整数数组中值的最大和，其中不能有任意两个值相邻。其中第一个和最后一个视为相邻。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1, 1, 2, 5};
        System.out.println(solution.rob(nums));
    }

    /**
     * 最蠢的办法，参考198题的解题方法，遍历两次，第一种 recordContain  第二种 recordNoContain
     * 第一种记录以每个下标为最后值的和值
     * 第二种记录以每个下标为最后值的和值，其中该次遍历不包含数组中第一个值
     * <p>
     * 最后对比
     * 如果recordContain[length-1] 包含第一个值
     * 对比 recordContain[lenth-2]  recordNoContain[length-1]  recordContain[length-3]
     * 如果recordContain[length-1] 不包含第一个值
     * 对比 recordContain[length-1] recordContain[length-2]
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.max(nums[0], nums[1]);

        int[] recordContain = new int[length];
        recordContain[0] = nums[0];
        recordContain[1] = nums[1];

        int[] recordNoContain = new int[length];
        recordNoContain[0] = 0;
        recordNoContain[1] = nums[1];

        boolean[] judge = new boolean[length];
        judge[0] = true;

        for (int i = 1; i < length; i++) {
            judge[i] = false;
        }

        for (int i = 2; i < length; i++) {
            if (i == 2) {
                recordContain[i] = recordContain[0] + nums[i];
                judge[i] = true;
                recordNoContain[i] = recordNoContain[0] + nums[i];
            } else {
                if (recordContain[i - 2] + nums[i] >= recordContain[i - 3] + nums[i]) {
                    recordContain[i] = recordContain[i - 2] + nums[i];
                    judge[i] = judge[i - 2];
                } else {
                    recordContain[i] = recordContain[i - 3] + nums[i];
                    judge[i] = judge[i - 3];
                }
                recordNoContain[i] = Math.max(recordNoContain[i - 2] + nums[i], recordNoContain[i - 3] + nums[i]);
            }
        }

        if (recordContain[length - 1] > recordContain[length - 2]) {
            if (judge[length - 1]) {
                return Math.max(Math.max(recordContain[length - 2], recordNoContain[length - 1]), recordContain[length - 3]);
            } else
                return recordContain[length - 1];
        } else
            return recordContain[length - 2];

    }


}
