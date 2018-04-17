package claudius.leetcode.question30;

public class SubString {
    public static void main(String args[]) {
        Solution sll = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(sll.findSubstring(s, words));
    }

}
