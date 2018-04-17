package claudius.leetcode.question3;

/**
 * 最长不含重复字符的子串，用set实现，存储以某个值结束的最长不重复子串，然后递增，
 * 如果遇到重复的，移除重复的字符及它之前的子串，用个left表示当前子串从啥时候开始的。
 */

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bpfbhmipx"));
    }

    public int lengthOfLongestSubstring(String s) {
        int sum = 0;  //最长的记录
        int num = s.length(); //字符数
        int left = 0;
        HashSet<Character> set = new HashSet(); //用来存储字符，起到重复检测的作用
        //从0开始，往set里面添加字符，遇到重复的，将之前重复的字符与重复的字符之前的字符都移除。
        //移除的时候记录当前的size，与sum比较，并用left记录移除字符下一个位置，表示下一个最长不重复子串是从left开始的
        for (int i = 0; i < num; i++) {
            char temp = s.charAt(i);
            //没重复就继续加
            if (!set.contains(temp)) {
                set.add(temp);
            } else {
                //重复了就判断下size与sum，此时size是最大的
                if (set.size() > sum)
                    sum = set.size();
                //递减
                for (int j = left; j < i; j++) {
                    char temp2 = s.charAt(j);
                    if (temp2 == temp) {
                        left = j + 1; //记录下一个开始的下标
                        break;
                    }
                    set.remove(temp2);
                }
            }
        }

        //最后还要做一次比较
        return sum > set.size() ? sum : set.size();
    }
}
