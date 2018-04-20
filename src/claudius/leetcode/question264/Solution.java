package claudius.leetcode.question264;


/**
 * 丑数：只有2 3 5为因数的数 1是第一个丑数
 * 1 2 3 4 5 6 8 9 10 12 15 16 18
 * <p>
 * 解决思路：
 * 每个丑数均为之前的丑数*2 或者 *3或者*5，因此均从第一个丑数开始，三个丑数的下标对应的值*以对应的数（2,3,5），
 * 选择较小的那个即为该坐标当前的丑数值，然后该数对应的下标+1
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 15; i++) {
            System.out.print(solution.nthUglyNumber(i) + "  ");
        }
        ;
    }

    public int nthUglyNumber(int n) {
        int[] record = new int[n];
        record[0] = 1;
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        for (int i = 1; i < n; i++) {
            int twoTemp = record[twoIndex] * 2;
            int threeTemp = record[threeIndex] * 3;
            int fiveTemp = record[fiveIndex] * 5;
            int minValue = Math.min(twoTemp, Math.min(threeTemp, fiveTemp));

            if (minValue == twoTemp)
                twoIndex++;
            if (minValue == threeTemp)
                threeIndex++;
            if (minValue == fiveTemp)
                fiveIndex++;

            record[i] = minValue;
        }
        return record[n - 1];
    }
}
