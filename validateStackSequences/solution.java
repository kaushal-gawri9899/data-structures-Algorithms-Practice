/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        //Approach : Add the values in pushed array to our stack in order
        //Validate if the value just added in stack is equal to the value in popped, if true, pop that element from stack and increase the counter for popped array to point at next value to be popped, if the other counter is equal to length of pushed, it suggests that we were successful in making the stack empty and hence return true, else if the counter is less, probably some value couldn't be popped from stack because of their order in popped.
        
        int len = pushed.length;
        
        Stack<Integer> stack = new Stack();
        
        int j=0;
        for(int i : pushed)
        {
            stack.push(i);
            while(!stack.isEmpty() && stack.peek()==popped[j])
            {
                stack.pop();
                j++;
            }
        }
        
        //Only return true if we were successfully able to pop all the elements in order of popped from our stack
        if(j==len)
            return true;
        else
            return false;
    }
}