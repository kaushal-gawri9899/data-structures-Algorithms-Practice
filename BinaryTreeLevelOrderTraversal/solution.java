/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7]
return its traversal as
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        List<List<Integer>> result = new ArrayList();
        getLevelOrder(root,0,result);
        
        return result;
    }
    
    
    //Basic Approach is to first add the root of the tree then move left and move right
    private void getLevelOrder(TreeNode root, int index, List<List<Integer>> result)
    {
        if(root==null)
            return;
        
        //This if check makes sure that no empty lists(for null left and right roots) are added
        if(index>=result.size())
         result.add(new ArrayList<Integer>());
        
        //adds the current value at required index of the result list
        result.get(index).add(root.val);
        
        getLevelOrder(root.left, index+1,result);
        getLevelOrder(root.right, index+1,result);
       
    }
}