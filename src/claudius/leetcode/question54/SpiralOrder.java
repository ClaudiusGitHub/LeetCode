package claudius.leetcode.question54;

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
public class SpiralOrder {
	public static void main(String args[]){
		Solution st=new Solution();
		int [][]matrix={{1},{2},{3},{4},{5},{6},{7}};
		System.out.println(st.spiralOrder(matrix));
		
	}
}
