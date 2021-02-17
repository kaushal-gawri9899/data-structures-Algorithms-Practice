/**
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Input: root = [1,null,2,3]
Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> toReturn = new ArrayList();
        
        getInorderTraversal(root, toReturn);
        
        return toReturn;
        
    }
    
    private void getInorderTraversal(TreeNode root, List<Integer> toReturn)
    {
        if(root==null)
            return;
        
        //left subtree
        getInorderTraversal(root.left, toReturn);
        
        //visit root
        toReturn.add(root.val);
        
        //right subtree
        getInorderTraversal(root.right, toReturn);
        
        
    }
}