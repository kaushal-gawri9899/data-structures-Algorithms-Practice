class MyQueue {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();
    int front;
    
    /*
    The idea is to always push in the first stack whereas always remove from the second stack unless its empty
    stack 2 holds the element of stack 1 in reverse order and we add in stack2 only when it is empty and stack 1 is not empty
    */
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.empty())
            front = x;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty())
        {
            while(!stack1.empty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stack2.empty())
            return stack2.peek();
        
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */