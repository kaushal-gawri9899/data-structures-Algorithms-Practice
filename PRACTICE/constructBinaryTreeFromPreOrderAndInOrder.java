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
    int pos =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int index=0;
        
        for(int i : inorder)
            map.put(i,index++);
        
        return buildTreeHelper(preorder,inorder,map,0,inorder.length-1);
        
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, HashMap<Integer,Integer> map, int start, int end)
    {
     
        if(start>end)
            return null;
        
        int leftSide = map.get(preorder[pos]);
        
        TreeNode node = new TreeNode(preorder[pos++]);
        
        
        node.left = buildTreeHelper(preorder,inorder,map, start, leftSide-1);
        node.right = buildTreeHelper(preorder,inorder,map, leftSide+1, end);
            
        return node;
        
    }
}