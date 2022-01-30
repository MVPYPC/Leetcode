package Leetcode.Java_code;

public class mergeKLists {
    public ListNode merge(ListNode[] lists) {
        return mergeFromAtoB(lists, 0, lists.length - 1);
    }

    public ListNode mergeFromAtoB(ListNode[] lists, int a, int b){
        if(a > b) return null;
        else if(a == b)
            return lists[a];
        else
            return merge2list(mergeFromAtoB(lists, a, (a + b) / 2), mergeFromAtoB(lists, (a + b) / 2 + 1, b));
    }

    public  ListNode merge2list(ListNode list1, ListNode list2){
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
                cur = cur.next;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head;
    }

    public static void main(String[] args){
        ListNode.printList(new mergeKLists().merge(new ListNode[]{ListNode.initlist(new int[]{1,4,5}),
                                                                ListNode.initlist(new int[]{1,3,4}),
                                                                ListNode.initlist(new int[]{2,6})}));
    }
}
