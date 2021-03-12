/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 
 * Input: head = [1,2,2,1]
 * Output: true
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
    
  
    public boolean isPalindrome(ListNode head) {
        
       /*recursive approach to check the head with the last value of node*/
       // boolean palindromic = true;
        ListNode start = new ListNode(-1);
        start.next = head;
        return checkPalindromic(start,head);
    
    }
    
    private boolean checkPalindromic(ListNode start, ListNode end)
    {
       if(end==null)
           return true;
        
        //Keep start to point at the first node while making the end reach the end Node recursively
        //When returning from each recursion check if the value is equal to start.next (which initially is equal to head)
        //Update the value of start on each recursion
        boolean checkNext = checkPalindromic(start, end.next);
        boolean checkCurrent = false;
        
        if(start.next.val == end.val)
            checkCurrent = true;
        else
            checkCurrent = false;
        
        start.next = start.next.next;
        
        return checkNext && checkCurrent;
    }
}