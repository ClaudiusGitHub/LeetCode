package claudius.leetcode.question2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 给定两个链表，然后按照顺序将两个链表对应结点相加，如果大于0则进位，最后返回存储新值的链表
 * Example：
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {
    /**
     * 将两个链表相加
     * l1 l2 为两个输入链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode index = l1;                      //将l2的值加入到l1中，最后直接返回l1即可，不用再建立新值
        for (; l1.next != null && l2.next != null; ) {   //两个链表都有对应值时，相加，直到其中一个链表结点的下一个结点为null，即倒数第二个结点
            l1.val = l1.val + l2.val;
            if (l1.val >= 10) {                     //如果当前结点需要进行进位，则-10，并且下一个结点数据+1。
                l1.val -= 10;
                l1.next.val += 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next == null && l2.next == null) {     //如果两个链表都到倒数第一个了，那么判断当前结点和是否大于1，如果大于1，则新建一个结点
            l1.val = l1.val + l2.val;
            if (l1.val >= 10) {
                l1.val -= 10;
                l1.next = new ListNode(1);
            }
        } else {                                 //如果其中一个链表结点未到倒数第一个，则执行
            l1.val = l1.val + l2.val;              //当前结点相加
            if (l1.next == null) {                 //如果是l2未到最后一个，则将l2后续结点赋值给l1
                l1.next = l2.next;
            }
            for (; l1.val >= 10 && l1.next != null; ) {  //如果当前结点值大于10，则继续进行循环，直到当前结点值小于10或者到了倒数第一个结点。
                l1.val -= 10;
                l1.next.val += 1;
                l1 = l1.next;
            }
            if (l1.val == 10) {                    //判断最后一个结点是否需要进位

                l1.val -= 10;
                l1.next = new ListNode(1);
            }
        }

        return index;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}