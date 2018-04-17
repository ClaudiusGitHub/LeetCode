package claudius.leetcode.question84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调递增栈 保存了递增的数组，数据入栈前记录他之前出栈的数的数目，数字出栈时
 * 加上他后面数的数目。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 5, 7, 4, 8, 1, 0};
        System.out.println(solution.largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] heights) {
        int sum = 0;
        int length = heights.length;
        Deque<Record> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temp = heights[i];
            //如果为空或者比栈顶大，那么入栈
            if (queue.size() == 0 || queue.getLast().value <= temp) {
                queue.add(new Record(1, temp));
            } else {
                int pre = 0;
                //大与当前值的依次出栈
                while (queue.size() > 0 && queue.getLast().value > temp) {
                    Record out = queue.removeLast();
                    //当前的num只保留了他之前比他大的，现在要加上他后面比他大的，就是上一个出栈的num
                    out.num += pre;
                    if (out.num * out.value > sum)
                        sum = out.num * out.value;
                    //大于等于后面一个所有的个数
                    pre = out.num;
                }
                queue.add(new Record(1 + pre, temp));
            }
        }
        int pre = 0;
        while (!queue.isEmpty()) {
            Record out = queue.removeLast();
            out.num += pre;
            if (out.num * out.value > sum)
                sum = out.num * out.value;
            pre = out.num;
        }
        return sum;
    }

    class Record {
        public Record(int num, int value) {
            this.num = num;
            this.value = value;
        }

        int num;
        int value;
    }
}
