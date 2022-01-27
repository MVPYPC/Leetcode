package Leetcode.Java_code;

import java.util.Stack;

/***************************************************
 * @question
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @tips
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */

public class removeNthFromEnd {
    public ListNode removeByStack(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            length++;
        }
        if (n == length) {
            assert head != null;
            cur = head.next;
            head.next = null;
            return cur;
        } else if (n == 1) {
            stack.pop();
            assert stack.peek() != null;
            stack.peek().next = null;
            return head;
        } else {
            for (int i = 1; i != n - 1; i++)
                stack.pop();
            ListNode latter = stack.pop();
            ListNode middle = stack.pop();
            ListNode former = stack.pop();
            former.next = latter;
            middle.next = null;
        }
        return head;
    }

    public ListNode remove(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; ++i) //fast指针先出发
            fast = fast.next;

        while (fast != null) { //一起走
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode.printList(new removeNthFromEnd().removeByStack(ListNode.initlist(new int[]{1}), 1));
    }
}
