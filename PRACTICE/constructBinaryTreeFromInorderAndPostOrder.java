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
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int index=0;
        for(int i : inorder)
        {
            map.put(i, index++);
        }
        
        return buildTreeHelper(inorder, postorder, 0, 0, inorder.length-1, postorder.length-1, map);
        
        
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int postStart, int inEnd, int postEnd, HashMap<Integer,Integer> map)
    {
        
        if(inStart>inEnd || postStart>postEnd)
            return null;
        
        int leftSide = map.get(postorder[postEnd]);
        
        TreeNode node = new TreeNode(postorder[postEnd]);
        
        node.left = buildTreeHelper(inorder, postorder, inStart, postStart,leftSide-1,postStart+leftSide-inStart-1,map);
        
        node.right = buildTreeHelper(inorder, postorder, leftSide+1, postStart+leftSide-inStart, inEnd,postEnd-1,map);
        
        return node;
        
    }
}