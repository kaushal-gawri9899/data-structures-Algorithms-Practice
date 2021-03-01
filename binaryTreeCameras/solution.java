/**
 * Given a binary tree, we install cameras on the nodes of the tree. 
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 * Input: [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed. Create a figure
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
        
    int count =0;
    
    /*
    Approach : Consider the root of the tree, for it the camera can either be placed at itself, or on any of its two children. Thus total of 3 possible solution
               
               Consider any node of a tree. For this the camera can either be placed at itself, or its parent or at any of its two children. Thus total of 4 possible solution
               
               Consider the leaf of a tree(having no children). For this the camera can either be placed at its parent or itself. Thus total of 2 possible solution
               
               Now say we have the camera at the leaf only. In this case it can monitor itself and its parent
               If we have the camera at the parent of the leaf, in this case it can monitor itself, the leaf and its sibling.
               Thus, option two is better 
               
    So, we need to derive of a solution that lets us add the cameras at the parent of a given leaf. To do this we can use dfs to traverse in our tree, add cameras to the leaf's parent and remove all the nodes that are covered yet and then do it again until all the nodes are covered
    
    
    */

// Lets say if a node needs a camera that is it is a node having a child as leaf, we increase the count and return "Covering"
// Lets say it is covered, that is a node having a child whose a parent of leaf node, we return "Covered"
//Else we return "Not_Covered"
public int minCameraCover(TreeNode root) {
    
    //If Not_Covered is returned, it means that we need to make our root covered and hence we increase the count by 1
    if(dfs(root).equals("Not_Covered"))
        return count+1;
    //If Not_Covered is not returned, our root is already covered and we just return the count
    else
        return count;

    
}

private String dfs(TreeNode root)
{
    if(root==null)
    {
        return "Covered";
    }
    
    String left = dfs(root.left);
    String right = dfs(root.right);
    
    //As the returned value is "Not_Covered", it means the given node is not covered and thus we increase the count and return "Covering" (returning this works like marking this node)
    if(left.equals("Not_Covered") || right.equals("Not_Covered"))
    {
        this.count++;
        return "Covering";
    }
    
    //It means the node is being covered, thus we return "Covered"
    if(left.equals("Covering") || right.equals("Covering"))
        return "Covered";
    //The node is not covered and hence return "Not_Covered"
    else
        return "Not_Covered";
}
}