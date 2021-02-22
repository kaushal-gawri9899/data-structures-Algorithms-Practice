/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
       ListNode current = head;
       ListNode prev = null;
        
       //Decrease the value of left index until it becomes 1, also reduce the right index until it reaches the left index
       while(left>1)
       {
           prev = current;
           current = current.next;
           left--;
           right--;
       }
        
       //These are the two nodes before the left index 
       ListNode start = prev;
       ListNode end = current;
        
       ListNode currNext = null;
        
       //Reverse the node untill right becomes zero
       //This reverse all the nodes between left and right as current.next points at node at left
       while(right>0)
       {    
           currNext = current.next;
           current.next = prev;
           prev = current;
           current = currNext;
           right--;
       }
        
        if(start!=null)
            start.next = prev;
        else
            head = prev;
        
        end.next = current;
        return head;
    }
}