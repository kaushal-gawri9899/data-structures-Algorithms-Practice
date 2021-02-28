/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
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
    
    HashMap<TreeNode,Integer> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //First we need to find our target node. We need to store the path while finding our target node say in a hashmap where we store the distance from all the nodes to our target node
        //Then we can use dfs to travel and return all nodes that match the distance K
        
        searchNode(root,target);
        List<Integer> solution = new LinkedList();
        int path = map.get(root);
        
        dfs(root,target,K, map.get(root), solution);
        return solution;
        
    }
    
    private int searchNode(TreeNode root, TreeNode target)
    {
        if(root==null)
            return -1;
            
        //If we found the node, add it to our map
        if(root==target)
        {
            map.put(root,0);
            return 0;
        }
        
        int leftView = searchNode(root.left, target);
        if(leftView>=0)
        {
            //If the target is present in the left side of tree, add the node in our map with distance
            map.put(root,leftView+1);
            return leftView+1;
        }
        
        int rightView = searchNode(root.right, target);
        if(rightView>=0)
        {
            //If the target is present in the right side of tree, add the node in our map with distance
            map.put(root,rightView+1);
            return rightView+1;
        }
            
        return -1;
    }
    
    private void dfs(TreeNode root, TreeNode target, int k, int path, List<Integer> solution)
    {
        
        
        if(root==null)
            return;
        
       
        //base case to retrieve distance of root from target from our map 
        if(map.containsKey(root))
            path=map.get(root);
        
        //Is distance is equal to k, add the node in the list
        if(path==k)
            solution.add(root.val);
        
        dfs(root.left,target,k,path+1,solution);
        dfs(root.right,target,k,path+1,solution);
    }
}