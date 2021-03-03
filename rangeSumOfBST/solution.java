/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root==null)
            return 0;
        
        if(root.val>high)
            return rangeSumBST(root.left,low,high);
        
        else if(root.val<low)
            return rangeSumBST(root.right,low,high);
        
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        
        
    }
    
   
}