/**
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
        
        
        //Straight forward approach is to first find the middle element of the node
        //Once we have the middle element of the linked list, we consider it as the root of our tree
        // Then we can recursively add the elements at left and right side of the nodee
        
        //Take care of nullptr
        if(head==null)
            return null;
        
        //Get the middle value
        ListNode middle = getMiddleValue(head);
        
        //Make the root of the tree
        TreeNode rootNode = new TreeNode(middle.val);
        
        //Base Case, when we reach the middle node
        if(head==middle)
            return rootNode;
        
        //Left side of the tree will contain the elements starting from head to middle before
        rootNode.left = sortedListToBST(head);
        //Right side of the tree will contain the elements starting from middle next to end
        rootNode.right = sortedListToBST(middle.next);
        
        return rootNode;
    }
    
    private ListNode getMiddleValue(ListNode head)
    {
        ListNode currNext = head;
        ListNode currNextNext = head;
        
        ListNode prev = null;
        
        while(currNextNext!=null && currNextNext.next!=null)
        {
            
            //make the current node as prev
            prev = currNext;
            //Increment the current node to its next
            currNext = currNext.next;
            //Increment the current node to two positions ahead
            currNextNext = currNextNext.next.next;
            
        
        }
        
        //The case when currNext is equal to head
        if(prev!=null)
            prev.next = null;
        
        return currNext;
    }
    
    //Another way is to first convert linked list to an array and then use that array to convert into binary tree
    
    // Most optimal is to use one of the traversal techniques
    // We are using inorder because after traversal it is always sorted in ascending
    
 /*
 ListNode head;
     public TreeNode sortedListToBST(ListNode head) {
         
         int size  = this.getSizeOfList(head);
         this.head = head;
         
        return makeBST(0,size-1);
        
     }
    
     private int getSizeOfList(ListNode head)
     {
         ListNode current = head;
         int size = 0;
         
         while(current!=null)
         {
             size+=1;
             current=current.next;
         }
         
         return size;
     }
    
    
    private TreeNode makeBST(int left, int right)
    {
       if(left>right)
           return null;
        
       int middle = (left+right)/2;
        
       TreeNode leftNode = this.makeBST(left,middle-1);
        
       TreeNode rootNode = new TreeNode(this.head.val);
        
       rootNode.left = leftNode;
       
        //Make sure to increment the pointer of head to its next as for now the head would be pointing at our rootNode
       this.head = this.head.next;
       
       rootNode.right = this.makeBST(middle+1, right);
    
       return rootNode;
       }
        */
    
}