/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Input: 
 * A binary tree as following:
 *       4
 *     /   \
 *    2     6
 *   / \   / 
 *  3   1 5   
 *
 * v = 1
 * d = 2
 *
 * Output: 
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     / 
 *  3   1   5   
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
        
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        
        //If we need to add just at the root level
        if(d==1)
        {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }
        
        levelOrderTraversal(root,v,d, 1);
        
        return root;
    }
    
    private void levelOrderTraversal(TreeNode root, int v, int d, int level)
    {
        if(root==null)
            return;
        
        //If the current level is equal to depth-1, we update the values and our recursion is stopped
        //d-1 because we need to change the left and right nodes of node one level above the depth to our new node
        if(level==d-1)
        {
            //Store the current left of our root which is supposed to be the left of our new added node
            //Make the left of our root to our new node leftSide
            //Make the left of our new node leftSide to be equal to temp
            TreeNode leftSide = new TreeNode(v);
            TreeNode temp = root.left;
            root.left = leftSide;
            leftSide.left = temp;
            
            //Store the current right of our root which is supposed to be the right of our new added node
            //Make the right of our root to our new node rightSide
            //Make the right of our new node rightSide to be equal to temp
            TreeNode rightSide = new TreeNode(v);
            temp = root.right;
            root.right = rightSide;
            rightSide.right = temp;

        }
        else
        {
             levelOrderTraversal(root.left,v,d,level+1);
             levelOrderTraversal(root.right,v,d,level+1);
        }
        
    }
        
}