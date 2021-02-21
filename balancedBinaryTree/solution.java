/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * 
 * 
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
    
    public boolean isBalanced(TreeNode root)
    {
        return validateHeight(root)!=-1;
    }

    private int validateHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int leftHeight = validateHeight(root.left);
        
        if(leftHeight==-1)
            return -1;
        
        int rightHeight = validateHeight(root.right);
        if(rightHeight==-1)
            return -1;
        
        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
        
        return 1+Math.max(leftHeight,rightHeight);
    }


//   O(nlogn) --> slower approach as tree multiple times traverses a single child
//     public boolean isBalanced(TreeNode root) {
    
//        int leftCount=0;
//         int rightCount=0;
    
//         if(root==null)
//             return true;
    
//         leftCount = getHeight(root.left);
//         rightCount = getHeight(root.right);
    
//         if(Math.abs(leftCount-rightCount)<=1 && isBalanced(root.left) && isBalanced(root.right))
//             return true;
    
//         return false;
//     }


//     private int getHeight(TreeNode root){
    
//         if(root==null)
//             return 0;
        
//         return 1 + Math.max(getHeight(root.left),getHeight(root.right));
//     }
}