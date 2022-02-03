package Leetcode.Java_code;

public class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /************************************************
     * @description
     * 用数组初始化链表
     *
     * @param num 用于存放初始化数据的数组
     *
     * @return
     * 正确输出：链表头结点
     * num为空：null
     */
    public static ListNode initlist(int[] num) {
        if (num.length == 0)
            return null;

        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode last = new ListNode();

        for (int i : num) {
            cur.val = i;
            cur.next = new ListNode();
            last = cur;
            cur = cur.next;
        }
        last.next = null;

        return head;
    }

    public static void printList(ListNode L) {
        for (ListNode i = L; i != null; i = i.next)
            if (i.next != null)
                System.out.print(String.valueOf(i.val) + "->");
            else System.out.print(String.valueOf(i.val));
    }
}
