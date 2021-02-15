/**
Remove all elements from a linked list of integers that have value val.
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode current = new ListNode(0);
        current.next = head;
        ListNode prev = current;
       
        while(head!=null)
        {

            //If it is not the required value we make the next of the node equal to our new head
            //We make our node point to next of it
            if(head.val!=val)
            {
                prev.next = head;
                prev = prev.next;
                
            }
            head=head.next;
        }
        
        prev.next = null;
        return current.next;
    }
}