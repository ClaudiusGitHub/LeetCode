package claudius.leetcode.question1;

/**
*   给定一个数组，如果存在两个值等于目标值，给出这两个值的下标
*example： 
*  	Given nums = [2, 7, 11, 15], target = 9,
*	Because nums[0] + nums[1] = 2 + 7 = 9,
*	return [0, 1].
*
*
*
**/

public class Solution {
	/**
	*   nums 数组，target目标值
	*   
	*/
    public int[] twoSum(int[] nums, int target) {
     for(int index1=0;index1<nums.length;index1++){
         for(int index2=nums.length-1;index2>index1;index2--){
             if(nums[index1]+nums[index2]==target){
                 return new int[] {index1,index2};
             }
         }
     }   
     return new int[]{-1,-1};
    }
}