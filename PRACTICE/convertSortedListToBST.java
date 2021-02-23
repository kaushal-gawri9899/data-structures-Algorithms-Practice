/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        //Approach 1 is to find the middle element of the linked list
        //Once we have the middle element, elements before the middle element can be added to our left side of tree and elements after the middle on the right side where middle is the root(as linked list is sorted)
        
        if(head==null)
            return null;
        
        ListNode middle = getMiddleElement(head);
        
        TreeNode root = new TreeNode(middle.val);
        
        //Base case when head = middle
        if(head==middle)
            return root;
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        
        return root;
        
    }
    
    private ListNode getMiddleElement(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(prev!=null)
            prev.next = null;
        
        return slow;
    }
}