/**
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        //Start from the root and iterate in the tree
        //Reduce the value of targetSum by decreasing root value
        //Such that when targetSum is zero, path found
        if(root == null){
            return false;
        }
        
        targetSum = targetSum - root.val;
        if(root.left==null && root.right==null && targetSum==0)
        {
            return true;
        }
        
       boolean left = hasPathSum(root.left, targetSum);
       boolean right = hasPathSum(root.right, targetSum);
        
       if(left==true || right ==true)
           return true;
       else
           return false;
        
        
    }
}