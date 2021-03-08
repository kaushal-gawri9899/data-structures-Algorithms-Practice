/**
 * Input: s = "()"
 * Output: true
 * 
 * Input: s = "([)]"
 * Output: false
 */
class Solution {
    public boolean isValid(String s) {
        
        /*
        We can use a stack to add only closing type of each parentheses if a char which is an open type of parentheses is encountered
        But by chance if we find the closing type of any parentheses, we need to check if the stack is empty or if the top element in the stack is not equal to the current char (if true, string isn't valid)
        Also, at the end, for valid parentheses we need to have our stack to be empty(if euqal number of left and right parentheses are added)thus we return that
        */
        
        Stack<Character> stack = new Stack<Character>();
        
        char[] arr = s.toCharArray();
        
        for(char ch : arr)
        {
            if(ch=='(')
                stack.push(')');
            else if(ch=='{')
                stack.push('}');
            else if(ch=='[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop()!=ch)
                return false;
        }
        
        return stack.isEmpty();
    }
}