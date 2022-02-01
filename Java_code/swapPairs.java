package Leetcode.Java_code;

public class swapPairs {
    public ListNode swap(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0,head);
        ListNode last = dummy;
        ListNode cur_former = dummy.next;
        ListNode cur_latter = head.next;
        ListNode next = cur_latter.next;
        while(true){
            last.next = cur_latter;
            cur_latter.next = cur_former;
            cur_former.next = next;
            last = cur_former;
            if(last.next == null)
                break;
            else{
                cur_former = last.next;
                if(cur_former.next == null)
                    break;
                else{
                    cur_latter = cur_former.next;
                    if(cur_latter == null)
                        break;
                    else
                        next = cur_latter.next;
                }
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode.printList(new swapPairs().swap(ListNode.initlist(new int[]{1,2,3,4})));
    }
}
