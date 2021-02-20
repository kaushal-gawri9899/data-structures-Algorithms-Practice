/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
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
    public void reorderList(ListNode head) {
        
        //Approach one, use extra space say a stack and add all the nodes
        //Iterate over the stack and after every two nodes, update the references to the node and remove them from stack
        
        //Approach two, first find the middle of the linked list
        //Reverse the nodes after the middle element
        //Start iterating from head and update its references with the values after the middle sequentially
        
        if(head==null)
            return;
        
        ListNode middleHead = splitLinkedList(head);
        middleHead = reverseOrderAfterMiddle(middleHead);
        
        head = mergeInOrder(head,middleHead);
        
        //return head;
        
        
    }
    
    private ListNode splitLinkedList(ListNode head)
    {
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        
        while(ptr2!=null && ptr2.next!=null)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        
        ListNode middleHead = ptr1.next;
        ptr1.next = null;
        
        return middleHead;
    }
    
    
    private ListNode reverseOrderAfterMiddle(ListNode head)
    {
        ListNode current = head;
        ListNode prev = null;
        
        while(current!=null)
        {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
    
    
    private ListNode mergeInOrder(ListNode head, ListNode middleHead)
    {
        ListNode temp1 = head;
        ListNode temp2 = middleHead;
        
        
        while(temp1!=null && temp2!=null)
        {
            //make temp variables
            ListNode currNext1 = temp1.next;
            ListNode currNext2 = temp2.next;
            
            //Make the next of temp1 point to element after middle(middleHead)
            //Make the next of temp2 point at earlier next of temp1
            temp1.next = temp2;
            temp2.next = currNext1;
            
            //Increment to iterate through linkedlist
            temp1 = currNext1;
            temp2 = currNext2;
        }
        
        return temp1;
    }
}