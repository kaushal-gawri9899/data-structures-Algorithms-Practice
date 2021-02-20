/** 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
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
    public boolean hasCycle(ListNode head) {
        
        //Check if the next pointer is ever equal to any value passed till now
        
        
        //Contant Space Solution
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        while(ptr2!=null && ptr2.next!=null)
        {
            ptr1=ptr1.next;
            ptr2=ptr2.next.next;
            
            if(ptr1==ptr2)
                return true;
        }
        
        return false;
        
        //O(n) space and O(n) time
//         ListNode start = head;
//         HashSet<ListNode> set = new HashSet<ListNode>();
        
//         while(start.next!=null)
//         {
//             if(set.contains(start.next))
//                 return true;
//             set.add(start.next);
//             start = start.next;
            
//         }
        
//         return false;
//     }
    }
}