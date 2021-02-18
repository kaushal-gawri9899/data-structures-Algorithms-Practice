/**
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

return 
[3,9,20,null,null,15,7]


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
    
    int ptr=0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        HashMap<Integer,Integer> makeTree = new HashMap<>();
        
        int index=0;
        for(int i=0; i<inorder.length; i++)
        {
            //mark the index of the different values in inorder array for our tree
            makeTree.put(inorder[i],index++);   
        }
        
        return buildTreeHelper(preorder,inorder,0,inorder.length-1,makeTree);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end, Map<Integer,Integer> makeTree)
    {
        if(start>end)
            return null;
        
        //Retreive the next value from preorder array
        int leftSide = makeTree.get(preorder[ptr]);
        
        TreeNode newNode = new TreeNode(preorder[ptr++]);
        
        newNode.left = buildTreeHelper(preorder,inorder,start,leftSide-1,makeTree);
        newNode.right = buildTreeHelper(preorder,inorder,leftSide+1,end,makeTree);
        
        return newNode;
        
    }

    
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
        
//         if (preorder.length == 0) return null;
        
//         TreeNode toReturn = new TreeNode(preorder[0]);
        
//         Stack<TreeNode> nodes = new Stack<>();
//         TreeNode current = toReturn;
        
        //We iterate through our preorder array and use a stack for backtracking
        // We check if the current node is similar to the position-1 in inorder
        // if not, we make that node the left node of current, push in stack and update current with this node and increment 1
        
        // if yes, we increment j to the next position in inorder array and check until we get the value of element at top of stack equal to current position inorder
        // if so, we remove that value from stack to backtrack and increment j and update current with this value
//         for(int i=1,j=0; i<preorder.length; i++)
//         {

//             if(current.val!=inorder[j])
//             {
//                 current.left = new TreeNode(preorder[i]);
//                 nodes.push(current);
//                 current = current.left;
//             }
//             else{
//                 j++;
//                 while(!nodes.empty() && nodes.peek().val==inorder[j])
//                 {
//                     current = nodes.pop();
//                     j++;
//                 }
//                 current = current.right = new TreeNode(preorder[i]);;
//             }
            
//         }
        
//         return toReturn;
//     }
    
    
}