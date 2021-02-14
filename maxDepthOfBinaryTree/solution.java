/**
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        
        int maxDepth = getMaxDepth(root);
        return maxDepth;
        
    }
    
    private int getMaxDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int leftSideLength = 0;
        int rightSideLength = 0;
        
        // if(root.left!=null)
             leftSideLength = getMaxDepth(root.left);
        // if(root.right!=null)
             rightSideLength = getMaxDepth(root.right);
        
        if(leftSideLength > rightSideLength)
            return leftSideLength+1;
        else
            return rightSideLength+1;
    }
}