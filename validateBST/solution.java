/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Input: root = [2,1,3]
Output: true
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
    
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        prev = null;
        
        return isValid(root);
        
        
    }
    
    //Using in order traversal where first we check for left node, then visit the root and then check the right node
    private boolean isValid(TreeNode root)
    {
        
        if(root!=null)
        {
            //Check if left node is valid
            if(!isValid(root.left))
                return false;
            
            //Base Case to check if value is less than the previous node
            // Visiting root as in in order traversal
            if(prev!=null && root.val<=prev.val)
                return false;
            
            prev = root;
            
            return isValid(root.right);
        }
        
        return true;
        
    }
}