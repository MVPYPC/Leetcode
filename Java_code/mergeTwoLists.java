package Leetcode.Java_code;

public class mergeTwoLists {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode cur = new ListNode();
        ListNode head = cur;
        if(list1 == null && list2 == null) return null;
        while (cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val) {
                cur.val = cur1.val;
                cur1 = cur1.next;
            }
            else {
                cur.val = cur2.val;
                cur2 = cur2.next;
            }
            cur.next = new ListNode();
            cur = cur.next;
        }
        ListNode remain = cur1 == null ? cur2 : cur1;
        while(remain != null){
            cur.val = remain.val;
            remain = remain.next;
            if(remain != null){
                cur.next = new ListNode();
                cur = cur.next;
            }
            else cur.next = null;
        }
        return head;
    }

    public ListNode pasteMerge(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return  list1;
        ListNode head = list1.val < list2.val ? list1 : list2;
        if(list1.val < list2.val)
            list1 = list1.next;
        else list2 = list2.next;

        ListNode cur = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head;
    }

    public static void main(String[] args){
        ListNode.printList(new mergeTwoLists().pasteMerge(ListNode.initlist(new int[]{1,2,4}), ListNode.initlist(new int[]{1,3,4})));
    }
}
