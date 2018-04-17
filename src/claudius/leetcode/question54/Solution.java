package claudius.leetcode.question54;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Claudius
 * 给个数组，顺时针打印数组的值
 * 
 *                     [ 1, 2, 3 ]
 *                     [ 4, 5, 6 ]
 *                     [ 7, 8, 9 ]
 *       输出为 [1,2,3,6,9,8,7,4,5]
 */
public class Solution {
	/**
	 * 
	 * @param matrix 输入二维数组
	 * @return 返回数据链表
	 */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return new LinkedList<Integer>();   //先判断这个矩阵是否为空
        List nums=new LinkedList<Integer>();    //定义输出链表
        /*
         * 每次循环便遍历依次该矩阵外圈
         * rowPre     为剩余矩阵的第一行行下标
         * columnPre  为剩余矩阵的第一列列下标
         * rowEnd     为剩余矩阵的末尾行行下标
         * columnEnd  为剩余矩阵的末尾列列下标
         */
        for(int rowEnd=matrix.length-1,columnEnd=matrix[0].length-1,rowPre=0,columnPre=0,index=0;rowEnd>=rowPre&&columnEnd>=columnPre;){
            for(  index=columnPre;index<=columnEnd;index++) //遍历当前剩余矩阵的第一行，因为肯定有第一行，所以只需要判断列数就好
                nums.add(matrix[rowPre][index]);
                rowPre++;                                   //这一行遍历完了，所以首行数+1，保证该行不再被访问
            
            for(  index=rowPre;index<=rowEnd;index++)       //遍历当前剩余矩阵的最后一列，所以打印当前列即可
                nums.add(matrix[index][columnEnd]);
                columnEnd--;                                //这一列遍历完了，所以需要-1，如果没有遍历，即没有剩余需要遍历的了，-1会导致columnEnd小于Pre
            
            for(  index=columnEnd;index>=columnPre&&rowEnd>=rowPre;index--)  //遍历当前剩余矩阵的最后一行，除了判断列数外，还要保证该末行数首行数，因为防止只剩下一行的时候，与第一个循环重复
                nums.add(matrix[rowEnd][index]);
                rowEnd--;                                   //这一行遍历完了，所以需要-1
            
            for(  index=rowEnd;index>=rowPre&&columnEnd>=columnPre;index--)   //遍历当前剩余举着你的第一列，除了判断行数外，还要判断列，防止该列的遍历与第二个循环造成重复
                nums.add(matrix[index][columnPre]);
                columnPre++;                                  //该列遍历完了，所以需要+1
            
        }
        return nums;
        
    }
}