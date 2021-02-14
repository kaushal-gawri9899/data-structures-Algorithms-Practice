
/*
Write a program to find the node at which the intersection of two singly linked lists begins.

example :
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int flag = 0;
        
        //Two Pointer approach
        //Iterate to both the linked lists until you encounter end of list or find a common node
        //If encountered null, update the pointer to point at head of B and A as required
        //Else return the node
        
        ListNode temp = headA;
        ListNode curr = headB;
        
        if(headA == null || headB == null)
            return null;
        
        while(true){
            if(flag==2)
                break;
            
            if(temp==null){
                flag++;
                temp = headB;
            }
            
            if(curr==null){
                curr = headA;
            }
            
            if(temp==curr)
                return temp;
            
            temp = temp.next;
            curr = curr.next;
        }
        
        return null;
        
    }
}