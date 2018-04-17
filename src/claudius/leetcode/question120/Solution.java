package claudius.leetcode.question120;
/**
 * ***[2],
 * **[3,4],
 * *[6,5,7],
 * [4,1,8,3]
 * 从第一行走到最后一行， 从这样的三角数中找出一条和最小的路径，2 ->3 ->5 ->1
 * 每个数只能走到下面相邻的数上
 * 动态规划，记录每一行的最小值，从小到大进行遍历
 */

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        Integer integer = list.get(0);
        System.out.println(list.get(0));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int num = triangle.size();
        if (num == 1) {
            return triangle.get(0).get(0);
        }
        int[] record = new int[num];
        //最后一行赋值
        for (int i = 0; i < num; i++) {
            record[i] = triangle.get(num - 1).get(i);
        }
        //从倒数第二行开始
        for (int i = num - 2; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            //这个值到下面的和最小为它的值加下一行相邻的和中较小的一个
            for (int j = 0; j <= i; j++) {
                record[j] = temp.get(j) + Math.min(record[j], record[j + 1]);
            }
        }
        //返回第一行只有一个，所以为0
        return record[0];
    }
}
