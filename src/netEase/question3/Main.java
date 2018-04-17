package netEase.question3;
/**
 * 网易 音符 差值和最小
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = in.nextInt();
        }
        compute(nums);

    }

    public static void compute(int[] nums) {
        int sum = Integer.MAX_VALUE;
        int length = nums.length;
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int curSum = 0;
            int lowPre = -1;
            int highPre = -1;
            int temp = nums[i];
            if (record.contains(temp))
                continue;
            record.add(temp);
            for (int j = 0; j < length; j++) {
                if (nums[j] < temp) {
                    if (lowPre == -1)
                        lowPre = nums[j];
                    else {
                        curSum += Math.abs(nums[j] - lowPre);
                        if (curSum >= sum)
                            break;
                        lowPre = nums[j];
                    }
                } else {
                    if (highPre == -1)
                        highPre = nums[j];
                    else {
                        curSum += Math.abs(nums[j] - highPre);
                        if (curSum > sum)
                            break;
                        highPre = nums[j];
                    }
                }
            }
            if (curSum < sum)
                sum = curSum;
        }
        System.out.println(sum);
    }
}
