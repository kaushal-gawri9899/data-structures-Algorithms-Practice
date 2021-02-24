/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * /

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean pValid = false;
    boolean qValid = false;
   
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
     TreeNode lca = lowestCommonAncestorHelper(root,p,q);
       
      if(pValid && qValid)
           return lca;
      else
           return null;
   }
   
   /*A basic dfs approach handling the edge cases
    If the current node is the node p itself, we update our boolean variable and update the temp
    If the current node is the node q itself, we update our boolean variable and update the temp
    We now recursively call and pass the left and right node of our current root node
    If both left and right node are not null, root is the LCA
    If one of left or right is null, the other itself is the LCA
    
   */
   private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q)
   {
       if(root==null)
           return null;
           
       TreeNode temp = null;
       
       if(root==p)
       {
           pValid = true;
           temp = p;
       }
       
       if(root==q)
       {
           qValid = true;
           temp = q;
       }
       
       
       TreeNode leftNode = lowestCommonAncestorHelper(root.left,p,q);
       TreeNode rightNode = lowestCommonAncestorHelper(root.right,p,q);
       
       if(temp!=null)
           return temp;
       
       if(leftNode!=null && rightNode!=null)
       {
           return root;
       }
       
       if(leftNode!=null)
           return leftNode;
       
       else
           return rightNode;
   }
   
}