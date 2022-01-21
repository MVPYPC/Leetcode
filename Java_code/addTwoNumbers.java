package Leetcode;

/***************************************************
 * @question
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @tips
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @datastruct
 * 详见ListNode.java
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class addTwoNumbers {

    /************************************************
     * @description
     * 用指针思想进行遍历，只需各遍历一遍，貌似时间复杂度还行，Leetcode上超过了100%
     *
     * @time 1ms
     *
     * @memory 38.3MB
     *
     * @Version 1.0
     *
     * @param l1 非空链表
     *
     * @param l2 非空链表
     *
     * @return
     * 表示和的链表
     */
    public static ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode result = new ListNode(0, null);
        ListNode cur1 = new ListNode(l1.val, l1.next);
        ListNode cur2 = new ListNode(l2.val, l2.next);
        ListNode cur = result;
        ListNode last = cur;
        ListNode rmn;

        while (cur1 != null && cur2 != null) {
            cur.val = (cur1.val + cur2.val + c) % 10;
            c = (cur1.val + cur2.val + c) / 10;
            cur.next = new ListNode(0, null);
            last = cur;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        if (cur1 == null && cur2 == null) {
            if (c == 1)
                cur.val = c;
            else
                cur = last;
            cur.next = null;
            return result;
        } else
            rmn = (cur1 == null) ? cur2 : cur1;

        while (rmn != null) {
            cur.val = (rmn.val + c) % 10;
            c = (rmn.val + c) / 10;
            cur.next = new ListNode(0, null);
            last = cur;
            cur = cur.next;
            rmn = rmn.next;
        }

        if (c == 1)
            cur.val = c;
        else
            cur = last;
        cur.next = null;
        return result;
    }

    /****
     * @test1
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * @test2
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     *
     * @test3
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */
    public static void main(String[] args){
        ListNode l1 = ListNode.initlist(new int[]{2, 4, 3});
        ListNode l2 = ListNode.initlist(new int[]{5, 6, 4});
        assert l1 != null;
        assert l2 != null;
        ListNode l3 = addTwoNumbers_v1(l1,l2);
        ListNode.printList(l3);
    }
}
