/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList();
        rightSideViewHelper(root,list,0);
        return list;
    }
    
    private void rightSideViewHelper(TreeNode root, List<Integer> list, int level)
    {
        if(root==null)
            return;
        
        if(level==list.size())
           list.add(root.val);
        
        rightSideViewHelper(root.right, list, level+1);
        rightSideViewHelper(root.left, list, level+1);
    }
}