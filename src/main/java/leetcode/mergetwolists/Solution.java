package leetcode.mergetwolists;

public class Solution {

    public static void main(String[] args) {
        System.out.println();
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null){
            current.next = l2;
        } else {
            current.next = l1;
        }

        return head.next;
    }


    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
