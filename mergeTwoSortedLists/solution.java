/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4] 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            
            current=current.next;
        }
        
        if(l1==null)
            current.next = l2;
        else 
            current.next = l1;
        
        return temp.next;
        
        /*  Recursive   */
//         if(l1==null)
//             return l2;
        
//         if(l2==null)
//             return l1;
        
//         if(l1.val < l2.val)
//         {
//             l1.next = mergeTwoLists(l1.next,l2);
//             return l1;
//         }
//         else
//         {
//             l2.next = mergeTwoLists(l1,l2.next);
//             return l2;
//         }
        
    }
}