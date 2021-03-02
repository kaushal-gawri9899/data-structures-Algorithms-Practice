/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false 
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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null)
            return false;
        
        //I would be using a BFS approach
        //Add the root node to our queue
        //Iterate in our queue, search for all children nodes
        //If x is equal to current value, make boolean true
        //If y is equal to current value, make boolean true
        
        //If the right and left of current are not null and either left and right of current are equal to x and y that is they share the same parent and on same level, return false
        // Add the left and right of current to our queue
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            boolean isXPresent = false;
            boolean isYPresent = false;
            int size = queue.size();
            while(size>0)
            {
                size--;
                
                TreeNode current = queue.poll();
                
                if(current.val==x)
                    isXPresent=true;
                
                if(current.val==y)
                    isYPresent=true;
                
                if(current.left!=null && current.right!=null)
                {
                    if((current.left.val==x && current.right.val==y)||(current.right.val==x && current.left.val==y)){
                        return false;
                    }
                }
                
                if(current.left!=null)
                    queue.offer(current.left);
                
                if(current.right!=null)
                    queue.offer(current.right);
                    
                }
            
            if(isXPresent && isYPresent)
                return true;
            
            else if(isXPresent || isYPresent)
                return false;
            
            }
        return false;
        }
}