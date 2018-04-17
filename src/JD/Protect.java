package JD;

import java.util.Scanner;

/**
 * 给定一组数，这组数组成环装，相邻的数可以彼此看到，不相邻的数，如果中间值没有超过二者的，那么二者可以彼此看到
 * 即，A想看到C，那么顺时针或者逆时针方向不得有中间某个值高于A
 * 然后求出能够彼此看到的所有对数
 */
public class Protect {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = in.nextInt();
        }
        compute(nums);
    }

    public static void compute(int[] numbers) {
        int sum = 0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                sum += judge(numbers, i, j);
            }
        }
        System.out.println(sum);
    }

    public static int judge(int[] numbers, int left, int right) {
        if (right - left == 1)
            return 1;
        int length = numbers.length;
        if (left == 0 && right == length - 1)
            return 1;
        //分别表示  向右遍历时，left看right 和right看left能不能看到
        boolean leftFlag = true;
        boolean rightFlag = true;
        /**
         * 向右遍历中间的所有数，判断从左侧看右侧能否看到，从右侧看左侧能否看到
         */
        for (int i = left + 1; i < right; i++) {
            if (numbers[i] > numbers[left]) {
                leftFlag = false;
            }
            if (numbers[i] > numbers[right]) {
                rightFlag = false;
            }
        }
        //说明两个能通，直接返回1
        if (leftFlag && rightFlag)
            return 1;
        /**
         * 向左遍历中间的所有数，分成两部分，左半截和右半截
         */
        boolean leftFlag2 = true;
        boolean rightFlag2 = true;
        /**
         * 左半截
         */
        for (int i = 0; i < left; i++) {
            //向左没通再判断向右的，通了不用判断
            if (!leftFlag && numbers[i] > numbers[left])
                leftFlag2 = false;
            //向左没通再判断向右的，通了不用判断
            if (!rightFlag && numbers[i] > numbers[right])
                rightFlag2 = false;
        }
        /**
         * 这种情况是因为 向右没通过，并且向左的左半截也没通过，那么向左的右半截不用遍历了，直接否
         */
        if ((leftFlag == false && leftFlag2 == false) || (rightFlag == false && rightFlag2 == false))
            return 0;

        /**
         * 右半截
         */
        for (int i = right + 1; i < length; i++) {
            //向左没通再判断向右的，通了不用判断
            if (!leftFlag && numbers[i] > numbers[left])
                leftFlag2 = false;
            //向左没通再判断向右的，通了不用判断
            if (!rightFlag && numbers[i] > numbers[right])
                rightFlag2 = false;
        }

        if ((leftFlag || leftFlag2) && (rightFlag2 || rightFlag))
            return 1;
        else
            return 0;
    }
}
