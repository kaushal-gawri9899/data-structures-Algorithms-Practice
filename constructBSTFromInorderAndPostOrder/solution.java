/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int index=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : inorder)
            map.put(i,index++);
        
        //Pass the index as last for postorder array as the root will be the last element in post order array so start from there
        
        return buildTreeHelper(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
        
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer,Integer> map)
    {
        if(inStart>inEnd || postStart>postEnd)
            return null;
        
           int leftSide = map.get(postorder[postEnd]);
        
           TreeNode node = new TreeNode(postorder[postEnd]);
        
            node.left = buildTreeHelper(inorder,postorder,inStart,leftSide-1, postStart, postStart+leftSide-inStart-1,map);
            node.right = buildTreeHelper(inorder, postorder, leftSide+1, inEnd, postStart+leftSide-inStart,postEnd-1,map);

        return node;
    }
}