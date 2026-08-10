/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode dummy = curr;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ListNode node = new ListNode(l1.val);
                curr.next = node;
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l2.val);
                curr.next = node;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }

    private ListNode divideLists(ListNode[] lists, int start, int end) {
        if(lists[end] == lists[start]) {
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode leftList = divideLists(lists, start, mid);
        ListNode rightList = divideLists(lists, mid + 1, end);
        return mergeTwoLists(leftList, rightList);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return divideLists(lists, 0, lists.length - 1);
    }
}
