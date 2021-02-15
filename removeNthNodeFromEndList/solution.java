/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //Use a two pointer approach
        int count = 0;
        ListNode prev = null, currNode = head, toSave = head;
        
        if(head == null || head.next==null)
            return null;
       
        //travel to the value whose next is the node to be deleted
        while(n-->0){
            currNode = currNode.next;
        }
        
        if(currNode==null){
            head = head.next;
        }
        else{
            while(currNode.next!=null){
                prev = toSave;
                toSave = toSave.next;
                currNode = currNode.next;
            }
            toSave.next = toSave.next.next;
            
        }
        return head;
        
}
}