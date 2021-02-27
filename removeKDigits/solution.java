/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        
        //We can use stack to implement this
        //Keep on adding values in stack and remove the peek if it is greater than the next value
        
        Stack<Character> stack = new Stack<>();
        int i=0;
        int len = num.length();
        
        if(k==len)
            return "0";
        
        while(i<len)
        {
            char ch = num.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.peek()>ch)
            {
                stack.pop();
                k--;
            }
            stack.push(ch);
            i++;
        }
        
        //This for some corner test cases like "112" and k =1
        //This ensures that the top of stack is removed until k is zero and returns the smallest possible string
        while(k>0)
        {
            stack.pop();
            k--;
        }
        
        StringBuilder s = new StringBuilder();
        
        //Append our string builder with the digits left in the stack that makes the minimum
        //Though the order would be in reverse than what is required so remember to reverse it
        while(!stack.isEmpty())
        {
            s.append(stack.pop());
        }
        
        //Remeber to remove any zeros added at the end (as order is reverse for now)
       // int end = s.length();
        while(s.length()>1 && s.charAt(s.length()-1)=='0')
        {
            s.deleteCharAt(s.length()-1);
        }
        
        return s.reverse().toString();
        
    }
}