/**
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root==null)
            return new ArrayList<>();
        
        targetSum = targetSum - root.val;
       
        
        if(targetSum==0 && root.left==null && root.right==null )
        {
            List<List<Integer>> toReturn = new ArrayList<>();
            List<Integer> value = new LinkedList();
            value.add(root.val);
            toReturn.add(value);
            return toReturn;
        }
        
         //Path through the left side of the tree        
        List<List<Integer>> left = pathSum(root.left, targetSum);
         //Path through the right side of the tree
        List<List<Integer>> right = pathSum(root.right, targetSum);
    
        
        //Iterating through left list and adding the elements
        for(int i=0; i<left.size(); i++)
        {
            left.get(i).add(0,root.val);
        }
       
        //Iterating through right list and adding the elements
        for(int i=0; i<right.size(); i++)
        {
            right.get(i).add(0,root.val);
        }
        
        return Merge(left,right);
    }
    

      public static  List<List<Integer>> Merge(List<List<Integer>> l,List<List<Integer>> r)
       {
        List<List<Integer>> ans=new LinkedList<>();
        
         for(int i=0;i<l.size();i++)
        {
           ans.add(l.get(i));
        }
        
        for(int i=0;i<r.size();i++)
        {
            ans.add(r.get(i));
        }
        
        return ans;
    }
}



