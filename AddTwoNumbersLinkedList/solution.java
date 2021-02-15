/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //Start iterating both the list
        //Calculate the sum
        //If sum is greater than 10 or if sum/10 > 0, increment the val (carryforward)
        //Make the next Node have initial value to be equal to carryforward
        //Make the current Node have value of sum%10
        
        ListNode newNode = new ListNode(0);
        ListNode firstNode = l1;
        ListNode secondNode = l2;
        
        ListNode currNode = newNode;
        int val = 0;
        
        while(firstNode!=null || secondNode!=null){
            int valueFirst=0;
            int valueSecond=0;
            int sum = 0;
            if(firstNode!=null)
                valueFirst = firstNode.val;
            else 
                valueFirst = 0;
            
            if(secondNode!=null)
                valueSecond = secondNode.val;
            else
                valueSecond = 0;
            
            sum = valueFirst + valueSecond + val;
            
            val=sum/10;
            currNode.next = new ListNode(sum%10);
            
            currNode = currNode.next;
            if(firstNode!=null)
            firstNode = firstNode.next;
            if(secondNode!=null)
            secondNode = secondNode.next;
            
        }
        
        if(val > 0){
            currNode.next = new ListNode(val);
        }
        
        return newNode.next;
    }
}