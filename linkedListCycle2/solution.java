/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head==null || head.next==null)
            return null;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        boolean cyclePresent = false;
        
        while(ptr2!=null && ptr2.next!=null)
        {
            ptr1=ptr1.next;
            
            ptr2=ptr2.next.next;
            
            if(ptr1==ptr2)
            {
                cyclePresent=true;
                break;
            }
        }
        
        if(!cyclePresent)
            return null;
        
        //We start one pointer from the start of the list
        //The other pointer as at their meeting point
        //The loop will break out as it will only go here if there's a cycle
        //And both the pointers will definitely meet at the cycle where ptr2 will point at meeting point which will be ptr1
        ptr1=head;
        while(ptr1!=ptr2)
        {
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        return ptr1;
    }
}