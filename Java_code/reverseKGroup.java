package Leetcode.Java_code;


/***************************************************
 * @question
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @tips
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */

public class reverseKGroup {
    public ListNode reverse(ListNode head, int k) {
        if (k == 1) return head;
        if (k == 2) return swap(head);
        ListNode[] buf = new ListNode[k];
        ListNode dummy = new ListNode(0, head);
        ListNode last = dummy;
        ListNode cur = last.next;
        while (true) {
            int i;
            for (i = 0; i < k && cur != null; i++) {
                buf[i] = cur;
                cur = cur.next;
            }
            if (i < k)
                break;
            else {
                reverseBuf(last, buf, k);
                last = buf[0];
            }
        }
        return dummy.next;
    }

    public void reverseBuf(ListNode last, ListNode[] buf, int k) {
        ListNode ph = last;

        if (k % 2 == 1) {
            for (int high = k - 1, low = 0; low != k / 2; low++, high--) {
                ph.next = buf[high];
                buf[low].next = buf[high].next;
                buf[high].next = buf[low + 1];
                buf[high - 1].next = buf[low];
                ph = ph.next;
            }
        } else
            for (int high = k - 1, low = 0; low < high; low++, high--) {
                if(buf[low].next == buf[high]){
                    ph.next = buf[high];
                    buf[low].next = buf[high].next;
                    buf[high].next = buf[low];
                }
                else {
                    ph.next = buf[high];
                    buf[low].next = buf[high].next;
                    buf[high].next = buf[low + 1];
                    buf[high - 1].next = buf[low];
                    ph = ph.next;
                }
            }
    }

    public ListNode swap(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode last = dummy;
        ListNode cur_former = dummy.next;
        ListNode cur_latter = head.next;
        ListNode next = cur_latter.next;
        while (true) {
            last.next = cur_latter;
            cur_latter.next = cur_former;
            cur_former.next = next;
            last = cur_former;
            if (last.next == null)
                break;
            else {
                cur_former = last.next;
                if (cur_former.next == null)
                    break;
                else {
                    cur_latter = cur_former.next;
                    if (cur_latter == null)
                        break;
                    else
                        next = cur_latter.next;
                }
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode.printList(new reverseKGroup().reverse(ListNode.initlist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 4));
    }

}
