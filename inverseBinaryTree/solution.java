/**
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

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
    
    //Basic approach is to swap the nodes on every level
    //We can do level order traversal and then swap the nodes 
    public TreeNode invertTree(TreeNode root) {
        
        return traversal(root);

    }
    
    private TreeNode traversal(TreeNode root)
    {
        if(root==null)
            return null;
    
   
        TreeNode left = traversal(root.left);
        TreeNode right = traversal(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}