/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
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
    public ListNode reverseList(ListNode head) {
        
        ListNode current = head;
        ListNode prev = null;
        ListNode currNext = null;

        while(current!=null)
        {
            currNext = current.next;
            current.next = prev;
            prev = current;
            current = currNext;
            
        }
        head = prev;
        return head;
        
                
        /*
            1 -> 2 -> 3 -> 4
            currNext = 2
            current.next = null
            prev = 1
            current = 2
            
            currNext = 3
            current.next = null
            prev = 2
            current = 3
            
            currNext = 4
            current.next = null
            prev = 3
            current = 4
            
            currNext = null
            current.next = null
            prev = 4
            current = null
            
            ----Loop Terminates----
             
        */
    }
}