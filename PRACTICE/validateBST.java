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
        
        return isValidBSTHelper(root);
    }
    
    /*
    Idea is to use inorder traversal of our bst and compare the values with prev node, which in the starting would be the first node in inorder traversal (smallest value)
    */
    public boolean isValidBSTHelper(TreeNode root)
    {
        if(root!=null)
        {
            //Recursively check the left node of root
            if(!isValidBSTHelper(root.left))
                return false;
             
            //if the value of root is less than previous, return false
            if(prev!=null && root.val<=prev.val)
                return false;
            
            prev = root;
            
            //Return false if right side is invalid
            return isValidBSTHelper(root.right);
            
        }
        
        return true;
    }
}