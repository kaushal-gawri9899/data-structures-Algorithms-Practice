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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        //While deleting a tree node we need to take care of three major cases
        //   Node to be deleted is a leaf node : Just remove this node
        //   Node to be deleted has only one child : Copy the child to its node and then delete the child
        //   Node to be deleted has two children : First find the inorder successor of the given node, then copy contents of inorder successor of the given node and delete the inorder successor
        
        root = deleteHelper(root,key);
        
        return root;
    }
    
    private TreeNode deleteHelper(TreeNode root, int key)
    {
        if(root==null)
            return null;
        
        //We need to search for left side for key
        if(key<root.val)
            root.left = deleteHelper(root.left,key);
        
        else if(key>root.val)
            root.right = deleteHelper(root.right,key);
        
        //If key is similar to that of root, it is to be deleted
        else{
            
            //If node with one child and left is null
            if(root.left==null)
                return root.right;
            
            //If node with one child and right is null
            else if(root.right==null)
                return root.left;
            
            //When the node to be deleted has two children, we need to find its inorder successor in the right subtree (minimum value in right subtree)
            //Find the min value and make the key of root equal to min value
            root.val = getInOrderSuccessor(root.right);
            
            //Then delete the inorder successor
            root.right = deleteHelper(root.right,root.val);
            
            
        }
        return root;
    }
    
    //Find the minimum value from the children of the node to be deleted
    private int getInOrderSuccessor(TreeNode root)
    {
        
        int min = root.val;
        
        //Iterate at the end of all the left child of the given node and return the last value
        while(root.left!=null)
        {
            min = root.left.val;
            root=root.left;
        }
        
        return min;
    }
}