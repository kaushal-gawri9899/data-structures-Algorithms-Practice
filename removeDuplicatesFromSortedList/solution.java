/**
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */

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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode newNode = head;
        
        while(newNode!=null && newNode.next!=null)
        {
            int oldVal = newNode.val;
            
            int newVal = newNode.next.val;
            
            if(newVal==oldVal)
            {
                newNode.next = newNode.next.next;
            }
            else
            {
            newNode = newNode.next;
            }
        }
        return head;
    }
}