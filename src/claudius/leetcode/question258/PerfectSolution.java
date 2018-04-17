package claudius.leetcode.question258; /**
*   给定一个数，将每一位相加，直到其结果为1位数。不能用循环和迭代
*  如  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*  观察可得整数的和为9的循环，可以直接num对9取余，但是为了避免9的倍数，选择
*  1    1
*  2    2
*  3    3
*  4    4
*  5    5
*  6    6
*  7    7
*  8    8    
*  9    9    
*  10    1
*  11    2
*  12    3    
*  13    4
*  14    5
*  15    6
*  16    7
*  17    8
*  18    9
*  19    1
*  20    2
*
*/
/**
*   因为是1-9的循环，所以如果该值为9的倍数，则不可能余9，所以选择nums-1除以9，结果再+1
*/
public class PerfectSolution {
    public int addDigits(int num) {
       
        return (num-1)%9+1;
    }
}