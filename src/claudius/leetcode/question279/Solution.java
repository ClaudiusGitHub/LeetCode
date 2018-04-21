package claudius.leetcode.question279;

/**
 * 完美平方数
 * 1，4，9，16…… 这些数为平方数
 * 给任意一个数n，使用最少的平方数的和表示n，求其最少的数量为多少
 * <p>
 * 动态规划，计算从1-n所有的所需的平方数的和  nums[n+1]
 * <p>
 * 对于i可知，求其和的最少的平方数的数量为 :
 * min(nums[i-k^2],nums[i-(k-1)^2],nums[i-(k-2)^2],……,nums[i-1^2])+1，其中k^2 <= i
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSquares(12);
    }

    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            int temp = (int) Math.sqrt(i);


            for (int j = temp; j >= 1; j--) {
                int step = j * j;
                if (nums[i - step] == 0) {
                    minNum = 1;
                    break;
                }
                if (nums[i - step] + 1 < minNum)
                    minNum = nums[i - step] + 1;
            }
            nums[i] = minNum;
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.print(nums[i] + " ");
//        }
        return nums[n];
    }
}
