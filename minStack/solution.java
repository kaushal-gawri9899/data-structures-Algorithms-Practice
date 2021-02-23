/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 */
class MinStack {
    
    private StackNode node;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
       //empty stack, create a new node with val and min = x
        
        if(node==null)
             node = new StackNode(x,x,null);

               //already node is present create a new node with val= x, min = minimum of current and node, next = head(as stack follows LIFO) so next of new node would be the earlier node
        
        else
            node = new StackNode(x, Math.min(x,node.min), node);
    }
    
    public void pop() {
        //re-reference the pointer of current node to its next to pop a node
        node = node.next_node;
    }
    
    public int top() {
       return node.val;
    }
    
    public int getMin() {
        return node.min;
    }
    
    
    private class StackNode{
        
        int val;
        int min;
        StackNode next_node;
        
        private StackNode(int val, int min, StackNode next_node){
            this.val=val;
            this.min=min;
            this.next_node = next_node;
        }
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */