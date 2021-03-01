/**
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n coins total.
 * In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent to child, or from child to parent.)
 * Return the number of moves required to make every node have exactly one coin.
 * 
 * Input: root = [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
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
    int moveMent = 0;
   
    public int distributeCoins(TreeNode root) {
        
        dfs(root);
        return moveMent;
        
    }
    
    //Say if the node lacks one coin,(return value would be -1 and Math.abs() takes caree of negation and hence increment the moves by 1 in this case) we give that node a coin from its parent and then we don't need to worry about it. 
    //Say if the node has 2 excees coins than what it requires(3 coins in total but just requires one), then the return value would be 2 and we give these two coins to its parent and hence the movement is now increased again by 2. Thus number of movements from a leaf to or from its parent would be Math.abs(number of coins - 1) (-1 because we need to have atleast one coin to every node). (Say a node has exacty one coin, thus it doesn't require a movement and Matg.abs(1-1) would be anyhow zero and hence no movement incremented). Now as a node will have its right and left substrees, the total movement we make from this node to or from its children is Math.abs(leftValue) + Math.abs(rightValue). Thus the number of excess nodes for this node would be node.val + leftValue + rightValue - 1 where (node.val + leftValue + rightValue -----> number of coins) (say a node has 3 total coins and the left side requires 1 and the right side requires 1 and thus excess coin would be 3 + 0 + 0 -1 = 2 (as left and right have 0 coins)    
    private int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);
        
        moveMent+= Math.abs(leftValue) + Math.abs(rightValue);
        
        return root.val + leftValue + rightValue-1;
    }
    
    //Without using the global variable
//     public int distributeCoins(TreeNode root)
//     {
//         int move = 0;
        
//         if(root.left!=null)
//         {
//             move+=distributeCoins(root.left);
//             root.val+=root.left.val-1;
//             move+=Math.abs(root.left.val-1);
//         }
            
//         if(root.right!=null)
//         {
//             move+=distributeCoins(root.right);
//             root.val+=root.right.val-1;
//             move+=Math.abs(root.right.val-1);
//         }
        
//         return move;
//   }
}