/**
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Input: n = 3
Output: 5
 */

class Solution {
    public int numTrees(int n) {
        
        //Contsruct a binary tree with values ranging from 1 to n 
        // Look for all possible binary tree that can be created
        // Keep on iterating from 1 to n
        // If root = 1, if root = 2, if root = 3 ...... n
        
        //Let's say position i is the root, now i-1 would be a part of left subtree for node i and i+1 would be a part of right subtree (and so on until we reach n)(recursion)
        
        // We can do it where number of trees for a root say i could be number of trees for a root say i-1 * number of trees for a root say i+1
        
        //Hence we can recursively get the values for all the roots starting from 1 to n
        
        return getUniqueBinaryTree(1,n);
    
        //return getTreesUsingDP(n);
        
        
        
        //Dry run when n = 4
        // 1 --> 2 ----> 3 ------> 4
        // 1 --> 3 <----- 2 -------->4
        // 1 ----> 4 <----- 3 <------2
        // 1 ----->4 <------2 -------> 3
        
    }
    

    
    //As this recursive function do a lot of repetitive work, it is very slow and can be optimized using DP
    private int getUniqueBinaryTree(int start, int end)
    {
        //That is only 1 root node for the tree, or n =1
        if(start>=end)
            return 1;
        
        int result = 0;
        
        for(int i=start; i<=end; i++)
        {
            result+=getUniqueBinaryTree(start,i-1)*getUniqueBinaryTree(i+1,end);
        }
        
        return result;
    }
    
//     private int getTreesUsingDP(int n)
//     {
//         int[] dp =  new int[n+1];
//         dp[0] = 1;
//         dp[1] = 1;
        
//         for(int start=2; start<=n; start++)
//         {
//             for(int root=1; root<=start; root++)
//             {
//                 dp[start]+=dp[root-1]*dp[start-root];
                
//             }
//         }
        
//         return dp[n];
//     }
    
   

}