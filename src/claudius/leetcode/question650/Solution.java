package claudius.leetcode.question650;

/**
 * dp问题
 * 2 Keys Keyboard [https://leetcode.com/problems/2-keys-keyboard/]
 * 键盘有一个字符，只有两种操作
 * 1、复制当前所有的串
 * 2、打印你已经复制的串
 * 求最小的操作次数
 * 比如 AAAA
 * 1）复制A
 * 2）粘贴A
 * 3）粘贴A
 * 4）粘贴A
 * 四步操作
 * <p>
 * <p>
 * 状态转移方程为 record[i] = min(i,record[j]+j/i) 其中j能被i整除，且j区间为[1,i/2]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(8));

    }

    public int minSteps(int n) {
        int[] record = new int[n + 1];
        if (n >= 1) {
            record[1] = 0;
        } else {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    record[i] = Math.min(i, record[j] + i / j);
                }
                if (i / j < 2)
                    break;
            }
        }
        return record[n];
    }
}
