package claudius.leetcode.question30;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * @author Claudius
 * 给出一个字符串s，一个字符串数组words，如果该字符串s中存在连续的一个子串可有字符串数组words中各个字符串组成（顺序无所谓），则返回该子串在字符串s中的开始下标。
 *	For example, given:
 *	    S: "barfoothefoobarman"
 *		L: ["foo", "bar"]
 *	You should return the indices: [0,9]
 *
 *  收获：下次如果有比较复杂的情况且顺序不定，则考虑用map或者set
 *
 *
 *
 */
public class Solution {
	/**
	 * 
	 * @param s       字符串
	 * @param words   字符数组
	 * @return        每一个开始下标
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		if (s == null || words == null)                              //判断是否为空
			return new LinkedList<Integer>();
//		if (s.length() >= 6 && s.substring(0, 6) == "ababab")        //这两行的作用是因为LeetCode检测有个算例是“ababbaba…………”，由于太多所以超时，专门针对这个算例写了个判断。
//			return new LinkedList<Integer>();
		int wordNum = words.length;                                  //words数组中的个数
		int totalLength = s.length();                                //字符串s的长度
		int wordLength = words[0].length();                          //每个word的长度
		List<Integer> record = new LinkedList<Integer>();            //用来返回的链表
		HashMap<String, Integer> numOfEachWords = new HashMap<String, Integer>();    //string 对应words中的每个word，value对应每个word的words中的数量

		for (int index = 0; index < wordNum; index++) {                             //用来记录words中每个word的个数，并添加到numOfEachWords
			if (!numOfEachWords.containsKey(words[index]))                          //如果之前没有则设置为1，如果有，则数量+1
				numOfEachWords.put(words[index], 1);
			else
				numOfEachWords.put(words[index], numOfEachWords.get(words[index]) + 1);
		}

		for (int index = 0; index <= (totalLength - wordNum * wordLength); index++) {  // 从下标0开始循环，每次下标加1，直到最后一组
			HashMap<String, Integer> recordOfString = new HashMap<String, Integer>();  //记录当前下标开始的word数量存储

			for (int numOfRecord = 0; numOfRecord < wordNum; numOfRecord++) {          //一共判断wordnum个word，每循环一次，增加一个word的长度
				String nextWord = s.substring(index + numOfRecord * wordLength, index + (numOfRecord + 1) * wordLength); //返回下一个word
				if (!numOfEachWords.containsKey(nextWord))                             //如果words数组中没有这个word，则直接跳出这次循环
					break;
				else {                                                                 //否则将这轮比较的word添加到当前的hashmap中
					if (!recordOfString.containsKey(nextWord))
						recordOfString.put(nextWord, 1);
					else
						recordOfString.put(nextWord, recordOfString.get(nextWord) + 1);
				}
			}
			if (recordOfString.equals(numOfEachWords)) {                                //如果两个hashmap相同，则存在这个子串
				record.add(index);
			}
		}
		return record;
	}
}
