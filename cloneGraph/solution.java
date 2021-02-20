/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * 
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private HashMap<Integer,Node> graph = new HashMap<>();
    
    public Node cloneGraph(Node node) {
       
        return  cloneGraphHelper(node);
       
    }
    //DFS
    
    public Node cloneGraphHelper(Node node)
    {
        if(node == null)
            return null;
        
        //Checks if the current node is already added in the hashmap and thus already connected
        if(graph.containsKey(node.val))
            return graph.get(node.val);
        
        //Creates a new node with value similar to node(We aren't referencing the newNode with current node because of deep copy)
        Node currNode = new Node(node.val, new ArrayList<Node>());
        
        //Adds the currNode in our map
        graph.put(currNode.val, currNode);
        
        //Iterate over the neighbours of the node and update neighbors of current node      recurisively
        for(Node current : node.neighbors)
        {
                currNode.neighbors.add(cloneGraphHelper(current));
        }
        
        return currNode;
    }
}