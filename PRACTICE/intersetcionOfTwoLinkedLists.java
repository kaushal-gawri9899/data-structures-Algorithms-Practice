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
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        int flag=0;
        
        if(headA==null || headB==null)
            return null;
        
        while(true)
        {
            //Flag would become two only when we reach the end of both the lists
            //In that case there won't be any intersection found and hence we return null outside the loop
            if(flag==2)
                break;
            
            //Specifies that we got to the end of first linkedlist 
            if(ptr1==null)
            {
                flag++;
                ptr1 = headB;
            }
            
            if(ptr2==null)
                ptr2=headA;
            
            //If at any point both the nodes become equal, it is the intersection
            if(ptr1==ptr2)
                return ptr1;
            
            ptr1=ptr1.next;
            ptr2=ptr2.next;
                
        }
        
        return null;
    }
}